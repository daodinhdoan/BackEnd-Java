package com.example.backendApp.Controller;

import com.example.backendApp.Constant.Constant;
import com.example.backendApp.Models.Star;
import com.example.backendApp.Models.User;
import com.example.backendApp.Repo.UserRepo;
import com.example.backendApp.Service.StarService;
import com.example.backendApp.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class StarController {
    @Autowired
    private StarService starService;

    // Xem tất cả đánh giá của 1 sản phẩm
    @GetMapping("/get-star")
    public ResponseEntity<?> getAllStarByProduct(@RequestParam Long idProduct) {
        try {
            List<Star> list = starService.findAllByProductId(idProduct);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Xem đánh giá của sản phẩm theo số sao
    @GetMapping("/get-star-by-type")
    public ResponseEntity<?> getAllStarByProductAndType(@RequestParam Long idProduct, @RequestParam String type) {
        try {
            List<Star> list = starService.findAllByProductIdAndType(idProduct, type);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Tạo mới đánh giá
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam Long idProduct, @RequestParam Long idUser, @RequestParam String type) {
        try {
            Star star = starService.initStar(idUser, idProduct, type);
            starService.save(star);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
