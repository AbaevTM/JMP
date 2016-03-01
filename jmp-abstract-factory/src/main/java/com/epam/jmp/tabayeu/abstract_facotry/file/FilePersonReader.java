package com.epam.jmp.tabayeu.abstract_facotry.file;

import com.epam.jmp.tabayeu.abstract_facotry.Person;
import com.epam.jmp.tabayeu.abstract_facotry.PersonReader;

public class FilePersonReader implements PersonReader {

    private String fileName;

    public FilePersonReader(String fileName) {
        super();
        this.fileName = fileName;
    }

    public Person readPerson() {
        // Defining the file name to write or read from Wrapping with a buffer Writing/Reading
        return null;
    }

    public Person readPersonByName(String name) {
        // Defining the file name to write or read from Wrapping with a buffer Writing/Reading
        return null;
    }

}
