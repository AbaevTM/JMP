package com.epam.jmp.tabayeu.service;

public interface StudentService {

    /**
     * Returns full student name based on their name and surname.
     * @param student
     * @return
     */
    String getFullName(long studentId);

    /*
     * Returns student salary that depends on therie ratings.
     */
    int getStudentSalary(long studentId);
}
