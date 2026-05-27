package com.bridgelabz.addressbook;

public class AddressBook {

    ContactPerson person;

    public void addContact(ContactPerson person) {
        this.person = person;
        System.out.println("Contact Added:");
        person.display();
    }
    public void editContact(String firstName, String newCity) {
        if (person != null && person.firstName.equals(firstName)) {
            person.city = newCity;
            System.out.println("Updated Contact:");
            person.display();
        } else {
            System.out.println("Contact not found");
        }
    }
    public void deleteContact(String firstName) {
        if (person != null && person.firstName.equals(firstName)) {
            person = null;
            System.out.println("Contact deleted");
        } else {
            System.out.println("Contact not found");
        }
    }
}