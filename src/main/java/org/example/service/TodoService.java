package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoEntity add(TodoRequest request){
        TodoEntity todoEntity = TodoEntity.builder()
                .title(request.getTitle())
                .order(request.getOrder())
                .completed(request.getCompleted())
                .build();
        return todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id){
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public List<TodoEntity> searchAll(){
        return todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoRequest request){
        TodoEntity todoEntity = this.searchById(id);
        todoEntity.update(request);
        return todoEntity;
    }

    public void deleteById(Long id){
        todoRepository.deleteById(id);
    }

    public void deleteAll(){
        todoRepository.deleteAll();
    }
}
