# Grand Strand Systems - Mobile Application Backend Services

## Overview

This project was developed as part of an assignment for my class CS-320 Software Test, Automation at SNHU. For this assignment, I am acting as a software engineer at a software engineering company. The assignment was to develop and test back-end services for a mobile application, including ContactService, TaskService, and AppointmentService. These services manage the addition, updating, and deletion of contacts, tasks, and appointments. Unit tests were created using JUnit to ensure that the services meet the requirements provided by the customer.

## Project Structure

The project consists of three services:

- **ContactService**: Manages contact objects.
- **TaskService**: Manages task objects.
- **AppointmentService**: Manages appointment objects.

Each service includes corresponding classes and JUnit tests to verify functionality.

## ContactService

The **ContactService** stores contact information in memory and allows users to add, update, and delete contacts.

### Contact Class Requirements:
- Unique `contactId` (String, max 10 characters, non-updatable).
- `firstName` (String, max 10 characters, non-null).
- `lastName` (String, max 10 characters, non-null).
- `phone` (String, exactly 10 digits, non-null).
- `address` (String, max 30 characters, non-null).

### ContactService Requirements:
- Add new contacts with a unique `contactId`.
- Delete contacts by `contactId`.
- Update contact fields: `firstName`, `lastName`, `phone`, `address`.

### Unit Tests:
- `ContactTest.java`: Verifies the `Contact` class meets the requirements.
- `ContactServiceTest.java`: Verifies that the `ContactService` functionality works as expected.

## TaskService

The **TaskService** manages task objects in memory, allowing users to add, update, and delete tasks.

### Task Class Requirements:
- Unique `taskId` (String, max 10 characters, non-updatable).
- `name` (String, max 20 characters, non-null).
- `description` (String, max 50 characters, non-null).

### TaskService Requirements:
- Add new tasks with a unique `taskId`.
- Delete tasks by `taskId`.
- Update task fields: `name`, `description`.

### Unit Tests:
- `TaskTest.java`: Verifies the `Task` class meets the requirements.
- `TaskServiceTest.java`: Verifies that the `TaskService` functionality works as expected.

## AppointmentService

The **AppointmentService** manages appointment objects in memory, allowing users to add and delete appointments.

### Appointment Class Requirements:
- Unique `appointmentId` (String, max 10 characters, non-updatable).
- `appointmentDate` (Date, cannot be in the past, non-null).
- `description` (String, max 50 characters, non-null).

### AppointmentService Requirements:
- Add new appointments with a unique `appointmentId`.
- Delete appointments by `appointmentId`.

### Unit Tests:
- `AppointmentTest.java`: Verifies the `Appointment` class meets the requirements.
- `AppointmentServiceTest.java`: Verifies that the `AppointmentService` functionality works as expected.

## Testing and Coverage

JUnit tests were used to ensure all services and classes meet the specified requirements. JaCoCo was utilized to check code coverage, ensuring that at least 80% of the code is covered by tests.

## Files Submitted

- **ContactService**
  - `Contact.java`
  - `ContactService.java`
  - `ContactTest.java`
  - `ContactServiceTest.java`

- **TaskService**
  - `Task.java`
  - `TaskService.java`
  - `TaskTest.java`
  - `TaskServiceTest.java`

- **AppointmentService**
  - `Appointment.java`
  - `AppointmentService.java`
  - `AppointmentTest.java`
  - `AppointmentServiceTest.java`

## How to Run the Tests

1. Clone the repository from GitHub.
2. Ensure you have JDK 8 or higher installed.
3. Run the JUnit tests using your preferred IDE or a build tool like Maven/Gradle.

## License

This project is for educational purposes and part of a school assignment.
