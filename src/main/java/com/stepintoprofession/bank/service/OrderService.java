package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.model.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    private final Map<UUID, OrderDto> repo = new HashMap<>();

    public OrderDto create(OrderDto dto) {
        dto.setId(UUID.randomUUID());
        dto.setDate(new Date());
        dto.setStatus("В процессе");
        repo.put(dto.getId(), dto);
        return dto;
    }

    public OrderDto status(UUID id) {
        return repo.get(id);
    }
}
