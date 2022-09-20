package com.vmg.vont.dao;

import com.vmg.vont.models.pojo.CoverBlog;
import com.vmg.vont.models.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDAO extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}