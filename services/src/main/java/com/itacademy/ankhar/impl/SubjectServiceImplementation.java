package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.Subject;
import com.itacademy.ankhar.interfaces.SubjectService;

import java.util.ArrayList;
import java.util.List;

public class SubjectServiceImplementation implements SubjectService {
    private static SubjectService subjectInstance;
    private SubjectServiceImplementation() {
    }

    public static SubjectService getInstance() {
        if (subjectInstance == null) {
            synchronized (SubjectServiceImplementation.class) {
                if (subjectInstance == null) {
                    subjectInstance = new SubjectServiceImplementation();
                }
            }
        }
        return subjectInstance;
    }

    @Override
    public List<Subject> getSubjects() {
        List<Subject> subjectList = new ArrayList<>();
        Subject mock = new Subject();
        mock.setName("Uno");
        mock.setDescription("Sweden");
        mock.setHours(10);
        mock.setStartDate(2);
        subjectList.add(mock);
        mock = new Subject();
        mock.setName("Runa");
        mock.setDescription("China");
        mock.setHours(2);
        mock.setStartDate(4);
        subjectList.add(mock);
        return subjectList;
    }
}
