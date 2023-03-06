package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskStorage {

    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static int addTask(Task task) {                                // Create
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    // Чтение всех записей         Read List
    public static List<Task> getAllTasks() {
        ArrayList<Task> taskList = new ArrayList<>(tasks.values());
        return taskList;
    }

    // Чтение одной записи по индексу                    Read
    public static Task getTask(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }
        return null;
    }

    public static boolean editTask(int taskId) {                                 // Update
        if (tasks.containsKey(taskId)) {
            delTask(taskId);
            Task newTask = new Task();
            newTask.setId((taskId));
          tasks.put (taskId,newTask);
           return true;
        }
         return false;
    }



    public static boolean delTask(int taskId) {                                  // Delete
            if (tasks.containsKey(taskId)) {
                return tasks.remove(taskId,tasks.get(taskId));
            }
        return false;
    }
    // So, CRUD is realised;
}
