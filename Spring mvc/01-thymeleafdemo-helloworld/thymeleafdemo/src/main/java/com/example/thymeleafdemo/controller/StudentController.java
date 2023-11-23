package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> theCountries;

    @Value("${languages}")
    private List<String> theLanguages;

    @Value("${systems}")
    private List<String> theSystems;
    //add method for show student form
    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        //Create a student object
        Student theStudent = new Student();

        //set the attribute name and value to model
        model.addAttribute("student",theStudent);
        model.addAttribute("countries",theCountries);
        model.addAttribute("languages",theLanguages);
        model.addAttribute("systems",theSystems);

        return "student-registration-form";
    }

    @PostMapping("/processStudentForm")
    public String responseForm(@ModelAttribute("student") Student theStudent){
        System.out.println("The Student "+theStudent.getFirstName()+" "+theStudent.getLastName());
        return "confirmation-form";
    }
}
