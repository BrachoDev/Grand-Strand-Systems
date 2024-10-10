// Carlos Bracho
// Course: CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        // Initializing the contact service before each test
        taskService = new TaskService();
    }

    // Test for getTask to ensure it works properly
    @Test
    public void testGetTask(){
        //Adding new tasks
        Task task1 = new Task("1234567890", "Clean Bathroom", "Clean Toilet and Shower");
        Task task2 = new Task("0987654321", "Wash Dishes", "Wash all dirty plates");
        taskService.addTask(task1);
        taskService.addTask(task2);

        Task retrievedTask = taskService.getTask("0987654321");

        // Making sure that task is not null
        assertNotNull(retrievedTask);

        // Making sure that getTask retrieves the correct information
        assertEquals("0987654321", retrievedTask.getTaskID());
        assertEquals("Wash Dishes", retrievedTask.getName());
        assertEquals("Wash all dirty plates", retrievedTask.getDescription());
    }


    // Test for adding a valid task
    @Test
    public void testAddValidTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        Task retrievedTask = taskService.getTask("1234567890");

        // Making sure task was added
        assertNotNull(retrievedTask);

        //Verifying task's values
        assertEquals("1234567890", retrievedTask.getTaskID());
        assertEquals("Task Name", retrievedTask.getName());
        assertEquals("Task Description", retrievedTask.getDescription());
    }

    // Test for adding a task with duplicate task ID
    @Test
    public void testAddDuplicateTaskID() {
        Task task1 = new Task("1234567890", "Task Name 1", "Task Description 1");
        taskService.addTask(task1);
        Task task2 = new Task("1234567890", "Task Name 2", "Task Description 2");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    // Test for deleting a valid task
    @Test
    public void testDeleteValidTask() {
        Task task = new Task("123456789", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("123456789");

        // Should throw an exception since task was deleted
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask("123");
        });
    }

    // Test for deleting a task with a task ID that does not exist
    @Test
    public void testDeleteNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("nonexistent");
        });
    }

    // Test for updating task name
    @Test
    public void testUpdateTaskName() {
        Task task = new Task("123456789", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.updateTaskName("123456789", "New Name");

        Task updatedTask = taskService.getTask("123456789");
        assertEquals("New Name", updatedTask.getName());
    }

    // Test for updating task name with a task ID that does not exist
    @Test
    public void testUpdateTaskNameNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("nonexistent", "Updated Task");
        });
    }

    // Test for updating task description
    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("1234567890", "Task Name", "Current Description");
        taskService.addTask(task);
        taskService.updateTaskDescription("1234567890", "New Description");

        Task newDescription = taskService.getTask("1234567890");
        assertEquals("New Description", newDescription.getDescription());
    }

    // Test for updating task description with a task ID that does not exist
    @Test
    public void testUpdateTaskDescriptionNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("nonexistent", "New Description");
        });
    }
}