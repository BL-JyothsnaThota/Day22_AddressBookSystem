package com.bridgelabz.addressbook;

public class AddressBook {

    ContactPerson person;

    public void addContact(ContactPerson person) {
        this.person = person;
        System.out.println("Contact Added:");
        person.display();
    }
}