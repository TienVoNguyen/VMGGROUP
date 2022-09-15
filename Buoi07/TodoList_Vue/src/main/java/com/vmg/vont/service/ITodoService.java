package com.vmg.vont.service;

import com.vmg.vont.models.Todo;
import com.vmg.vont.models.TodoStatus;

import java.util.List;
import java.util.Optional;

public interface ITodoService {
    List<Todo> getTodos();

    Todo getTodoById(Long id);

    Todo insert(Todo todo);

    void updateTodo(Long id, Todo todo);

    void deleteTodo(Long todoId);

    List<Todo> findByTodoStatus(TodoStatus todoStatus);

    List<Todo> findByTitleContaining(String title);

    void deleteAll();
}
