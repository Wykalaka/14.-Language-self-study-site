package com.uep.wap.service;

import com.uep.wap.model.Student;
import com.uep.wap.repository.StudentRepository;
import com.uep.wap.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setPoints(studentDTO.getPoints());
        studentRepository.save(student);
        System.out.println("Students added!");
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    //metoda do aktualizowania istniejacego studenta
    public void updateStudent(StudentDTO studentDTO) {
        Student student = studentRepository.findById(studentDTO.getId()).get();
        student.setName(studentDTO.getName());
        student.setPoints(studentDTO.getPoints());
        studentRepository.save(student);
        System.out.println("Students updated!");
    }

    public void addUser(StudentDTO studentDTO) {

    }
}
