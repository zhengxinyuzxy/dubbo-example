package com.mellow.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimpleProducer {
    public static void main(String[] args) throws Exception {
        // 获取连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 获取主机地址
        connectionFactory.setHost("localhost");
        // 获取端口
        connectionFactory.setPort(5672);
        // 获取虚拟主机
        connectionFactory.setVirtualHost("/");
        // 获取登录名
        connectionFactory.setUsername("guest");
        // 获取登录密码
        connectionFactory.setPassword("guest");
        // 创建连接
        Connection connection = connectionFactory.newConnection();
        // 获取频道线程一个channel
        Channel channel = connection.createChannel();
        // 默认提供交换机exchange，此处不需要exchange
        // 获取队列的列表
        channel.queueDeclare(
                // 队列的名字
                "simple01_queue",
                // 是否持久化
                true,
                // 是否独占连接
                false,
                // 是否自动删除
                false,
                // 是否需要参数
                null
        );
        // 消息体
        String message = "hi,rabbitmq";
        // 向消息队列发送消息
        channel.basicPublish(
                // 交换机名
                "",
                // 路由规则
                "simple01_queue",
                // 基础参数
                null,
                // 消息体
                message.getBytes()

        );
        // 关闭消息队列
        channel.close();
        // 关闭连接
        connection.close();

    }
}
