package com.uep.wap.service;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.Course;
import com.uep.wap.model.Role;
import com.uep.wap.model.Started_Course;
import com.uep.wap.model.User;
import com.uep.wap.repository.CourseRepository;
import com.uep.wap.repository.RoleRepository;
import com.uep.wap.repository.Started_CourseRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;


    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final Started_CourseRepository startedCourseRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, CourseRepository courseRepository, Started_CourseRepository startedCourseRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.courseRepository = courseRepository;
        this.startedCourseRepository = startedCourseRepository;
    }

    public void addUser(UserDTO userDTO) {
        User user = new User();
        user.setFirst_Name(userDTO.getFirst_Name());
        user.setLast_Name(userDTO.getLast_Name());
        user.setDate_of_birth(userDTO.getDate_of_birth());
        user.setE_mail(userDTO.getE_mail());
        user.setPassword(userDTO.getPassword());

        // Set Role
        Role role = roleRepository.findById(userDTO.getRole_id())
                .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + userDTO.getRole_id()));
        user.setRole(role);

        // Set Started Courses
        List<Started_Course> startedCourses = new ArrayList<>();
        if (userDTO.getStarted_course_ids() != null) {
            for (Integer courseId : userDTO.getStarted_course_ids()) {
                Course course = courseRepository.findById(courseId)
                        .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + courseId));
                Started_Course startedCourse = new Started_Course();
                startedCourse.setCourse(course);
                startedCourse.setUser(user);
                startedCourseRepository.save(startedCourse);
                startedCourses.add(startedCourse);
            }
        }
        user.setStarted_courses(startedCourses);

        userRepository.save(user);
        System.out.println("User added!");
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return user;
    }

    public void updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getU_id())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userDTO.getU_id()));
        user.setFirst_Name(userDTO.getFirst_Name());
        user.setLast_Name(userDTO.getLast_Name());
        user.setDate_of_birth(userDTO.getDate_of_birth());
        user.setE_mail(userDTO.getE_mail());
        user.setPassword(userDTO.getPassword());

        // Set Role
        Role role = roleRepository.findById(userDTO.getRole_id())
                .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + userDTO.getRole_id()));
        user.setRole(role);

        // Set Started Courses
        List<Started_Course> startedCourses = new ArrayList<>();
        if (userDTO.getStarted_course_ids() != null) {
            for (Integer courseId : userDTO.getStarted_course_ids()) {
                Course course = courseRepository.findById(courseId)
                        .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + courseId));
                Started_Course startedCourse = new Started_Course();
                startedCourse.setCourse(course);
                startedCourse.setUser(user);
                startedCourseRepository.save(startedCourse);
                startedCourses.add(startedCourse);
            }
        }
        user.setStarted_courses(startedCourses);

        userRepository.save(user);
        System.out.println("User updated!");
    }


    public void deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        userRepository.delete(user);
        System.out.println("User deleted!");
    }

    public void addCourseToUser(Integer userId, Integer startedCourseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        Started_Course startedCourse = startedCourseRepository.findById(startedCourseId)
                .orElseThrow(() -> new IllegalArgumentException("Started Course not found with id: " + startedCourseId));

        startedCourse.setUser(user);

        startedCourseRepository.save(startedCourse);

        user.getStarted_courses().add(startedCourse);
        userRepository.save(user);

        System.out.println("Course added to user!");
    }
}


