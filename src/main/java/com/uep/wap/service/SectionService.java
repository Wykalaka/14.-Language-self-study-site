package com.uep.wap.service;

import com.uep.wap.dto.SectionDTO;
import com.uep.wap.model.Course;
import com.uep.wap.model.Section;
import com.uep.wap.repository.CourseRepository;
import com.uep.wap.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    @Autowired
    private final SectionRepository sectionRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository, CourseRepository courseRepository) {
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
    }

    public void addSection(SectionDTO sectionDTO) {
        Section section = new Section();
        section.setProficiency(sectionDTO.getProficiency());

        Course course = courseRepository.findById(sectionDTO.getC_id())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + sectionDTO.getC_id()));
        section.setCourse(course);

        sectionRepository.save(section);
        System.out.println("Section added!");
    }

    public Iterable<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public void updateSection(SectionDTO sectionDTO) {
        Section section = sectionRepository.findById(sectionDTO.getS_id())
                .orElseThrow(() -> new IllegalArgumentException("Section not found with id: " + sectionDTO.getS_id()));

        section.setProficiency(sectionDTO.getProficiency());

        Course course = courseRepository.findById(sectionDTO.getC_id())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + sectionDTO.getC_id()));
        section.setCourse(course);

        sectionRepository.save(section);
        System.out.println("Section updated!");
    }
}
