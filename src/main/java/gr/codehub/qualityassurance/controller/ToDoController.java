package gr.codehub.qualityassurance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToDoController {
        @GetMapping ("/")
        @ResponseBody
        public String hello(){
            return "hello world";
        }
    @GetMapping ("/hello")
    @ResponseBody
    public String hello2(){
        return "hello Jenny";
    }
    @GetMapping ("/lorem")
    public String index(){
        return "Index";
    }

}
