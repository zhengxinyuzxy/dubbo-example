package com.mellow.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;


@Component
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(new String(message.getBody()));
            // 业务逻辑
            System.out.println("业务");
            // 假设业务出现异常
            int a = 10/0;
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag,true,true);
        }
    }
    /*@Override
    public void onMessage(Message message) {
        System.out.println(new String(message.getBody()));

    }*/
}
