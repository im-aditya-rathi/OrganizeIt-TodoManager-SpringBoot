# Organize It - [Todo Manager]

## Overview
OrganizeIt is a Todo Manager application built using Spring Boot. The application demonstrates three different methods for data storage:
1. Hibernate (used as Primary)
2. Spring JDBC
3. In-memory using data structures

Additionally, the application includes global exception handling, a logging mechanism, and follows a three-layer architecture to ensure the code is maintainable and understandable.

## Features
- **In-Memory Data Storage**: Quick and easy setup for testing and development purposes.
- **Spring JDBC**: Demonstrates how to interact with a relational database using Spring's JDBC support.
- **Hibernate**: Uses Hibernate ORM for database interactions, leveraging JPA annotations.
- **Global Exception Handling**: Centralized exception handling using `@ControllerAdvice`.
- **Logging**: Integrated logging using SLF4J.
- **Three-Layer Architecture**: Follows a clear separation of concerns with Controller, Service, and Repository layers.

## Endpoints Exposed
- `GET /todos` : Retrieve all todos
- `GET /todos/{id}` : Retrieve a single todo by ID
- `POST /todos` : Create a new todo
- `PUT /todos/{id}` : Update an existing todo
- `DELETE /todos/{id}` : Delete a todo by ID


<hr>
<!-- Screenshots lists -->

## Screenshots

### 1.) Success Response:

<table>
  <tr>
    <td><h4>Create Todo</h4></td>
    <td><h4>Get Todo</h4></td>
  </tr>
  <tr>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/1.png" alt="Create Todo"/></kbd>
    </td>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/2.png" alt="Get Todo"/></kbd>
    </td>
  </tr>
</table>

<br>

<table>
  <tr>
    <td><h4>Update Todo</h4></td>
    <td><h4>Get All Todos</h4></td>
  </tr>
  <tr>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/3.png" alt="Update Todo"/></kbd>
    </td>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/4.png" alt="Get All Todos"/></kbd>
    </td>
  </tr>
</table>

<br>

<table>
  <tr>
    <td><h4>Delete Todo</h4></td>
    <td><h4>Get All Todos (checking again after deleting todo)</h4></td>
  </tr>
  <tr>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/5.png" alt="Delete Todo"/></kbd>
    </td>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/6.png" alt="Get All Todos (checking again after deleting todo)"/></kbd>
    </td>
  </tr>
</table>

<br><br>

### 2.) Bad Response [Exception Handling]:

<table>
  <tr>
    <td><h4>Get Todo (with wrong todo id)</h4></td>
    <td><h4>Update Todo (with wrong todo id)</h4></td>
  </tr>
  <tr>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/0_Exception_Handling_1.png" alt="Get Todo (with wrong todo id)"/></kbd>
    </td>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/0_Exception_Handling_2.png" alt="Update Todo (with wrong todo id)"/></kbd>
    </td>
  </tr>
</table>

<br>

<table>
  <tr>
    <td><h4>Delete Todo (with wrong todo id)</h4></td>
  </tr>
  <tr>
    <td align="center">
      <kbd><img src="https://github.com/im-aditya-rathi/Todo-Manager/blob/master/src/main/resources/screenshots/0_Exception_Handling_3.png" alt="Delete Todo (with wrong todo id)"/></kbd>
    </td>
  </tr>
</table>

<hr>
