package io.munkush.app.controller;

import io.munkush.app.OrderRequest;
import io.munkush.app.service.OrderProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    public static final List<String> orders = new ArrayList<>();

    private final OrderProducerService producerService;

    @GetMapping
    public List<String> getOrders(){
        return orders;
    }
    @PostMapping
    public String postOrder(@RequestBody OrderRequest orderRequest){
        producerService.produce(orderRequest);
        return "order accepted";
    }
}
