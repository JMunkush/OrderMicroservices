package io.munkush.app.service;

import io.munkush.app.controller.OrderController;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static io.munkush.app.RabbitMQUtil.QUEUE_ANSWER;

@Service
public class AnswerConsumeService {

    @RabbitListener(queues = QUEUE_ANSWER)
    public void consume(String body){
        OrderController.orders.add(body);
    }
}
