package com.epam.jmp.tabayeu.abstract_facotry.db;

import com.epam.jmp.tabayeu.abstract_facotry.Person;
import com.epam.jmp.tabayeu.abstract_facotry.PersonWriter;

public class DBPersonWriter implements PersonWriter {

    private String fileName;

    public DBPersonWriter(String fileName) {
        super();
        this.fileName = fileName;
    }

    public void writePerson(Person person) {
        // Defining the file name to write or read from Wrapping with a buffer Writing/Reading
    }

}
