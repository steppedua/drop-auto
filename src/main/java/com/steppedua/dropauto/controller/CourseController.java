package com.steppedua.dropauto.controller;

import com.steppedua.dropauto.domain.Courses;
import com.steppedua.dropauto.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        Iterable<Courses> courses = coursesRepository.findAll();
        model.addAttribute("courses", courses);
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

//    @PostMapping("/course/{id}")
//    public String addCourse(@PathVariable("id") Long id, Model model) {
//        List<Courses> allById = coursesRepository.findAllById(id);
//        Iterable<Courses> courses = coursesRepository.findAll()
//        return "";
//    }


//    @GetMapping("/blog")
//    public String blogMain(Model model) {
//        Iterable<Post> posts = postRepository.findAll();
//        model.addAttribute("posts", posts);
//        return "blog-main";
//    }
}
