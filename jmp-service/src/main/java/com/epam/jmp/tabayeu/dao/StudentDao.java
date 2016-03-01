package com.epam.jmp.tabayeu.dao;

import com.epam.jmp.tabayeu.model.Student;

public interface StudentDao {

    /**
     * Returns student using its internal id.
     * @param id
     * @return
     */
    Student getStudentById(long id);
}
