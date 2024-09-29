// Carlos Bracho
// Course: CS-320

public class Task {

// Initializing variables

    // taskID was marked as final to make it not updatable
    private final String taskID;
    private String name;
    private String description;

    // Constructor
    public Task(String taskID, String name, String description) {

        // Validating taskID
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid Task ID.");
        }
        this.taskID = taskID;

        // Validating Name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Name.");
        }
        this.name = name;

        // Validating description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }
        this.description = description;
    }

// Getter Methods

    //getTaskID
    public String getTaskID() {
        return taskID;
    }

    //getName
    public String getName() {
        return name;
    }

    //getDescription
    public String getDescription() {
        return description;
    }

// Setter Methods (NOTE: There is not setTaskID since it is not updatable)

    //setName
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name.");
        }
        this.name = name;
    }

    //setDescription
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }
        this.description = description;
    }
}

