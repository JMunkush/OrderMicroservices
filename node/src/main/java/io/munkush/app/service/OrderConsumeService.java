package io.munkush.app.service;

import io.munkush.app.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static io.munkush.app.RabbitMQUtil.QUEUE_MANAGER;
import static io.munkush.app.RabbitMQUtil.QUEUE_USER;

@Service
@RequiredArgsConstructor
public class OrderConsumeService {

    private final OrderAnswerService answerService;

    @RabbitListener(queues = QUEUE_USER)
    public void consumeUser(OrderRequest orderRequest){
        String body = orderRequest.getOrderName() + ":" +  "ACCEPTED";
        answerService.produce(body);
    }

    @RabbitListener(queues = QUEUE_MANAGER)
    public void consumeManager(OrderRequest orderRequest){
        String body = orderRequest.getOrderName() + ":" +  "ACCEPTED";
        answerService.produce(body);
    }


}
