package com.epam.jmp.tabayeu.dao;

import com.epam.jmp.tabayeu.model.Student;

/**
 * This implementation of student dao connects to goverment databases,
 * uses some rocket since encodings, sends emails per each method call, and
 * does lots of other things that we are not interested in.
 * @author Tsimur_Abayeu
 *
 */
public class HardcoreDaoThatCanBeMockedWhileTestingService implements StudentDao{

    @Override
    public Student getStudentById(long id) {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student student = new Student("Student Name", "Student Surname", 5);
        return student;
    }

}
