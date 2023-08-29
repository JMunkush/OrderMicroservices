package io.munkush.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static io.munkush.app.RabbitMQUtil.QUEUE_ANSWER;

@Service
@RequiredArgsConstructor
public class OrderAnswerService {


    private final RabbitTemplate rabbitTemplate;
    public void produce(String body){
        rabbitTemplate.convertAndSend(QUEUE_ANSWER, body);
    }
}
