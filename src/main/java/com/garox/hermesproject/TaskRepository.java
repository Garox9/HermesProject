package com.garox.hermesproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks;

    @Autowired
    TaskRepository(FileService fileService) {
        try {
            this.tasks = fileService.readAllFiles();
        }catch (IOException e) {
            tasks = new ArrayList<>();
        }
    }

    List<Task> getAll() {
        return tasks;
    }

    void add(Task task) {
        tasks.add(task);
    }

    int size() {
        return tasks.size();
    }

    boolean isEmpty() {
        return tasks.isEmpty();
    }
}
