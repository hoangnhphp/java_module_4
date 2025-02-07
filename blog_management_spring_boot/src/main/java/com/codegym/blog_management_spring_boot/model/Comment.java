package com.codegym.blog_management_spring_boot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "post_id", nullable = false)
    private Long post_id;

    @Column(name = "user_id", nullable = false)
    private Long user_id;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Comment(String content, Long post_id, Long user_id) {
        this.content = content;
        this.post_id = post_id;
        this.user_id = user_id;
    }
}
