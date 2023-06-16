package com.uep.wap.service;

import com.uep.wap.dto.Started_CourseDTO;
import com.uep.wap.model.Course;
import com.uep.wap.model.Started_Course;
import com.uep.wap.model.User;
import com.uep.wap.repository.CourseRepository;
import com.uep.wap.repository.Started_CourseRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Started_CourseService {

    @Autowired
    private Started_CourseRepository started_courseRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    public void addStarted_Course(Started_CourseDTO started_courseDTO) {
        Started_Course started_course = new Started_Course();
        started_course.setCompletion(started_courseDTO.getCompletion());
        started_course.setCorrectly(started_courseDTO.getCorrectly());
        started_course.setIncorrectly(started_courseDTO.getIncorrectly());

        User user = userRepository.findById(started_courseDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("No user found with id: " + started_courseDTO.getUserId()));
        started_course.setUser(user);

        Course course = courseRepository.findById(started_courseDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("No course found with id: " + started_courseDTO.getCourseId()));
        started_course.setCourse(course);


        started_courseRepository.save(started_course);
        System.out.println("Started_Course added!");
    }

    public Iterable<Started_Course> getAllStarted_Courses() {
        return started_courseRepository.findAll();
    }

    public void updateStarted_Course(Started_CourseDTO started_courseDTO) {
        Started_Course started_course = started_courseRepository.findById(started_courseDTO.getSc_id()).orElseThrow(() -> new IllegalArgumentException("Started_Course not found with id: " + started_courseDTO.getSc_id()));
        started_course.setCompletion(started_courseDTO.getCompletion());
        started_course.setCorrectly(started_courseDTO.getCorrectly());
        started_course.setIncorrectly(started_courseDTO.getIncorrectly());
        started_courseRepository.save(started_course);
        System.out.println("Started_Course updated!");
    }
}
