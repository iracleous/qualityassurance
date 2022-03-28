package gr.codehub.qualityassurance.service;


import gr.codehub.qualityassurance.model.TodoItem;
import gr.codehub.qualityassurance.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;


    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    public Optional<TodoItem> findById(int id) {
        return todoRepository.findById(id);
    }

    public void delete(TodoItem todoItem) {
        todoRepository.delete(todoItem);
    }

    public void save(String description) {
        TodoItem todo = new TodoItem();
        todo.setDescription(description);

        if (description== null) return;
        if (description.contains("dimitris"))
            return;

        todo.setDate_created(new Date());

        todoRepository.save(todo);
    }
}
