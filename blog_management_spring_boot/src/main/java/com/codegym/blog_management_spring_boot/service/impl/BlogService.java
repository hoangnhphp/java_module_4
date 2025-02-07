package com.codegym.blog_management_spring_boot.service.impl;

import com.codegym.blog_management_spring_boot.model.Blog;
import com.codegym.blog_management_spring_boot.repository.IBlogRepository;
import com.codegym.blog_management_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog s) {
        blogRepository.save(s);
    }

    @Override
    public void update(Long id, Blog s) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog != null) {
            blog.setId(id);
            blogRepository.save(blog);
        }
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.findAllByTitleContaining(name);
    }
}
