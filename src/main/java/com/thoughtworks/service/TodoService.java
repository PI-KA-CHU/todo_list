package com.thoughtworks.service;

import com.thoughtworks.entity.TodoEntity;
import com.thoughtworks.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoEntity> getAllTodo();

    void deleteTodoById(int id);

    void addTodo(TodoDto todoDto);

    void updateTodo(Integer id, TodoEntity todoEntity) throws Exception;
}
