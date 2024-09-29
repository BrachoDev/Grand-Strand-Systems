// Carlos Bracho
// Course: CS-320

import java.util.HashMap;

public class TaskService {

    // Creating a HashMap to store Tasks
    private HashMap<String, Task> tasksMap = new HashMap<>();

    // Method to add tasks
    public void addTask(Task task) {
        if (tasksMap.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasksMap.put(task.getTaskID(), task);
    }

    // Method to delete tasks by task ID
    public void deleteTask(String taskID) {
        if (!tasksMap.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        tasksMap.remove(taskID);
    }

// Methods to update task per task ID

    // Method to update task name per task ID
    public void updateTaskName(String taskID, String newName) {
        Task task = tasksMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        task.setName(newName);
    }

    // Method to update task description per task ID
    public void updateTaskDescription(String taskID, String newDescription) {
        Task task = tasksMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        task.setDescription(newDescription);
    }

    // For testing purposes, I have included an extra method (getTask) to get a specific task
    public Task getTask(String taskID) {
        Task task = tasksMap.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        return task;
    }

}