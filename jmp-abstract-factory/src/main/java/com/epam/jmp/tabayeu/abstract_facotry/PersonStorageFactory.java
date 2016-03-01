package com.epam.jmp.tabayeu.abstract_facotry;

public interface PersonStorageFactory {

    PersonReader getPersonReader();

    PersonWriter getPersonWriter();
}
