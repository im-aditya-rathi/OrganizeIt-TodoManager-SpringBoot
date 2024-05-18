package com.todo.dao;

import com.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {

    Logger logger = LoggerFactory.getLogger(TodoDao.class);

    JdbcTemplate jdbcTemplate;

    public TodoDao(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        //create table if it doesn't exists
        int rows = jdbcTemplate.update("create table IF NOT EXISTS todos (id int primary key, title varchar(50)," +
                " content varchar(100), status varchar(50), addDate datetime, todoDate datetime)");

        logger.info("Table is ready to perform operations : todos");
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveTodo(Todo todo) {

        String query = "insert into todos (id, title, content, status, addDate, todoDate) values (?,?,?,?,?,?)";
        int rows = jdbcTemplate.update(query, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(),
                todo.getAddDate(), todo.getAddDate());

        logger.info("JDBC Operations: {} rows inserted", rows);
    }
}
