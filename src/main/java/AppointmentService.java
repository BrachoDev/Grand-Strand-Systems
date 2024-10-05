// Carlos Bracho
// Course: CS-320

import java.util.HashMap;

public class AppointmentService {

    // Creating a HashMap to store Appointments
    private final HashMap<String, Appointment> appointmentsMap = new HashMap<>();

    // Method to add appointments
    public void addAppointment(Appointment appointment) {
        if (appointmentsMap.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointmentsMap.put(appointment.getAppointmentID(), appointment);
    }

    // Method to delete appointments by ID
    public void deleteAppointment(String appointmentID) {
        if (!appointmentsMap.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointmentsMap.remove(appointmentID);
    }

    // Method to update appointment description by ID
    public void updateAppointmentDescription(String appointmentID, String newDescription) {
        if (newDescription == null || newDescription.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be 50 characters or less.");
        }
        Appointment appointment = appointmentsMap.get(appointmentID);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointment.setDescription(newDescription);
    }

    // For testing purposes, I have included an extra method (getAppointment) to get a specific Appointment
    public Appointment getAppointment(String appointmentID) {
        Appointment appointment = appointmentsMap.get(appointmentID);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        return appointment;
    }
}
