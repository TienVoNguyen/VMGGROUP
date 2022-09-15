package com.vmg.vont.service.impl;

import com.vmg.vont.dao.ITodoDAO;
import com.vmg.vont.models.Todo;
import com.vmg.vont.models.TodoStatus;
import com.vmg.vont.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {
    @Autowired
    ITodoDAO todoDAO;

    @Override
    public List<Todo> getTodos() {
        return todoDAO.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        Optional<Todo> todo = todoDAO.findById(id);
        return todo.orElseGet(Todo::new);
    }

    @Override
    public Todo insert(Todo todo) {
        return todoDAO.save(todo);
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        Todo todoFromDb = this.getTodoById(id);
        System.out.println(todoFromDb.toString());
        todoFromDb.setTodoStatus(todo.getTodoStatus());
        todoFromDb.setDescription(todo.getDescription());
        todoFromDb.setTitle(todo.getTitle());
        todoDAO.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoDAO.deleteById(todoId);
    }

    @Override
    public List<Todo> findByTodoStatus(TodoStatus todoStatus) {
        return todoDAO.findByTodoStatus(todoStatus);
    }

    @Override
    public List<Todo> findByTitleContaining(String title) {
        return todoDAO.findByTitleContaining(title);
    }

    @Override
    public void deleteAll() {
        todoDAO.deleteAll();
    }
}
