package com.example.backendApp.Repo;

import com.example.backendApp.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ProductRepo extends JpaRepository<Product , Long> {
    Set<Product> findAllByIdProductIn(List<Long> id);

    @Modifying
    @Query(value = "select * from product where is_delete = false and status = 'Hoạt động' and quantity > 0", nativeQuery = true)
    List<Product> getAllProduct();
}
