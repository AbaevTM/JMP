package com.epam.jmp.tabayeu.service;

import com.epam.jmp.tabayeu.dao.StudentDao;
import com.epam.jmp.tabayeu.model.Student;

/**
 * Basic implementation of {@link StudentService}.
 * @author Tsimur_Abayeu
 *
 */
public class StudentServiceImpl implements StudentService {

    public static final int SALARY_MULTUPLIER = 10;

    private StudentDao dao;

    @Override
    public String getFullName(long studentId) {
        Student student = dao.getStudentById(studentId);
        return student.getName() + " " + student.getSurname();
    }

    @Override
    public int getStudentSalary(long studentId) {
        Student student = dao.getStudentById(studentId);
        return student.getRating() * SALARY_MULTUPLIER;
    }

    public StudentDao getDao() {
        return dao;
    }

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }
}
