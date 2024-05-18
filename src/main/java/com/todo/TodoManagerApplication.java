package com.todo;

import com.todo.dao.TodoDao;
import com.todo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

	@Autowired
	TodoDao todoDao;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		//create todo
//		Todo todo = new Todo();
//		todo.setId(124);
//		todo.setTitle("C++");
//		todo.setContent("programming language");
//		todo.setStatus("done");
//		todo.setAddDate(new Date());
//		todo.setTodoDate(new Date());
//
//		todoDao.saveTodo(todo);
	}
}
