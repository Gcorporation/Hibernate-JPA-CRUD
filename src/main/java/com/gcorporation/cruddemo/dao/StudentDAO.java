package com.gcorporation.cruddemo.dao;

import com.gcorporation.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Student theStudent);
}
