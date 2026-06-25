package com.smartlogix.order.service; // Paquete corregido

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartlogix.order.model.OrderRequest;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void crearPedido(OrderRequest request) {
        // Tu lógica para guardar la orden en H2...

        String mensaje = "Nueva orden creada: " + request.getOrderNumber();
        rabbitTemplate.convertAndSend("cola.envios", mensaje);

        System.out.println("--- Mensaje enviado a RabbitMQ! ---");
    }
}