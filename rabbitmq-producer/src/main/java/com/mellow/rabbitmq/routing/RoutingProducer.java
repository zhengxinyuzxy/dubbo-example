package com.mellow.rabbitmq.routing;

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

public class RoutingProducer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String exchangeName = "test_direct_exchange";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT,true,false,null);

        String directQueue01 = "test_direct_queue01";
        String directQueue02 = "test_direct_queue02";

        channel.queueDeclare(directQueue01,true,false,false,null);
        channel.queueDeclare(directQueue02,true,false,false,null);

        channel.queueBind(directQueue01,exchangeName,"error");
        channel.queueBind(directQueue02,exchangeName,"info");
        channel.queueBind(directQueue02,exchangeName,"error");
        channel.queueBind(directQueue02,exchangeName,"warning");

        String message = "日志信息：张三调用了delete方法.错误了,日志级别error";
        channel.basicPublish(exchangeName,"error",null,message.getBytes());

        channel.close();
        connection.close();
    }
}
