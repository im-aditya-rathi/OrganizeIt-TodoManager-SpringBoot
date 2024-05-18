package com.todo.services;

import com.todo.models.Todo;

import java.util.List;

public interface TodoService {

    public Todo createTodo(Todo todo);

    public List<Todo> getTodos();

    public Todo getTodo(int id);

    public Todo updateTodo(int id, Todo todo);

    public void deleteTodo(int id);
}
