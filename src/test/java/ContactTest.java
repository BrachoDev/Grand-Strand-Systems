// Carlos Bracho
// Course: CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    // Test with valid data
    @Test
    public void testValidContact() {

        //Creating a new contact with valid values
        Contact contact = new Contact("1234567890", "Camille", "Shaine", "0987654321", "123 Pallet Town");

        // Verifying that contact was created with valid values
        assertEquals("1234567890", contact.getContactID());
        assertEquals("Camille", contact.getFirstName());
        assertEquals("Shaine", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("123 Pallet Town", contact.getAddress());

    }

    // Test with invalid data when contactID = Null
    @Test
    public void testInvalidContactID_Null() {
        // Expect IllegalArgumentException when contactID is too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Camille", "Shaine", "0987654321", "123 Pallet Town");
        });
    }

    // Test with invalid data when contactID = Too Long
    @Test
    public void testInvalidContactID_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Camille", "Shaine", "0987654321", "123 Pallet Town");
        });
    }

    // Test with invalid First Name
    @Test
    public void testNullFirstName() {
        // Expect IllegalArgumentException when firstName is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Shaine", "0987654321", "123 pallet Town");
        });
    }

    // Test with invalid Last Name
    @Test
    public void testNullLastName() {
        // Expect IllegalArgumentException when lastName is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", null, "0987654321", "123 pallet Town");
        });
    }

    // Test with invalid Phone
    @Test
    public void testInvalidPhoneNumber() {
        // Expect IllegalArgumentException when phone number is not 10 digits
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", "Shaine", "12345", "123 Pallet Town");
        });
    }

    // Test with invalid Address
    @Test
    public void testAddressTooLong() {
        // Expect IllegalArgumentException when address is longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", "Shaine", "0987654321", "123 Pallet Town 12345678901234567890");
        });
    }

}