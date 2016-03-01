package com.epam.jmp.tabayeu.service;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.jmp.tabayeu.dao.StudentDao;
import com.epam.jmp.tabayeu.model.Student;

/**
 * Test for {@link StudentServiceImpl} using mocks for Dao.
 * @author Tsimur_Abayeu
 *
 */
public class StudentServiceImplTestUsingDaoMocks {

    private StudentServiceImpl service;

    private Student student;

    @BeforeTest
    public void initializeMocks() {
        service = new StudentServiceImpl();
        StudentDao mockedDao = mock(StudentDao.class);
        student = new Student("name", "surname", 4);
        service.setDao(mockedDao);
        doReturn(student).when(mockedDao).getStudentById(anyLong());
    }

    @Test
    public void serviceGetFullNameReturnsConcatinatedNameAndSurname() {
        assertEquals(service.getFullName(0l), student.getName() + " " + student.getSurname());
    }

    @Test
    public void serviceGetStudentSalaryReturnsRatingMultipliedByCoefficient() {
        assertEquals(service.getStudentSalary(0l), student.getRating() * StudentServiceImpl.SALARY_MULTUPLIER);
    }

}
