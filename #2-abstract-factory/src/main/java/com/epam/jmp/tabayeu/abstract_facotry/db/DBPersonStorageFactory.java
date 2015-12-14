package com.epam.jmp.tabayeu.abstract_facotry.db;

import com.epam.jmp.tabayeu.abstract_facotry.PersonReader;
import com.epam.jmp.tabayeu.abstract_facotry.PersonStorageFactory;
import com.epam.jmp.tabayeu.abstract_facotry.PersonWriter;

public class DBPersonStorageFactory implements PersonStorageFactory {

    private String dbURL;

    public DBPersonStorageFactory(String dbURL) {
        super();
        this.dbURL = dbURL;
    }

    public PersonReader getPersonReader() {
        return new DBPersonReader(dbURL);
    }

    public PersonWriter getPersonWriter() {
        return new DBPersonWriter(dbURL);
    }
}
