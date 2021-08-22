package com.mellow.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrderListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(new String(message.getBody()));
            System.out.println("订单信息!");
            System.out.println("对订单判断，伪代码");
            channel.basicAck(deliveryTag,true);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag,true,true);
        }
    }
}
