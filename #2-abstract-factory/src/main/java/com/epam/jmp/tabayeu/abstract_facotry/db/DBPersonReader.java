package com.epam.jmp.tabayeu.abstract_facotry.db;

import com.epam.jmp.tabayeu.abstract_facotry.Person;
import com.epam.jmp.tabayeu.abstract_facotry.PersonReader;

public class DBPersonReader implements PersonReader {

    private String fileName;

    public DBPersonReader(String fileName) {
        super();
        this.fileName = fileName;
    }

    public Person readPerson() {
        // Writing/Reading Persons Writing to the DB is also done in three steps:
        return null;
    }

    public Person readPersonByName(String name) {
        // Writing/Reading Persons Writing to the DB is also done in three steps:
        return null;
    }

}
