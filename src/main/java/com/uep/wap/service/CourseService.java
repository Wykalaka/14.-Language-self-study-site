package com.uep.wap.service;

import com.uep.wap.dto.CourseDTO;
import com.uep.wap.model.Course;
import com.uep.wap.model.Section;
import com.uep.wap.model.Started_Course;
import com.uep.wap.repository.CourseRepository;
import com.uep.wap.repository.SectionRepository;
import com.uep.wap.repository.Started_CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Started_CourseRepository startedCourseRepository;

    @Autowired
    private SectionRepository sectionRepository;

    /*public void addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setLanguage(courseDTO.getLanguage());

        Iterable<Started_Course> startedCoursesIterable = startedCourseRepository.findAllById(courseDTO.getStartedCourseIds());
        List<Started_Course> startedCourses = new ArrayList<>();
        startedCoursesIterable.forEach(startedCourses::add);
        course.setStartedCourses(startedCourses);

        Iterable<Section> sectionsIterable = sectionRepository.findAllById(courseDTO.getSectionIds());
        List<Section> sections = new ArrayList<>();
        sectionsIterable.forEach(sections::add);
        course.setSections(sections);

        courseRepository.save(course);
        System.out.println("Course added!");
    }*/

    public void addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setLanguage(courseDTO.getLanguage());

        List<Started_Course> startedCourses = new ArrayList<>();
        course.setStartedCourses(startedCourses);

        List<Section> sections = new ArrayList<>();
        course.setSections(sections);

        courseRepository.save(course);
        System.out.println("Course added!");
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(Integer id) {
        Course course  = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));
        return course;
    }

    public void updateCourse(CourseDTO courseDTO) {
        Course course = courseRepository.findById(courseDTO.getC_id())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + courseDTO.getC_id()));
        course.setLanguage(courseDTO.getLanguage());

        Iterable<Started_Course> startedCoursesIterable = startedCourseRepository.findAllById(courseDTO.getStartedCourseIds());
        List<Started_Course> startedCourses = new ArrayList<>();
        startedCoursesIterable.forEach(startedCourses::add);
        course.setStartedCourses(startedCourses);

        Iterable<Section> sectionsIterable = sectionRepository.findAllById(courseDTO.getSectionIds());
        List<Section> sections = new ArrayList<>();
        sectionsIterable.forEach(sections::add);
        course.setSections(sections);

        courseRepository.save(course);
        System.out.println("Course updated!");
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));
        courseRepository.delete(course);
        System.out.println("Course deleted!");
    }
}


