package com.example.backendApp.Service.impl;

import com.example.backendApp.Models.OrderProduct;
import com.example.backendApp.Repo.OrderRepo;
import com.example.backendApp.Service.OrderProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductImpl implements OrderProductServices {
    @Autowired
    private OrderRepo orderProductRepository;

    @Override
    public List<OrderProduct> findAll() {
        return orderProductRepository.findAll();
    }

    @Override
    public Optional<OrderProduct> findById(Long id) {
        return orderProductRepository.findById(id);
    }

    @Override
    public void save(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }

    @Override
    public void delete(Long id) {
        orderProductRepository.deleteById(id);
    }
}
