package io.munkush.app.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.munkush.app.RabbitMQUtil.*;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }


    // Создаем Exchange
    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(ORDER_EXCHANGE);
    }

    // Создаем Очередь для пользователей
    @Bean
    public Queue userQueue() {
        return new Queue(QUEUE_USER);
    }
    @Bean
    public Queue answerQueue() {
        return new Queue(QUEUE_ANSWER);
    }

    // Создаем Очередь для менеджеров
    @Bean
    public Queue managerQueue() {
        return new Queue(QUEUE_MANAGER);
    }

    // привязываем
    @Bean
    public Binding userBinding(Queue userQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(userQueue).to(orderExchange).with(USER_ROUTING_KEY);
    }

    // привязываем
    @Bean
    public Binding managerBinding(Queue managerQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(managerQueue).to(orderExchange).with(MANAGER_ROUTING_KEY);
    }

}
