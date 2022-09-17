package com.vmg.vont.dao;

import com.vmg.vont.models.pojo.CoverBlog;
import com.vmg.vont.models.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<User, Long> {
}