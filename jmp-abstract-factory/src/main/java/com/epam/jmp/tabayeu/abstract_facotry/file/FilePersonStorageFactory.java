package com.epam.jmp.tabayeu.abstract_facotry.file;

import com.epam.jmp.tabayeu.abstract_facotry.PersonReader;
import com.epam.jmp.tabayeu.abstract_facotry.PersonStorageFactory;
import com.epam.jmp.tabayeu.abstract_facotry.PersonWriter;

public class FilePersonStorageFactory implements PersonStorageFactory {

    private String fileName;

    public FilePersonStorageFactory(String fileName) {
        super();
        this.fileName = fileName;
    }

    public PersonReader getPersonReader() {
        return new FilePersonReader(fileName);
    }

    public PersonWriter getPersonWriter() {
        return new FilePersonWriter(fileName);
    }
}
