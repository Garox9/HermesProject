package com.garox.hermesproject;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class HermesController {
    private static int UNDEFINED = -1;
    private static int ADD_TASK = 0;
    private static int SHOW_TASKS = 1;
    private static int CLOSE_HERMES = 2;

    private final TaskRepository taskRepository;
    private final FileService fileService;
    private final Scanner scanner;

    public HermesController(TaskRepository taskRepository, FileService fileService, Scanner scanner) {
        this.taskRepository = taskRepository;
        this.fileService = fileService;
        this.scanner = scanner;
    }

    void mainLoop() {}
}
