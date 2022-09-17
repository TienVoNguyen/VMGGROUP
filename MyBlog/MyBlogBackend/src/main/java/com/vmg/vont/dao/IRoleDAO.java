package com.vmg.vont.dao;

import com.vmg.vont.models.pojo.CoverBlog;
import com.vmg.vont.models.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDAO extends JpaRepository<Role, Long> {
}