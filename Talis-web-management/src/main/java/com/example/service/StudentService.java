package com.example.service;


import com.example.pojo.PageResult;
import com.example.pojo.StuQueryParm;
import com.example.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> list();

    PageResult<Student> page(StuQueryParm studentQueryParam);

    void insert(Student student);

    Student findById(Integer id);

    void update(Student student);

    void deleteById(Integer id);

    void addViolation(Integer id, Short score);
}
