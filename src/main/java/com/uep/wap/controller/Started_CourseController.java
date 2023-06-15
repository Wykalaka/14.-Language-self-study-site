package com.uep.wap.controller;

import com.uep.wap.dto.Started_CourseDTO;
import com.uep.wap.service.Started_CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/started_course")
public class Started_CourseController {

    private final Started_CourseService started_courseService;

    public Started_CourseController(Started_CourseService started_courseService) {
        this.started_courseService = started_courseService;
    }

    @PostMapping
    public String addStarted_Course(@RequestBody Started_CourseDTO started_courseDTO) {
        started_courseService.addStarted_Course(started_courseDTO);
        return "Started_Course added!";
    }

    @GetMapping
    public Iterable<com.uep.wap.model.Started_Course> getAllStarted_Courses() {
        return started_courseService.getAllStarted_Courses();
    }

    @PutMapping(path = "/{id}")
    public String updateStarted_Course(@PathVariable("id") Integer id, @RequestBody Started_CourseDTO started_courseDTO) {
        started_courseDTO.setSc_id(id);
        started_courseService.updateStarted_Course(started_courseDTO);
        return "Started_Course updated!";
    }
}
