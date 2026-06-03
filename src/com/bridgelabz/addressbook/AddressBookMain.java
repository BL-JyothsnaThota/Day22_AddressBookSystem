package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;


public class AddressBookMain {

    public static void main(String[] args) {













        AddressBook book = new AddressBook();

        book.addContact(new ContactPerson("John", "Doe", "Street1",
                "Chennai", "TN", "600001", "9999999999", "john@gmail.com"));

        book.addContact(new ContactPerson("Alice", "Roy", "Street2",
                "Bangalore", "KA", "560001", "8888888888", "alice@gmail.com"));

// Write to file
        book.writeToFile("contacts.txt");

// Clear list (to test reading)
        book.personList.clear();

// Read from file
        book.readFromFile("contacts.txt");

// Display
        book.displayAll();
    }
}