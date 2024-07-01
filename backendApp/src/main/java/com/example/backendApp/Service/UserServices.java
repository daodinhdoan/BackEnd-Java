package com.example.backendApp.Service;

import com.example.backendApp.Models.User;

import java.util.Optional;

public interface UserServices {
    Optional<User> findById(Long id);

    void save(User user) throws Exception;

    void delete(Long id);

    void checkLogin(String username, String password) throws Exception;

    Optional<User> findUserByUsername(String username);

    void resetPassword(String username, String pin, String newPassword, String confirmPassword) throws Exception;

    void checkRoleAdmin(Long idUser) throws Exception;

    void validateUser(User user) throws Exception;

    void checkBannerUser(String username) throws Exception;
}
