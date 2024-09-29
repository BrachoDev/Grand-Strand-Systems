//  Carlos Bracho
// Course: CS-320

public class Contact {

// Initializing methods

    // contactID was marked as final to make it not updatable
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {

        // Validating contactID
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID: Please enter a valid 10 digit number.");
        }
        this.contactID = contactID;

        // Validating firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name: Please enter a name no longer than 10 characters");
        }
        this.firstName = firstName;

        // Validating lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name: Please enter a last name no longer than 10 characters");
        }
        this.lastName = lastName;

        // Validating phone
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number: Please enter a 10 digit phone number.");
        }
        this.phone = phone;

        // Validating address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address: Please enter an address no longer than 30 characters");
        }
        this.address = address;
    }

// Getters

    //getContactID
    public String getContactID() {
        return contactID;
    }

    //getFirstName
    public String getFirstName() {
        return firstName;
    }

    //getLastName
    public String getLastName() {
        return lastName;
    }

    //getPhone
    public String getPhone() {
        return phone;
    }

    //getAddress
    public String getAddress() {
        return address;
    }

// Setters

    //No setter for contactID since it is not updatable

    //setFirstName
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name: must be non-null and no longer than 10 characters.");
        }
        this.firstName = firstName;
    }

    //setLastName
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name: must be non-null and no longer than 10 characters.");
        }
        this.lastName = lastName;
    }

    //setPhone
    public void setPhone(String phone) {
        // Validating that phone is not null, 10 digits and numbers only.
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number: must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    //setAddress
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address: must be non-null and no longer than 30 characters.");
        }
        this.address = address;
    }
}