// Carlos Bracho
// Course: CS-320

import java.util.HashMap;

public class ContactService {

    // Creating a HashMap to store Contacts.
    private HashMap<String, Contact> contactsMap = new HashMap<>();

    //Method to add contacts
    public void addContact(Contact contact) {
        // Validating if contact exists in contactsMap already
        if (contactsMap.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        // If not in contactMap, add contact
        contactsMap.put(contact.getContactID(), contact);
    }

    //Method to delete contact
    public void deleteContact(String contactID) {
        if (!contactsMap.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contactsMap.remove(contactID);
    }

    // Method to update contact
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        //Getting contact by ID
        Contact contact = contactsMap.get(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }

        // Setting variables if contacts exists:
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);

        System.out.println("Contact updated successfully.");
    }

/*
I am also adding some an extra method
that I think will be helpful for the final project,
and to help me visualize the program's performance
*/

    // Method to getContact
    public Contact getContact(String contactID) {
        return contactsMap.get(contactID); // Returns the contact or null if not found
    }
}
