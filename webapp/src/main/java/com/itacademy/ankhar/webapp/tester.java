package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.Subject;
import com.itacademy.ankhar.impl.SubjectServiceImplementation;
import com.itacademy.ankhar.interfaces.SubjectService;

import java.util.List;

public class tester {
    public static void main(String[] args) {
        SubjectService subjectService = SubjectServiceImplementation.getInstance();
        List<Subject> subjects = subjectService.getSubjects();
        System.out.println(subjects);
    }
}
