package com.jk.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Iterator;


@Configurable
public class RebbitMqConfig {

    @Configuration
    public class RabbitMQConfig {


        @Bean
        public Queue logQueue() {
            return new Queue("5_xiao");
        }

        @Bean
        public FanoutExchange fanoutExchange() {
            return new FanoutExchange("fanoutExchange");
        }

        @Bean
        public Binding bindingAckQueue2Exchange(Queue logQueue, FanoutExchange fanoutExchange) {
            return BindingBuilder.bind(logQueue).to(fanoutExchange);
        }
    }
}
