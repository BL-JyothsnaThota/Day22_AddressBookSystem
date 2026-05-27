package com.bridgelabz.addressbook;

public class ContactPerson {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;

    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void display() {
        System.out.println(firstName + " " + lastName + ", " + address + ", "
                + city + ", " + state + ", " + zip + ", "
                + phoneNumber + ", " + email);
    }
}