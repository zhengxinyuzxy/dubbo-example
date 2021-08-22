package com.mellow.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    public static final String EXCHANGE_NAME = "boot_exchange_topic";
    public static final String QUEUE_NAME = "boot_queue";

    @Bean
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    @Bean
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public Binding bindingExchangeAndQueue(@Qualifier("bootExchange") Exchange exchange,@Qualifier("bootQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.*").noargs();
    }

}
