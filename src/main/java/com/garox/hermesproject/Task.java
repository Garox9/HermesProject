package com.garox.hermesproject;

public class Task {
    private String title;
    private String description;
    private int priority;

    public Task(String titel, String description, int priority) {
        this.title = titel;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return title + " pryjotytet = " + priority;
    }
}
