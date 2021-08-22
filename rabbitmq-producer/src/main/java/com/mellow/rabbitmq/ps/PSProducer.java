package com.mellow.rabbitmq.ps;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class PSProducer {
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
        // 创建交换机
        String exchangeName = "test_fanout_exchange";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT,true,false,false,null);
        // 创建队列
        String fanout_queue01 = "test_fanout_queue01";
        String fanout_queue02 = "test_fanout_queue02";
        // 获取queue01队列的列表
        channel.queueDeclare(
                // 队列的名字
                fanout_queue01,
                // 是否持久化
                true,
                // 是否独占连接
                false,
                // 是否自动删除
                false,
                // 是否需要参数
                null
        );
        // 获取queue02队列的列表
        channel.queueDeclare(
                // 队列的名字
                fanout_queue02,
                // 是否持久化
                true,
                // 是否独占连接
                false,
                // 是否自动删除
                false,
                // 是否需要参数
                null
        );
        // 交换机绑定队列
        channel.queueBind(fanout_queue01, exchangeName, "");
        channel.queueBind(fanout_queue02, exchangeName, "");
        // 消息体
        String message = "Publish/Subscribe发布与订阅模式";
        // 向消息队列发送消息
        channel.basicPublish(
                // 交换机名
                exchangeName,
                // 路由规则
                "",
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
