package com.example.backendApp.Service;

import com.example.backendApp.Models.OrderProduct;

import java.util.List;
import java.util.Optional;

public interface OrderProductServices {
    List<OrderProduct> findAll();

    Optional<OrderProduct> findById(Long id);

    void save(OrderProduct orderProduct);

    void delete(Long id);
}
