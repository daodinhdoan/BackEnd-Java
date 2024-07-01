package com.example.backendApp.Repo;

import com.example.backendApp.Models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
