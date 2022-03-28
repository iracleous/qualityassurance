package gr.codehub.qualityassurance.controller;


import gr.codehub.qualityassurance.model.TodoItem;
import gr.codehub.qualityassurance.repository.TodoRepository;
import gr.codehub.qualityassurance.service.TodoService;
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
    private TodoService todoService;

    /**
     * Gets all todo items
     * @param model all the todo items
     * @return
     */

    @GetMapping("/todo")
    public String getAllTodoItems(Model model) {
        List<TodoItem> todoItems = todoService.findAll();
        model.addAttribute("items", todoItems );
        return "Page";
    }

    @PostMapping("/todo/delete")
    public String deleteItem(@RequestParam int id) {
        todoService.delete(id);
        return "redirect:/todo";
    }

    @PostMapping("/todo/add")
    public String addItem(@RequestParam String description) {
        todoService.save(description );
        return "redirect:/todo";
    }

}
