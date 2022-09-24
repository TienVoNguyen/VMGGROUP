package com.vmg.vont.controller;

import com.vmg.vont.models.Todo;
import com.vmg.vont.models.TodoStatus;
import com.vmg.vont.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/todo")
public class TodoListController {
    @Autowired
    ITodoService todoService;

    //The function receives a GET request, processes it and gives back a list of Todo as a response.
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(@RequestParam(required = false) String title) {
        try {
            List<Todo> todos = new ArrayList<>();
            if (title == null) {
                todos.addAll(todoService.getTodos());
            } else {
                todos.addAll(todoService.findByTitleContaining(title));
            }
            if (todos.isEmpty()) {
                return new ResponseEntity<>(todos, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(todos, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //The function receives a GET request, processes it, and gives back a list of Todo as a response.
    @GetMapping({"/{id}"})
    public ResponseEntity<Todo> getTodo(@PathVariable("id") Long id) {
        return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Todo and saves it to the database, and returns a resource link to the created todo.           @PostMapping
    @PostMapping()
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        Todo todo1 = todoService.insert(todo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/todo/" + todo1.getId().toString());
        return new ResponseEntity<>(todo1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Todo with the specified Id and returns the updated Todo
    @PutMapping({"/{id}"})
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long todoId, @RequestBody Todo todo) {
        todoService.updateTodo(todoId, todo);
        return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Todo with the specified Id.
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Todo> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        todoService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Todo>> findByTodoStatus() {
        try {
            List<Todo> todoList = todoService.findByTodoStatus(TodoStatus.COMPLETED);

            if (todoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(todoList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
