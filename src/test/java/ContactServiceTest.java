// Carlos Bracho
// Course: CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        // Initializing the contact service before each test
        contactService = new ContactService();
    }

    // Test for making sure that the getContact method works
    @Test
    public void testGetContact(){
        //Adding new contacts
        Contact contact1 = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        Contact contact2 = new Contact("1234567891", "Momo", "Park", "1987654321", "456 Pino Montana");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        Contact retrievedContact = contactService.getContact("1234567890");

        // Making sure that contact is not null
        assertNotNull(retrievedContact);

        // Making sure that getContact retrieves correct information
        assertEquals("1234567890", retrievedContact.getContactID());
        assertEquals("Carlos", retrievedContact.getFirstName());
        assertEquals("Bracho", retrievedContact.getLastName());
        assertEquals("0987654321", retrievedContact.getPhone());
        assertEquals("123 Pallet Town", retrievedContact.getAddress());
    }

    // Test for Adding a valid contact and addContact functionality
    @Test
    public void testAddValidContact() {
        // Creating Contact and adding it to contactsMap
        Contact contact = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact("1234567890");

        // Making Sure that the contact was added
        assertNotNull(retrievedContact);
    }

    // Test for adding a contact with duplicate contactID
    @Test
    public void testAddDuplicateContactID(){
        Contact contact1 = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        Contact contact2 = new Contact("1234567890", "Camille", "Santos", "1234567890", "123 Cool Avenue");
        contactService.addContact(contact1);

        // This should throw and exception for duplicate contact ID
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    // Test for adding multiple valid contacts
    @Test
    public void testAddMultipleContactsInBatch() {
        // Creating multiple Contact objects
        Contact contact1 = new Contact("1234567890", "Leo", "Gonzales", "1234567890", "123 Pallet town");
        Contact contact2 = new Contact("1234567891", "Momo", "Park", "0987654321", "456 Pino Montana");
        Contact contact3 = new Contact("1234567892", "Carlos", "Bracho", "1122334455", "789 Coromoto Way");

        // Adding contacts to ContactsMap
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        contactService.addContact(contact3);

        // Verify that the contacts were added successfully by checking their existence
        assertEquals(contact1, contactService.getContact("1234567890"));
        assertEquals(contact2, contactService.getContact("1234567891"));
        assertEquals(contact3, contactService.getContact("1234567892"));
    }

    // Test for Deleting a valid contact
    @Test
    public void testDeleteValidContact() {
        Contact contact1 = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        Contact contact2 = new Contact("1234567891", "Momo", "Park", "1987654321", "456 Pino Montana");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Deleting one of the contacts from contactsMap
        contactService.deleteContact("1234567890");

        // This should verify that the contact was deleted by checking if it returns null
        assertNull(contactService.getContact("1234567890"));
    }

    // Test for deleting a contact that is not existent
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("nonexistentID");
        });
    }

    // Test for updating valid contact
    @Test
    void testUpdateValidContact() {
        // Adding two contacts to contactsMap
        Contact contact1 = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        Contact contact2 = new Contact("1234567891", "Momo", "Park", "1987654321", "456 Pino Montana");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Updating all fields of an existing contact
        contactService.updateContact("1234567890", "Miguel", "Ortega", "1234567890", "456 Elm St");

        Contact updatedContact = contactService.getContact("1234567890");

        // Assertions to verify the contact was updated correctly
        assertEquals("Miguel", updatedContact.getFirstName());
        assertEquals("Ortega", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    @Test
    void testUpdateContactNonExistent() {
        // Adding two contacts to contactsMap
        Contact contact1 = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        Contact contact2 = new Contact("1234567891", "Momo", "Park", "1987654321", "456 Pino Montana");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Should throw an exception because contact does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567892", "Sasuke", "Uchiha", "0987654321", "456 Elm St");
        });

    }

    // Test for updating a contact using an invalid phone number
    @Test
    void testUpdateContactInvalidPhone() {
        // Adding two contacts to contactsMap
        Contact contact1 = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        Contact contact2 = new Contact("1234567891", "Momo", "Park", "1987654321", "456 Pino Montana");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Phone number too long
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", "Carlos", "Bracho", "09876543211243", "123 Pallet Town");
        });

        // Phone number too short
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", "Carlos", "Bracho", "09876", "123 Pallet Town");
        });

    }

    // Test for updating Contact with Null values
    @Test
    void testUpdateContactNullValues() {
        // Adding two contacts to contactsMap
        Contact contact1 = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        Contact contact2 = new Contact("1234567891", "Momo", "Park", "1987654321", "456 Pino Montana");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // This should throw an exception because values should not be null
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", null, null, null, null);
        });
    }
}
