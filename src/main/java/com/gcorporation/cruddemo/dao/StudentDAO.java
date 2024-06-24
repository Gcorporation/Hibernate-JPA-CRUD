package com.gcorporation.cruddemo.dao;

import com.gcorporation.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
