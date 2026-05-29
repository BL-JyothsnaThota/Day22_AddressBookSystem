package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;


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

        Map<String, List<ContactPerson>> cityMap = new HashMap<>();

        for (AddressBook book : addressBookMap.values()) {
            for (ContactPerson p : book.personList) {
                cityMap.computeIfAbsent(p.city, k -> new ArrayList<>()).add(p);
            }
        }
        Map<String, Long> countByCity =
                addressBookMap.values().stream()
                        .flatMap(book -> book.personList.stream())
                        .collect(Collectors.groupingBy(p -> p.city, Collectors.counting()));

        System.out.println(countByCity);
    }
}