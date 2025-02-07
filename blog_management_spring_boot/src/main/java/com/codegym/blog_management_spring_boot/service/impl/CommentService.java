package com.codegym.blog_management_spring_boot.service.impl;

import com.codegym.blog_management_spring_boot.model.Comment;
import com.codegym.blog_management_spring_boot.repository.ICommentRepository;
import com.codegym.blog_management_spring_boot.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public void save(Comment s) {
        commentRepository.save(s);
    }

    @Override
    public void update(Long id, Comment s) {
        Comment c = commentRepository.findById(id).orElse(null);
        if(c != null) {
            c.setId(id);
            commentRepository.save(c);
        }
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByName(String name) {
        return List.of();
    }
}
