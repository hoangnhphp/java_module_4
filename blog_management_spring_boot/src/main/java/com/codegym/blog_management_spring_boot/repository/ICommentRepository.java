package com.codegym.blog_management_spring_boot.repository;

import com.codegym.blog_management_spring_boot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
