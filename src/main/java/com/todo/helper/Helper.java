package com.todo.helper;

import com.todo.models.Todo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class Helper {

    public static Date parseDate(LocalDateTime localDateTime) {

        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static Todo generateTodoFromDaoMap(Map<String, Object> todoData) {
        Todo todo = new Todo();
        todo.setId((Integer) todoData.get("id"));
        todo.setTitle((String) todoData.get("title"));
        todo.setContent((String) todoData.get("content"));
        todo.setStatus((String) todoData.get("status"));
        try {
            todo.setAddDate(Helper.parseDate((LocalDateTime) todoData.get("addDate")));
            todo.setTodoDate(Helper.parseDate((LocalDateTime) todoData.get("todoDate")));
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return todo;
    }
}
