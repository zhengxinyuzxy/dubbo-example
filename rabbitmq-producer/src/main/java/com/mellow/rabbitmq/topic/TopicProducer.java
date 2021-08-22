package com.mellow.rabbitmq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class TopicProducer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        // 声明交换机
        String exchangeName = "test_topic_exchange";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, false, false, null);
        // 声明队列
        String queue01 = "test_topic_queue01";
        String queue02 = "test_topic_queue02";
        channel.queueDeclare(queue01, true, false, false, null);
        channel.queueDeclare(queue02, true, false, false, null);

        // 绑定交换机和队列
        channel.queueBind(queue01, exchangeName, "#.error");
        channel.queueBind(queue02, exchangeName, "order.*");
        channel.queueBind(queue01, exchangeName, "*.*");

        // 发布队列
        String message = "topic测试 => 日志信息：张三调用了findAll方法...日志级别：info...";
        channel.basicPublish(exchangeName,"order.info",null,message.getBytes());

        // 关闭连接
        channel.close();
        connection.close();
    }
}
