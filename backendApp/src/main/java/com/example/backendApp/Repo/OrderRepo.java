package com.example.backendApp.Repo;

import com.example.backendApp.Models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderProduct,Long> {
}
