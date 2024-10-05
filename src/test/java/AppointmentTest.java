// Carlos Bracho
// Course: CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {

    // Test with valid data
    @Test
    public void testValidAppointment() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        // Creating a new appointment with valid values
        Appointment appointment = new Appointment("1234567890", futureDate, "Dentist Appointment");

        // Verifying that the appointment has valid values
        assertEquals("1234567890", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Dentist Appointment", appointment.getDescription());
    }

    // Test with invalid data when appointmentID = Null
    @Test
    public void testInvalidAppointmentID_Null() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Dentist Appointment");
        });
    }

    // Test with invalid data when appointmentID = too long
    @Test
    public void testInvalidAppointmentID_TooLong() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Valid future date

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Dentist Appointment");
        });
    }

    // Test with invalid data when appointmentDate = Null
    @Test
    public void testInvalidAppointmentDate_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Dentist Appointment");
        });
    }

    // Test with invalid data when appointmentDate is in the past
    @Test
    public void testInvalidAppointmentDate_Past() {
        // Creating an invalid past date
        Date pastDate = new Date(System.currentTimeMillis() - 100000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Dentist Appointment");
        });
    }

    // Test with invalid data when description = Null
    @Test
    public void testInvalidDescription_Null() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, null);
        });
    }

    // Test with invalid data when description = too long
    @Test
    public void testInvalidDescription_TooLong() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, "This description is way too long for this and should fail");
        });
    }
}
