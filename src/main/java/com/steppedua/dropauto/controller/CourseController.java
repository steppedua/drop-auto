package com.steppedua.dropauto.controller;

import com.steppedua.dropauto.domain.Courses;
import com.steppedua.dropauto.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    private CoursesRepository coursesRepository;

    @Autowired
    public CourseController(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }


    @GetMapping("/course")
    public String courseMain(Model model) {
        model.addAttribute("courses", coursesRepository.findAll());
        return "course";
    }

    @GetMapping("/course/add")
    public String courseAdd(Model model) {
        model.addAttribute("course", new Courses());
        return "add-course";
    }


    @PostMapping("/course/add")
    public String coursePostAdd(@RequestParam String title,
                                @RequestParam String anons,
                                @RequestParam String full_text) {
        Courses course = new Courses(title, anons, full_text);
        coursesRepository.save(course);
        return "redirect:/course";
    }



}
