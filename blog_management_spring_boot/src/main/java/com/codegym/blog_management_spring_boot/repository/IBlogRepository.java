package com.codegym.blog_management_spring_boot.repository;

import com.codegym.blog_management_spring_boot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByTitleContaining(String title);
}
