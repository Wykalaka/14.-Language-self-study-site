package com.uep.wap.controller;

import com.uep.wap.dto.CourseDTO;
import com.uep.wap.model.Course;
import com.uep.wap.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public String addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
        return "Course added!";
    }

    @GetMapping
    public Iterable<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(path = "/{id}")
    public Course getCourseById(@PathVariable("id") Integer id) {
        return courseService.getCourse(id);
    }

    @PutMapping(path = "/{id}")
    public String updateCourse(@PathVariable("id") Integer id, @RequestBody CourseDTO courseDTO) {
        courseDTO.setC_id(id);
        courseService.updateCourse(courseDTO);
        return "Course updated!";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCourse(@PathVariable("id") Integer id) {
        courseService.deleteCourse(id);
        return "Course deleted!";
    }
}

