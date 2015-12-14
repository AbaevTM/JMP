package com.epam.jmp.tabayeu.abstract_facotry;

import com.epam.jmp.tabayeu.abstract_facotry.db.DBPersonStorageFactory;
import com.epam.jmp.tabayeu.abstract_facotry.file.FilePersonStorageFactory;

public class Client {

    public static void main(String[] args) {
        PersonStorageFactory fileStorageFactory = new FilePersonStorageFactory("D:/persons.xml");
        PersonStorageFactory dbStorageFactory = new DBPersonStorageFactory("jdbc:postgresql://database/persons");
        imitateWork(dbStorageFactory);
        imitateWork(fileStorageFactory);
    }

    public static void imitateWork(PersonStorageFactory storageFactory) {
        Person person = new Person(0, "PersonName");
        PersonWriter writer = storageFactory.getPersonWriter();
        PersonReader reader = storageFactory.getPersonReader();
        // This means that and beside specifying the source (File/DB)  working with the actual resource should be transparent and includes the following operations: void writePerson (Person) Person readPerson() Person readPerson (String name)
        writer.writePerson(person);
        Person personCopy = reader.readPerson();
        personCopy = reader.readPersonByName("PersonName");
        System.out.println(person.equals(personCopy));
    }
}
