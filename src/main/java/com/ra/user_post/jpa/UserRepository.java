package com.ra.user_post.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra.user_post.user.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
    
}
