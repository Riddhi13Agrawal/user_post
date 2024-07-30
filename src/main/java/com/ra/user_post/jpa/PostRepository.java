package com.ra.user_post.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra.user_post.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>
{
    
}
