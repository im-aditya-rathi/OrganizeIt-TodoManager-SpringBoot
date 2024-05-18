package com.todo.dao;

import com.todo.helper.Helper;
import com.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Repository
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

    public Todo saveTodo(Todo todo) {

        String query = "insert into todos (id, title, content, status, addDate, todoDate) values (?,?,?,?,?,?)";
        int rows = jdbcTemplate.update(query, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(),
                todo.getAddDate(), todo.getTodoDate());

        logger.info("JDBC Operations: {} rows inserted", rows);
        return todo;
    }

    public Todo getTodo(int id) {

        String query = "select * from todos where id = ?";
//        Map<String, Object> todoData = jdbcTemplate.queryForMap(query, id);
//        Todo todo = Helper.generateTodoFromDaoMap(todoData);

        Todo todo = jdbcTemplate.queryForObject(query, new TodoRowMapper(), id);

        logger.info("Todo fetched from db: {}",todo);
        return todo;
    }

    public List<Todo> getTodos() {

        String query = "select * from todos";
//        List<Map<String, Object>> todoMapList = jdbcTemplate.queryForList(query);
//        List<Todo> todos = todoMapList.stream().map(Helper::generateTodoFromDaoMap).toList();

        List<Todo> todos = jdbcTemplate.query(query, new TodoRowMapper());

        logger.info("Todos list fetched from db: {}",todos);
        return todos;
    }

    public Todo updateTodo(int id, Todo newTodo) {

        String query = "update todos set title=?, content=?, status=?, todoDate=? where id=?";
        int update = jdbcTemplate.update(query, newTodo.getTitle(), newTodo.getContent(), newTodo.getStatus(),
                        newTodo.getTodoDate(), id);

        logger.info("UPDATED: {}", update);

        return getTodo(id);
    }

    public void deleteTodo(int id) {

        String query = "delete from todos where id = ?";
        int delete =  jdbcTemplate.update(query, id);

        logger.info("DELETED: {}", delete);
    }

    public void deleteMultipleTodos(int[] ids) {

        String query = "delete from todos where id=?";

        int[] ints = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                int id = ids[i];
                ps.setInt(1,id);
            }

            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });

        for(int i: ints) {
           logger.info("DELETED: {}",i);
        }
    }

}
