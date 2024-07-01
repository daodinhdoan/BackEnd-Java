package com.example.backendApp.Service;

import com.example.backendApp.Models.Comment;
import com.example.backendApp.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<Comment> findAllCommentByUserId(Long idUser);

    List<Comment> findAllCommentByProductId(Long idProduct);

    List<Comment> findAllCommentByProductIdAndUserId(Long idProduct, Long idUser);

    void save(Comment comment) throws Exception;

    void delete(Long id) throws Exception;

    Comment validateCommentAndInit(CommentDTO commentDTO) throws Exception;

}
