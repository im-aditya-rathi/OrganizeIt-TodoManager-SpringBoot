package com.todo.dao;

import com.todo.helper.Helper;
import com.todo.models.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setStatus(rs.getString("status"));
        try {
            if(rs.getObject("addDate") != null) {
                todo.setAddDate(Helper.parseDate((LocalDateTime) rs.getObject("addDate")));
            }
            if (rs.getObject("todoDate") != null) {
                todo.setTodoDate(Helper.parseDate((LocalDateTime) rs.getObject("todoDate")));
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return todo;
    }
}
