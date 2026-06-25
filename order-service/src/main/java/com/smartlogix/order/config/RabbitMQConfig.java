package com.smartlogix.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // 1. Definimos el nombre de la cola y del exchange
    public static final String SHIPMENT_QUEUE = "cola.envios";
    public static final String ORDER_EXCHANGE = "exchange.ordenes";
    public static final String ROUTING_KEY = "orden.creada";

    @Bean
    public Queue shipmentQueue() {
        return new Queue(SHIPMENT_QUEUE, true); // Durable
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(ORDER_EXCHANGE);
    }

    // 2. Vinculamos la cola al exchange usando una clave de enrutamiento (Routing Key)
    @Bean
    public Binding binding(Queue shipmentQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(shipmentQueue).to(orderExchange).with(ROUTING_KEY);
    }
}