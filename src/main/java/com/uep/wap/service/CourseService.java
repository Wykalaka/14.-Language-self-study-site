package com.uep.wap.service;

import com.uep.wap.dto.CourseDTO;
import com.uep.wap.model.Course;
import com.uep.wap.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setLanguage(courseDTO.getLanguage());
        courseRepository.save(course);
        System.out.println("Course added!");
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void updateCourse(CourseDTO courseDTO) {
        Course course = courseRepository.findById(courseDTO.getC_id()).orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + courseDTO.getC_id()));
        course.setLanguage(courseDTO.getLanguage());
        courseRepository.save(course);
        System.out.println("Course updated!");
    }
}


