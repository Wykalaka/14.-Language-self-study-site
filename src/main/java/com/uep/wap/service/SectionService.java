package com.uep.wap.service;

import com.uep.wap.dto.SectionDTO;
import com.uep.wap.model.Section;
import com.uep.wap.repository.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public void addSection(SectionDTO sectionDTO) {
        Section section = new Section();
        section.setProficiency(sectionDTO.getProficiency());
        System.out.println("Section added!");
    }

    public Iterable<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public void updateSection(SectionDTO sectionDTO) {
        Section section = sectionRepository.findById(sectionDTO.getS_id()).orElseThrow(() -> new IllegalArgumentException("Section not found with id: " + sectionDTO.getS_id()));
        section.setProficiency(sectionDTO.getProficiency());
        sectionRepository.save(section);
        System.out.println("Section updated!");
    }
}
