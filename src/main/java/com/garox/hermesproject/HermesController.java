package com.garox.hermesproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

@Controller
public class HermesController {
    private static final int UNDEFINED = -1;
    private static final int ADD_TASK = 0;
    private static final int SHOW_TASKS = 1;
    private static final int CLOSE_HERMES = 2;

    private final TaskRepository taskRepository;
    private final FileService fileService;
    private final Scanner scanner;
    private final ConsoleOutputWriter consoleOutputWriter;
    @Autowired
    public HermesController(TaskRepository taskRepository, FileService fileService, Scanner scanner, ConsoleOutputWriter consoleOutputWriter) {
        this.taskRepository = taskRepository;
        this.fileService = fileService;
        this.scanner = scanner;
        this.consoleOutputWriter = consoleOutputWriter;
    }

    void mainLoop() {
        consoleOutputWriter.printl("Witaj w Hermesie");
        int option = UNDEFINED;
        while (option != CLOSE_HERMES) {
            printMenu();
            option = chooseOption();
            executeOption(option);
        }
    }

    private void executeOption(int option) {
        switch (option) {
            case ADD_TASK -> addEntry();
            case SHOW_TASKS -> showTasks();
            case CLOSE_HERMES -> close();
            default -> consoleOutputWriter.printl("opcja nieznana");
        }
    }

    private void showTasks() {
        for (Task task : taskRepository.getAll()) {
            consoleOutputWriter.printl(task.toString());
        }
    }

    private void addEntry() {
        consoleOutputWriter.printl("Podaj nazwę zadania: ");
        String title = scanner.nextLine();
        consoleOutputWriter.printl("Podaj opis zadania: ");
        String description = scanner.nextLine();
        consoleOutputWriter.printl("POdaj priorytet zadania: ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        Task task = new Task(title, description, priority);
        taskRepository.add(task);
    }

    private void close() {
        try {
            fileService.saveEntries(taskRepository.getAll());
            consoleOutputWriter.printl("Zapisano stan aplikacji");
        } catch (IOException e) {
            consoleOutputWriter.printl("Nie udało się zapisa zmian");
        }
        consoleOutputWriter.printl("Bye Bye");
    }
    private int chooseOption() {
        int option;
        try {
            option = scanner.nextInt();
        }catch (InputMismatchException e) {
            option = UNDEFINED;
        }finally {
            scanner.nextLine();
        }
        if (option > UNDEFINED && option <= CLOSE_HERMES) {
            return option;
        } else {
            return UNDEFINED;
        }
    }

    private void printMenu() {
        consoleOutputWriter.printl("Wybierz opcje");
        consoleOutputWriter.printl("0-Dodaj zadanie");
        consoleOutputWriter.printl("1-Pokaż zadania");
        consoleOutputWriter.printl("2-Zamknij Hermesa");
    }
}
