package com.thoughtworks.service;

import com.thoughtworks.Entity.TodoEntity;
import com.thoughtworks.dto.TodoDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    List<TodoEntity> getAllTodo();

    void deleteTodoById(int id);

    void addTodo(TodoDto todoDto);

    void updateTodo(Integer id, TodoEntity todoEntity) throws Exception;
}
