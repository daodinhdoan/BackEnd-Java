package com.example.backendApp.Service.impl;

import com.example.backendApp.Models.Comment;
import com.example.backendApp.Models.Product;
import com.example.backendApp.Models.User;
import com.example.backendApp.Repo.CommentRepo;
import com.example.backendApp.Service.CommentService;
import com.example.backendApp.Service.ProductService;
import com.example.backendApp.Service.UserServices;
import com.example.backendApp.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepository;

    @Autowired
    private UserServices userService;

    @Autowired
    private ProductService productService;

    @Override
    public List<Comment> findAllCommentByUserId(Long idUser) {
        return commentRepository.findCommentByProductId(idUser);
    }

    @Override
    public List<Comment> findAllCommentByProductId(Long idProduct) {
        return commentRepository.findCommentByProductId(idProduct);
    }

    @Override
    public List<Comment> findAllCommentByProductIdAndUserId(Long idProduct, Long idUser) {
        return commentRepository.findAllCommentByProductIdAndUserId(idUser, idProduct);
    }

    @Override
    public void save(Comment comment) throws Exception {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) throws Exception {
        if (null == id) {
            throw new Exception("Không có id");
        }
        commentRepository.deleteById(id);
    }

    @Override
    public Comment validateCommentAndInit(CommentDTO commentDTO) throws Exception {
        if (null == commentDTO.getIdProduct() || null == commentDTO.getIdUser()) {
            throw new Exception("không có id người dùng hoặc id sản phẩm");
        }
        if (null == commentDTO.getContent() || "".equals(commentDTO.getContent())) {
            throw new Exception("Không có nội dung");
        }
        Optional<User> userOptional = userService.findById(commentDTO.getIdUser());
        Optional<Product> productOptional = productService.findById(commentDTO.getIdProduct());
        if (userOptional.isEmpty() || productOptional.isEmpty()) {
            throw new Exception("không tìm thấy người dùng hoặc sản phẩm");
        }
        Comment comment = new Comment();
        comment.setCreateDate(new Date());
        comment.setContent(commentDTO.getContent());
        comment.setProduct(productOptional.get());
        comment.setUser(userOptional.get());
        return comment;
    }
}
