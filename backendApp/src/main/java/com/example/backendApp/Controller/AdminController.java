package com.example.backendApp.Controller;

import com.example.backendApp.Constant.Constant;
import com.example.backendApp.Models.User;
import com.example.backendApp.Repo.UserRepo;
import com.example.backendApp.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class AdminController {
    @Autowired
    private UserServices userService;

    @Autowired
    private UserRepo userRepository;


    // Xem tất cả người dùng
    @GetMapping("/get-all-user")
    public ResponseEntity<?> getAllUser(@RequestParam Long idUser) {
        try {
            Optional<User> user = userService.findById(idUser);
            if (user.isEmpty()) {
                return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.BAD_REQUEST);
            }
            if (!user.get().getRole().equals(Constant.ROLE_ADMIN)) {
                return new ResponseEntity<>("Bạn không phải Admin", HttpStatus.UNAUTHORIZED);
            }
            List<User> userList = userRepository.findAll();
            userList.removeIf(n -> (n.getRole().equals(Constant.ROLE_ADMIN)));
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Cấm người dùng
    @GetMapping("/banner")
    public ResponseEntity<?> banner(@RequestParam Long idAdmin, @RequestParam Long idUser) {
        try {
            Optional<User> admin = userService.findById(idAdmin);
            if (admin.isEmpty()) {
                return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.BAD_REQUEST);
            }
            if (!admin.get().getRole().equals(Constant.ROLE_ADMIN)) {
                return new ResponseEntity<>("Bạn không phải Admin", HttpStatus.UNAUTHORIZED);
            }
            Optional<User> user = userService.findById(idUser);
            if (user.isEmpty()) {
                return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.BAD_REQUEST);
            } else {
                user.get().setStatus(Constant.STATUS_USER_BANED);
                userService.save(user.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Bỏ cấm
    @GetMapping("/open")
    public ResponseEntity<?> openAgain(@RequestParam Long idAdmin, @RequestParam Long idUser) {
        try {
            Optional<User> admin = userService.findById(idAdmin);
            if (admin.isEmpty()) {
                return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.BAD_REQUEST);
            }
            if (!admin.get().getRole().equals(Constant.ROLE_ADMIN)) {
                return new ResponseEntity<>("Bạn không phải Admin", HttpStatus.UNAUTHORIZED);
            }
            Optional<User> user = userService.findById(idUser);
            if (user.isEmpty()) {
                return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.BAD_REQUEST);
            } else {
                user.get().setStatus(Constant.STATUS_ACTIVE);
                userService.save(user.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
