package com.smartlogix.order.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.smartlogix.order.model.OrderRequest;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void crearPedido(OrderRequest request) {
        // ... tu lógica actual para guardar la orden en H2 ...

        // Enviamos un mensaje de texto simple (o un JSON string) a la cola
        String mensaje = "Nueva orden creada: " + request.getOrderNumber();
        rabbitTemplate.convertAndSend("cola.envios", mensaje);

        System.out.println("--- Mensaje enviado a RabbitMQ! ---");
    }
}