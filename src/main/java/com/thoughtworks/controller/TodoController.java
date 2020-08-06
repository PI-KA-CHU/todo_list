package com.thoughtworks.controller;

import com.thoughtworks.entity.TodoEntity;
import com.thoughtworks.dto.TodoDto;
import com.thoughtworks.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
  @Autowired private TodoService todoService;

  @GetMapping("/todos")
  public @ResponseBody List<TodoEntity> getAllTodo() {
    return todoService.getAllTodo();
  }

  @PostMapping("/todo")
  @ResponseStatus(HttpStatus.CREATED)
  public void addTodo(@RequestBody TodoDto todoDto) {
    todoService.addTodo(todoDto);
  }

  @GetMapping("/todos/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteTodo(@PathVariable int id) {
    todoService.deleteTodoById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateTodo(@PathVariable Integer id, @RequestBody TodoEntity todoEntity) throws Exception {
    todoEntity.setId(id);
    todoService.updateTodo(id, todoEntity);
  }

}
