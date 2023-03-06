package main;

import main.model.ITaskRepository;
import main.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    // Создаем репозиторий
    @Autowired
    ITaskRepository taskRepository;

    // Создание             Create
    @PostMapping("/task/")
    public int addTask(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @GetMapping("/task/")
    public List<Task> tasklist() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @GetMapping("/task/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/task/{id}")
    public Task editTask(@PathVariable int id) {
        Task newTask = new Task();
        newTask.setId(id);
        taskRepository.save(newTask);
        return newTask;
    }

    @DeleteMapping(value = "/task/{id}")
    public void delTask(@PathVariable int id) {                                  // Delete
        taskRepository.deleteById(id);
    }
}
