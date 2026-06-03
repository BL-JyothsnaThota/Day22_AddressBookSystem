package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;


public class AddressBookMain {

    public static void main(String[] args) {
        AddressBook app = new AddressBook();

        List<ContactPerson> list = new ArrayList<>();

        list.add(new ContactPerson("John", "Doe", "Street1",
                "Chennai", "TN", "600001", "9876543210", "john@gmail.com"));

        list.add(new ContactPerson("Jane", "Smith", "Street2",
                "Bangalore", "KA", "560001", "9123456780", "jane@gmail.com"));

        // Write JSON
        app.writeToJson("addressbook.json", list);

        // Read JSON
        List<ContactPerson> newList = app.readFromJson("addressbook.json");

        // Print
        for (ContactPerson p : newList) {
            System.out.println(p.firstName + " - " + p.city);
        }

    }
}