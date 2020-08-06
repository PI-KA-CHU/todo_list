package com.thoughtworks.service.impl;

import com.thoughtworks.entity.TodoEntity;
import com.thoughtworks.dto.TodoDto;
import com.thoughtworks.enums.TodoEnums;
import com.thoughtworks.exceptions.TodoNoFoundException;
import com.thoughtworks.exceptions.TodoInfoErrorException;
import com.thoughtworks.responsity.TodoRepository;
import com.thoughtworks.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  @Autowired
  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public List<TodoEntity> getAllTodo() {
    return todoRepository.findAll();
  }

  @Override
  public void deleteTodoById(int id) {
    try {
      todoRepository.deleteById(id);
    } catch (IllegalArgumentException e) {
      throw new TodoNoFoundException(TodoEnums.TODO_NO_FOUND_ERROR);
    }
  }

  /**
   * copyProperties
   *  - https://blog.csdn.net/w05980598/article/details/79134379
   *
   * @param todoDto todoData to store in db
   */
  @Override
  public void addTodo(TodoDto todoDto) {
    TodoEntity todoEntity = new TodoEntity();
    BeanUtils.copyProperties(todoEntity, todoDto);

    try {
      todoRepository.save(todoEntity);
    } catch (IllegalArgumentException e) {
      throw new TodoInfoErrorException(TodoEnums.TODO_INFO_ERROE);
    }
  }

  @Override
  public void updateTodo(Integer id, TodoEntity todoEntity) throws Exception {
    TodoEntity todoEntityDb = todoRepository
            .findById(id)
            .orElseThrow(() -> new TodoNoFoundException(TodoEnums.TODO_NO_FOUND_ERROR));
    BeanUtils.copyProperties(todoEntity, todoEntityDb);
    todoRepository.save(todoEntity);
  }

}
