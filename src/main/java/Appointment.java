// Carlos Bracho
// Course: CS-320

import java.util.Date;

public class Appointment {

// Initializing variables

    // appointmentID was marked as final to make it not updatable
    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    // Constructor
    public Appointment(String appointmentID, Date appointmentDate, String description) {

        // Validating appointmentID
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid Appointment ID.");
        }
        this.appointmentID = appointmentID;

        // Validating appointmentDate
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid Appointment Date.");
        }
        this.appointmentDate = appointmentDate;

        // Validate and assign description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }
        this.description = description;
    }

// Getter Methods

    //getAppointmentID
    public String getAppointmentID() {
        return appointmentID;
    }

    //getAppointmentDate
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    //getDescription
    public String getDescription() {
        return description;
    }

// Setter Methods (NOTE: There is not setAppointmentID because it is not updatable)

    //setAppointmentDate
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid Appointment Date.");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }
        this.description = description;
    }
}