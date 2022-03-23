package gr.codehub.qualityassurance.controller;


import gr.codehub.qualityassurance.model.TodoItem;
import gr.codehub.qualityassurance.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Optional;

@Controller
public class ToDoController {
    @Autowired
private TodoRepository todoRepository;

    @GetMapping ("/todo")

    public String todo(Model model){

        Optional<TodoItem> todoItem = todoRepository.findById(1) ;
        if(todoItem.isEmpty()) return null;

        model.addAttribute("item", todoItem.get());

        return "Page";
    }









        @GetMapping ("/")
        @ResponseBody
        public String hello(){
            return "hello world";
        }



    @GetMapping ("/lorem")
    public String index(){
        return "Index";
    }
    @GetMapping ("/page")
    public String page(){
        return "Page";
    }
}
