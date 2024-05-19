package com.todo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "jap_todos")
public class Todo {

    @Column(name = "Id")
    @Id
    private int id;

    @Column(name = "Title", length = 50)
    private String title;

    @Column(name = "Content", length = 200)
    private String content;

    @Column(name = "Status", length = 10)
    private String status;

    @Column(name = "Added_Date")
    private Date addDate;

    @Column(name = "Todo_Date")
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
