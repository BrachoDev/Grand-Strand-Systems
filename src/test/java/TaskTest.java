// Carlos Bracho
// Course: CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {

    // Test with valid data
    @Test
    public void testValidTask() {

        // Creating a new task with valid values
        Task task = new Task("1234567890", "make coffee", "Make Delicious Coffee to start the day");

        // Verifying that the task has valid values
        assertEquals("1234567890", task.getTaskID());
        assertEquals("make coffee", task.getName());
        assertEquals("Make Delicious Coffee to start the day", task.getDescription());
    }

    // Test with invalid data when taskID = Null
    @Test
    public void testInvalidTaskID_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "make coffee", "Make Delicious Coffee to start the day");
        });
    }

    // Test with invalid data when taskID = too long
    @Test
    public void testInvalidTaskID_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "make coffee", "Make Delicious Coffee to start the day");
        });
    }

    // Test with invalid data when name = Null
    @Test
    public void testInvalidName_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Make Delicious Coffee to start the day");
        });
    }

    // Test with invalid data when name = too long
    @Test
    public void testInvalidName_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "This name is longer than twenty characters", "Make Delicious Coffee to start the day");
        });
    }

    // Test with invalid data when description = Null
    @Test
    public void testInvalidDescription_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "make coffee", null);
        });
    }

    // Test with invalid data when description = too long
    @Test
    public void testInvalidDescription_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "make coffee", "This is a description longer than 50 characters and should fail!");
        });
    }


}