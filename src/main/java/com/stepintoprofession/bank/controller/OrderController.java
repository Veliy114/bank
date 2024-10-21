package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.model.dto.OrderDto;
import com.stepintoprofession.bank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto) {
        return ResponseEntity.ok(orderService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> status(@PathVariable("id") UUID id) {
        OrderDto result = orderService.status(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
