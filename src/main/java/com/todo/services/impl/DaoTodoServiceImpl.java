package com.todo.services.impl;

import com.todo.dao.TodoDao;
import com.todo.models.Todo;
import com.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class DaoTodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Override
    public Todo createTodo(Todo todo) {
        return todoDao.saveTodo(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return todoDao.getTodos();
    }

    @Override
    public Todo getTodo(int id) {
        return todoDao.getTodo(id);
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        return todoDao.updateTodo(id, todo);
    }

    @Override
    public void deleteTodo(int id) {
        todoDao.deleteTodo(id);
    }
}
