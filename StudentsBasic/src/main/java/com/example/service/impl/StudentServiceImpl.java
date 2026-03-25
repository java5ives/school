package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id, Student student) {

        Student s = repo.findById(id).orElse(null);

        if(s != null){
            s.setName(student.getName());
            s.setCity(student.getCity());
            s.setAge(student.getAge());
            return repo.save(s);
        }

        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

}