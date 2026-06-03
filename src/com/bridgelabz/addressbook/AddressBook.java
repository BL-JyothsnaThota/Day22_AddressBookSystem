package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;

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
    public void sortByCity() {

        personList.stream()
                .sorted(Comparator.comparing(p -> p.city))
                .forEach(System.out::println);
    }
    public void sortByState() {

        personList.stream()
                .sorted(Comparator.comparing(p -> p.state))
                .forEach(System.out::println);
    }
    public void sortByZip() {

        personList.stream()
                .sorted(Comparator.comparingInt(p -> Integer.parseInt(p.zip)))
                .forEach(System.out::println);
    }
    public void sortContacts(Comparator<ContactPerson> comparator) {

        personList.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }
    public void readFromFile(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                ContactPerson person = new ContactPerson(
                        data[0], data[1], data[2],
                        data[3], data[4], data[5],
                        data[6], data[7]
                );

                personList.add(person);
            }

            System.out.println("Contacts loaded from file!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void writeToFile(String filePath) {

        try (FileWriter writer = new FileWriter(filePath)) {

            for (ContactPerson p : personList) {
                writer.write(
                        p.firstName + "," +
                                p.lastName + "," +
                                p.address + "," +
                                p.city + "," +
                                p.state + "," +
                                p.zip + "," +
                                p.phoneNumber + "," +
                                p.email + "\n"
                );
            }

            System.out.println("Contacts saved to file successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public void writeToCSV(String filePath) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            for (ContactPerson p : personList) {

                String[] data = {
                        p.firstName,
                        p.lastName,
                        p.address,
                        p.city,
                        p.state,
                        p.zip,
                        p.phoneNumber,
                        p.email
                };

                writer.writeNext(data);
            }

            System.out.println("Data written to CSV successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void readFromCSV(String filePath) {

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            List<String[]> allData = reader.readAll();

            for (String[] data : allData) {

                ContactPerson person = new ContactPerson(
                        data[0], data[1], data[2],
                        data[3], data[4], data[5],
                        data[6], data[7]
                );

                personList.add(person);
            }

            System.out.println("Data read from CSV successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}