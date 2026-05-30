package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    ArrayList<ContactPerson> personList = new ArrayList<>();

    

    public void displayAll() {
        for (ContactPerson p : personList) {
            p.display();
        }
    }
    public void editContact(String firstName, String newCity) {
        for (ContactPerson p : personList) {
            if (p.firstName.equals(firstName)) {
                p.city = newCity;
                return;
            }
        }
    }
    public void deleteContact(String firstName) {
        personList.removeIf(p -> p.firstName.equals(firstName));
    }
    public void addContact(ContactPerson person) {

        for (ContactPerson p : personList) {
            if (p.equals(person)) {
                System.out.println("Duplicate Entry!");
                return;
            }
        }
        personList.add(person);
    }
    public void sortByName() {

        List<ContactPerson> sortedList = personList.stream()
                .sorted(Comparator.comparing(p -> p.firstName))
                .collect(Collectors.toList());

        System.out.println("Sorted Contacts:");
        sortedList.forEach(System.out::println);
    }
    public void sortByFullName() {

        List<ContactPerson> sortedList = personList.stream()
                .sorted(Comparator
                        .comparing((ContactPerson p) -> p.firstName)
                        .thenComparing(p -> p.lastName))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }
}