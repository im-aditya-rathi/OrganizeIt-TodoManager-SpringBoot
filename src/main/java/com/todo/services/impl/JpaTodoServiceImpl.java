package com.todo.services.impl;

import com.todo.exceptions.ResouceNotFoundException;
import com.todo.models.Todo;
import com.todo.repository.TodoRepository;
import com.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class JpaTodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodo(int id) {
        return todoRepository.findById(id).orElseThrow(()->new ResouceNotFoundException("Data not found with requested ID",
                HttpStatus.NOT_FOUND));
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        Todo todo1 = todoRepository.findById(id).orElseThrow(()->new ResouceNotFoundException("Data not found with requested ID",
                HttpStatus.NOT_FOUND));
        todo1.setTitle(todo.getTitle());
        todo1.setContent(todo.getContent());
        todo1.setStatus(todo.getStatus());
        todo1.setTodoDate(todo.getTodoDate());
        return todoRepository.save(todo1);
    }

    @Override
    public void deleteTodo(int id) {
        todoRepository.findById(id).orElseThrow(()->new ResouceNotFoundException("Data not found with requested ID",
                HttpStatus.NOT_FOUND));
        todoRepository.deleteById(id);
    }
}
