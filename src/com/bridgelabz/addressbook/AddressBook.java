package com.bridgelabz.addressbook;

import java.util.ArrayList;

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
}