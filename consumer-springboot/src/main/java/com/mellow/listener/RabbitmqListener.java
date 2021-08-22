package com.mellow.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;



@Component
public class RabbitmqListener implements ChannelAwareMessageListener{

    /*@RabbitListener(queues = "boot_queue")
    public void queueListener(Message message) {
        System.out.println(new String(message.getBody()));
    }*/

    @Override
    @RabbitListener(queues = "boot_queue")
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(new String(message.getBody()));
            System.out.println("业务逻辑，判断订单是否异常，无异常签收确认");
            channel.basicAck(deliveryTag,true);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag, true, true);
        }

    }
}
