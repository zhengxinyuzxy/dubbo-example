package com.mellow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试延迟队列
     */
    public void test06() {
        rabbitTemplate.convertAndSend("order_exchange","order.*", "延迟队列消息发送了");
    }

    /**
     * 测试多个消息是死信队列的模式
     */
    @Test
    public void test05() {
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.abc", "多个消息的死信队列");

        }
    }

    /**
     * 测试死信队列
     */
    @Test
    public void test04() {
        rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.abc", "死信队列发送了，请看rabbitmq management");
    }

    /**
     * 测试过期时间，TTL time to live
     */
    @Test
    public void test03() {
        rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.abc", "ttl过期时间，存活时间time to live");
    }

    /**
     * 消费者限流 prefetch表示每次从队列拿出一条消息，手动确认后，才会在次拿消息
     */
    @Test
    public void test02() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("text_confirm_exchange", "confirm", "流量削峰");
        }
    }

    /**
     * 确认机制和回退机制，都是生产者一端
     * setConfirmCallback和setReturnCallback
     * 需要消费者一端，basicAck手动签收，对于出现消息出现问题时，basicNack
     */
    @Test
    public void tes01() {

        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("message:" + new String(message.getBody()));
                System.out.println("replyCode:" + replyCode);
                System.out.println("replyText:" + replyText);
                System.out.println("exchange:" + exchange);
                System.out.println("routingKey:" + routingKey);
            }
        });

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if (b) {
                    System.out.println("ask签收成功");
                } else {
                    System.out.println("ask签收失败" + "cause:" + s);
                }
            }
        });

        rabbitTemplate.convertAndSend("text_confirm_exchange", "confirm", "direct定向发送消息！");
    }
}
