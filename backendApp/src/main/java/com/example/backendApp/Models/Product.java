package com.example.backendApp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    // Tên sản phẩm
    private String productName;
    // Giá sản phẩm
    private String price;
    // Số lượng
    private int quantity;
    // Trạng thái
    private String status;
    // Đã xóa
    private boolean isDelete;
}
