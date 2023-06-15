package com.uep.wap.controller;

import com.uep.wap.dto.SectionDTO;
import com.uep.wap.service.SectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/section")
public class SectionController {

    private final SectionService sectionService;


    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping
    public String addSection(@RequestBody SectionDTO sectionDTO) {
        sectionService.addSection(sectionDTO);
        return "Section added!";
    }

    @GetMapping
    public Iterable<com.uep.wap.model.Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @PutMapping(path = "/{id}")
    public String updateSection(@PathVariable("id") Integer id, @RequestBody SectionDTO sectionDTO) {
        sectionDTO.setS_id(id);
        sectionService.updateSection(sectionDTO);
        return "Section updated!";
    }
}
