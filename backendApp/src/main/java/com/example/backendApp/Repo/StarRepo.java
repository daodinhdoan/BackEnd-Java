package com.example.backendApp.Repo;

import com.example.backendApp.Models.Star;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StarRepo extends JpaRepository<Star ,Long> {
    List<Star> findAllByProductIdAndType(Long idProduct, String type);
    List<Star> findAllByProductId(Long idProduct);
}
