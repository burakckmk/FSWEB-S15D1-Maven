package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    // Constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    // Constructor with contacts list
    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }

    // Getter methods
    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    // Add new contact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return false; // Contact already exists
        }
        return myContacts.add(contact);
    }

    // Update existing contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            return false; // Contact not found
        }
        myContacts.set(position, newContact);
        return true;
    }

    // Remove contact
    public boolean removeContact(Contact contact) {
        return myContacts.remove(contact);
    }

    // Find contact by Contact object
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // Find contact by name
    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    // Query contact by name
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    // Print all contacts
    public void printContact() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).toString());
        }
    }
}