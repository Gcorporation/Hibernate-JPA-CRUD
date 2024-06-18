package com.gcorporation.cruddemo.dao;

import com.gcorporation.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager

    private EntityManager entitiymanager;

    // Inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entitiymanager) {
        this.entitiymanager = entitiymanager;
    }

    // implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entitiymanager.persist(theStudent);
    }
}
