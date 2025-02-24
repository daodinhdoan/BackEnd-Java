package com.example.backendApp.Service;

import com.example.backendApp.Models.Star;

import java.util.List;
import java.util.Optional;

public interface StarService {
    List<Star> findAll();

    Optional<Star> findById(Long id);

    void save(Star star);

    void delete(Long id);

    List<Star> findAllByProductIdAndType(Long idProduct, String type);
    List<Star> findAllByProductId(Long idProduct);

    Star initStar(Long idUser, Long idProduct, String type) throws Exception;
}
