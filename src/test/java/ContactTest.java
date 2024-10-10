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
        // Expect IllegalArgumentException when contactID is Null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Camille", "Shaine", "0987654321", "123 Pallet Town");
        });
    }

    // Test with invalid data when contactID = Too Long
    @Test
    public void testInvalidContactID_TooLong() {
        // Expect IllegalArgumentException when contactID is Too Long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Camille", "Shaine", "0987654321", "123 Pallet Town");
        });
    }

    // Test with invalid First Name = null
    @Test
    public void testNullFirstName() {
        // Expect IllegalArgumentException when firstName is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Shaine", "0987654321", "123 pallet Town");
        });
    }

    // Test with invalid First Name = Too Long
    @Test
    public void testInvalidFirstName_TooLong() {
        // Expect IllegalArgumentException when firstName is Too Long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille Shaine", "Shaine", "0987654321", "123 Pallet Town");
        });
    }

    // Test with invalid Last Name = Null
    @Test
    public void testNullLastName() {
        // Expect IllegalArgumentException when lastName is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", null, "0987654321", "123 pallet Town");
        });
    }

    // Test with invalid Last Name = Too Long
    @Test
    public void testLastName_TooLong() {
        // Expect IllegalArgumentException when lastName is Too Long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", "Shaine Bracho Test", "0987654321", "123 pallet Town");
        });
    }

    // Test with invalid Phone = Too Short
    @Test
    public void testInvalidPhoneNumber_TooShort() {
        // Expect IllegalArgumentException when phone number is not exactly 10 digits
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", "Shaine", "12345", "123 Pallet Town");
        });
    }

    // Test with invalid Phone = Null
    @Test
    public void testInvalidPhoneNumber_Null() {
        // Expect IllegalArgumentException when phone number is Null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", "Shaine", null, "123 Pallet Town");
        });
    }

    // Test with invalid Address = Too Long
    @Test
    public void testInvalidAddress_TooLong() {
        // Expect IllegalArgumentException when address is longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", "Shaine", "0987654321", "123 Pallet Town 12345678901234567890");
        });
    }

    // Test with invalid Address = null
    @Test
    public void testInvalidAddress_Null() {
        // Expect IllegalArgumentException when address is longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Camille", "Shaine", "0987654321", null);
        });
    }

}