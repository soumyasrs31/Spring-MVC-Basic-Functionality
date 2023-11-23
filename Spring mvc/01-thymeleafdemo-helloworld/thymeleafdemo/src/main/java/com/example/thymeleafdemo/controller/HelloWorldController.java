package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    //need a controller method show initial HTML form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method show response HTML form

    @RequestMapping("/responseForm")
    public String responseForm(){
        return "helloworld";
    }

    //need a controller method for read the form data
    //add the message to model

    @RequestMapping("/responseFormVersionTwo")
    public String responseFormTwo(HttpServletRequest request, Model model){
        //read the parameter from form
        String theName = request.getParameter("studentName");
        //convert to upper case
        theName = theName.toUpperCase();
        //put a message
        String result = "yo!! "+theName;
        //add message to model
        model.addAttribute("message",result);
        return "helloworld";

    }
    @PostMapping("/responseFormVersionThree")
    public String responseFormThree(@RequestParam("studentName") String theName, Model model){
        //convert to upper case
        theName = theName.toUpperCase();
        //put a message
        String result = "My friend name is: "+theName;
        //add message to model
        model.addAttribute("message",result);
        return "helloworld";

    }
}
