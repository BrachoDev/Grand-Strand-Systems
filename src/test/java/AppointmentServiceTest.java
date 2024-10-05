// Carlos Bracho
// Course: CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        // Initializing the AppointmentService before each test
        appointmentService = new AppointmentService();
    }

    // Test for adding a valid appointment
    @Test
    public void testAddValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Valid future date
        Appointment appointment = new Appointment("1234567890", futureDate, "Dentist appointment");
        appointmentService.addAppointment(appointment);
        Appointment retrievedAppointment = appointmentService.getAppointment("1234567890");

        // Making sure appointment was added
        assertNotNull(retrievedAppointment);

        // Verifying appointment's values
        assertEquals("1234567890", retrievedAppointment.getAppointmentID());
        assertEquals(futureDate, retrievedAppointment.getAppointmentDate());
        assertEquals("Dentist appointment", retrievedAppointment.getDescription());
    }

    // Test for adding an appointment with duplicate ID
    @Test
    public void testAddDuplicateAppointmentID() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        Appointment appointment1 = new Appointment("1234567890", futureDate, "First appointment");
        appointmentService.addAppointment(appointment1);
        Appointment appointment2 = new Appointment("1234567890", futureDate, "Second appointment");

        // Should throw an exception for duplicate ID
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    // Test for adding multiple valid appointments
    @Test
    public void testAddMultipleAppointments() {
        // Creating 2 valid appointments
        Date futureDate1 = new Date(System.currentTimeMillis() + 100000);
        Date futureDate2 = new Date(System.currentTimeMillis() + 200000);
        Appointment appointment1 = new Appointment("1234567890", futureDate1, "Dentist appointment");
        Appointment appointment2 = new Appointment("0987654321", futureDate2, "Doctor appointment");

        // Adding both appointments
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);

        // Verifying both appointments were added correctly
        Appointment retrievedAppointment1 = appointmentService.getAppointment("1234567890");
        Appointment retrievedAppointment2 = appointmentService.getAppointment("0987654321");

        // Verifying that the retrieved appointments != null
        assertNotNull(retrievedAppointment1);
        assertNotNull(retrievedAppointment2);

        // Verifying dates and descriptions
        assertEquals(futureDate1, retrievedAppointment1.getAppointmentDate());
        assertEquals("Dentist appointment", retrievedAppointment1.getDescription());

        assertEquals(futureDate2, retrievedAppointment2.getAppointmentDate());
        assertEquals("Doctor appointment", retrievedAppointment2.getDescription());
    }

    // Test to verify unique ID generation and preventing duplicates
    @Test
    public void testUniqueIDGeneration() {
        // Creating 2 valid appointments
        Date futureDate1 = new Date(System.currentTimeMillis() + 100000);
        Date futureDate2 = new Date(System.currentTimeMillis() + 200000);

        Appointment appointment1 = new Appointment("1234567890", futureDate1, "Dentist appointment");
        Appointment appointment2 = new Appointment("0987654321", futureDate2, "Doctor appointment");

        // Adding both appointments and ensure IDs are unique
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);

        assertThrows(IllegalArgumentException.class, () -> {
            // Trying to add another appointment with the same ID as the first
            Appointment duplicateAppointment = new Appointment("1234567890", futureDate2, "Car appointment");
            appointmentService.addAppointment(duplicateAppointment);
        });
    }

    // Test for deleting a valid appointment
    @Test
    public void testDeleteValidAppointment() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("123456789", futureDate, "Dentist appointment");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("123456789");

        // Should throw an exception since appointment was deleted
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.getAppointment("123456789");
        });
    }

    // Test for deleting an appointment with a non-existent ID
    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("nonexistentID");
        });
    }

    // Test for updating appointment description
    @Test
    public void testUpdateAppointmentDescription() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        Appointment appointment = new Appointment("1234567890", futureDate, "Original Description");
        appointmentService.addAppointment(appointment);
        appointmentService.updateAppointmentDescription("1234567890", "New Description");

        Appointment updatedAppointment = appointmentService.getAppointment("1234567890");
        assertEquals("New Description", updatedAppointment.getDescription());
    }

    // Test for updating description with a non-existent appointment ID
    @Test
    public void testUpdateAppointmentDescriptionNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointmentDescription("nonexistentID", "New Description");
        });
    }

    // Test for updating description with null
    @Test
    public void testUpdateAppointmentDescriptionNull() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Dentist Appointment");
        appointmentService.addAppointment(appointment);

        // Should throw an exception since description is null
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointmentDescription("1234567890", null);
        });
    }

    // Test for updating description with a value that's too long
    @Test
    public void testUpdateAppointmentDescriptionTooLong() {
        // Creating a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Dentist appointment");
        appointmentService.addAppointment(appointment);

        // Should throw an exception for description longer than 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointmentDescription("1234567890",
                    "This is a description that is way too long for this.");
        });
    }
}
