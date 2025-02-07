package com.codegym.blog_management_spring_boot.repository;

import com.codegym.blog_management_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
