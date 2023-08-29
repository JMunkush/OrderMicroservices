package io.munkush.app.service;

import io.munkush.app.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducerService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(OrderRequest order){
        String routingKey = order.isManager() ? "manager" : "user";
        rabbitTemplate.convertAndSend("orderExchange", routingKey, order);
    }
}
