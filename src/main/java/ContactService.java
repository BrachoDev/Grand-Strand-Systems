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
    public boolean deleteContact(String contactID) {
        // Validating that contactMap contains the ID before deleting
        if (contactsMap.containsKey(contactID)) {
            contactsMap.remove(contactID);
            return true;
        }
        // Contact not found scenario
        else {
            System.out.println("Contact does not exist.");
            return false;
        }
    }

    // Method to update contact
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        //Getting contact by ID
        Contact contact = contactsMap.get(contactID);

        if (contact == null) {
            System.out.println("Contact does not exist.");
            return false;
        }

        // Setting variables if contacts exists:
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);

        System.out.println("Contact updated successfully.");
        return true;
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
