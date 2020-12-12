package com.lieu.c07.demo.repository;

import com.lieu.c07.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // thay cho viec su dung @Bean
public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
