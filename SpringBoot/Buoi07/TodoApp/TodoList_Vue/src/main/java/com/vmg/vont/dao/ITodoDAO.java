package com.vmg.vont.dao;

import com.vmg.vont.models.Todo;
import com.vmg.vont.models.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITodoDAO extends JpaRepository<Todo, Long> {
    List<Todo> findByTodoStatus(TodoStatus todoStatus);
    List<Todo> findByTitleContaining(String title);
}
