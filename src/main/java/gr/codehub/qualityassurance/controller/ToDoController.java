package gr.codehub.qualityassurance.controller;


import gr.codehub.qualityassurance.model.TodoItem;
import gr.codehub.qualityassurance.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ToDoController {
    @Autowired
    private TodoRepository todoRepository;

    /**
     * Gets all todo items
     * @param model
     * @return
     */

    @GetMapping("/todo")
    public String getAllTodoItems(Model model) {
        List<TodoItem> todoItems = todoRepository.findAll();
        model.addAttribute("items", todoItems );
        return "Page";
    }

    @PostMapping("/todo/delete")
    public String deleteItem(@RequestParam int id) {

        Optional<TodoItem> todoOpt = todoRepository.findById(id);
        if (todoOpt.isEmpty()) return "redirect:/todo";

        todoRepository.delete(todoOpt.get());
        return "redirect:/todo";
    }

    @PostMapping("/todo/add")
    public String addItem(@RequestParam String description) {
        TodoItem todo = new TodoItem();
        todo.setDescription(description);
        todo.setDate_created(new Date());
        todoRepository.save(todo);
        return "redirect:/todo";
    }

}
