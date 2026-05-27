package com.bridgelabz.addressbook;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

        AddressBook addressBook = new AddressBook();

        ContactPerson person = new ContactPerson(
                "John", "Doe", "Street 1",
                "Chennai", "TN", "600001",
                "9876543210", "john@gmail.com"
        );

        addressBook.addContact(person);
        addressBook.editContact("John", "Bangalore");
    }
}