package com.todo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {

    private int id;
    private String title;
    private String content;
    private String status;
    private Date addDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date todoDate;

    public Todo() {
    }

    public Todo(int id, String title, String content, String status, Date addDate, Date todoDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addDate = addDate;
        this.todoDate = todoDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", addDate=" + addDate +
                ", todoDate=" + todoDate +
                '}';
    }
}
