package com.smartlogix.order.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue shipmentQueue() {
        // Creamos una cola llamada "cola.envios" que sea durable
        return new Queue("cola.envios", true);
    }
}