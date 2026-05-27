package com.bridgelabz.addressbook;

import java.util.HashMap;

public class AddressBookMain {

    public static void main(String[] args) {

        HashMap<String, AddressBook> addressBookMap = new HashMap<>();

        AddressBook homeBook = new AddressBook();
        addressBookMap.put("Home", homeBook);

        AddressBook officeBook = new AddressBook();
        addressBookMap.put("Office", officeBook);
        addressBookMap.values().stream()
                .flatMap(book -> book.personList.stream())
                .filter(p -> p.city.equals("Chennai"))
                .forEach(ContactPerson::display);
    }
}