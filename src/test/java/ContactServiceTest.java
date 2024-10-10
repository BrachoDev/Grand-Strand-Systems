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

    // Test for AddContact Method
    @Test
    public void testAddValidContact() {
        // Creating Contact and adding it to contactsMap
        Contact contact = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact("1234567890");

        // Making Sure that the contact was added
        assertNotNull(retrievedContact);
    }

    // Test for DeleteContact Method
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        contactService.addContact(contact);

        // Deleting the contact and verifying deletion
        assertTrue(contactService.deleteContact("1234567890"));
        assertFalse(contactService.deleteContact("1234567890")); // Should fail since it's already deleted
    }

    // Test for UpdateContact Method
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "Carlos", "Bracho", "0987654321", "123 Pallet Town");
        contactService.addContact(contact);

        // Updating contact details
        assertTrue(contactService.updateContact("1234567890", "Camille", "Shaine", "1234567890", "456 Kanto Region"));

        // Verifying that the contact was updated
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Camille", updatedContact.getFirstName());
        assertEquals("Shaine", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("456 Kanto Region", updatedContact.getAddress());
    }

    // Test for Non-Existent Contact
    @Test
    public void testUpdateNonExistentContact() {
        // Trying to update a contact that doesn't exist should return false
        assertFalse(contactService.updateContact("0000000000", "Ash", "Ketchum", "0987654321", "456 Johto City"));
    }
}
