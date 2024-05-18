package com.todo.controllers;

import com.todo.models.Todo;
import com.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;
    Random random = new Random();

    //create
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo) {
        logger.info("Create Todo");

        int id = random.nextInt(9999999);
        todo.setId(id);

        //create date with system default current date
        Date currentDate = new Date();
        todo.setAddDate(currentDate);
        logger.info("current date: {}",currentDate);
        logger.info("Json todo date: {}",todo.getTodoDate());

        Todo todo1 = todoService.createTodo(todo);
//        ResponseEntity responseEntity = new ResponseEntity(todo1, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo1);
    }

    //fetch all
    @GetMapping
    public ResponseEntity<List<Todo>> getTodosHandler() {
        logger.info("Get All Todos");

        List<Todo> todos = todoService.getTodos();
        return ResponseEntity.ok(todos);
    }

    // fetch single
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoHandler(@PathVariable int id) {
        logger.info("Get Specific Todo");

        Todo todo = todoService.getTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.ACCEPTED);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodoHandler(@PathVariable int id, @RequestBody Todo todo) {
        logger.info("Update Todo");

        Todo todo1 = todoService.updateTodo(id, todo);
        return new ResponseEntity<>(todo1, HttpStatus.ACCEPTED);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoHandler(@PathVariable int id) {
        logger.info("delete Todo");

        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
