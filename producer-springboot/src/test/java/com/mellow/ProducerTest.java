package com.mellow;

import com.mellow.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void tes02() {

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

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, "boot.abc", "direct定向发送消息！");
    }

    @Test
    public void testSpringBootAndRabbitmq() {
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME,"boot.abc","生产者springbootandrabbitmq");
    }
}
