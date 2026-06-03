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

// Write CSV
        book.writeToCSV("contacts.csv");

// Clear list
        book.personList.clear();

// Read CSV
        book.readFromCSV("contacts.csv");

// Display
        book.displayAll();

    }
}