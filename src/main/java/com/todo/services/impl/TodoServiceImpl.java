package com.todo.services.impl;

import com.todo.exceptions.ResouceNotFoundException;
import com.todo.models.Todo;
import com.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
    List<Todo> todos = new ArrayList<>();

    @Override
    public Todo createTodo(Todo todo) {
        //create...
        todos.add(todo);
        logger.info("Todos {}", this.todos);
        return todo;
    }

    @Override
    public List<Todo> getTodos() {
        //fetching...
        logger.info("Todos {}", this.todos);
        return todos;
    }

    @Override
    public Todo getTodo(int id) {
        //fetching...
        Todo todo = todos.stream().filter(data -> data.getId()==id).findAny().orElseThrow(()->
            new ResouceNotFoundException("Data not found with requested ID", HttpStatus.NOT_FOUND)
        );
        logger.info("Todo {}", todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        //updating...
        Todo oldTodo = todos.stream().filter(data -> data.getId()==id).findAny().orElseThrow(()->
                new ResouceNotFoundException("Data not found with requested ID", HttpStatus.NOT_FOUND)
        );
        oldTodo.setTitle(todo.getTitle());
        oldTodo.setContent(todo.getContent());
        oldTodo.setStatus(todo.getStatus());
        logger.info("Todo {}", oldTodo);
        return oldTodo;
    }

    @Override
    public void deleteTodo(int id) {
        //delete
        List<Todo> todoList = todos.stream().filter(t -> id != t.getId()).collect(Collectors.toList());
        todos = todoList;
        return;
    }
}
