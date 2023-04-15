package com.garox.hermesproject;

public class Task {
    private String titel;
    private String description;
    private int priority;

    public Task(String titel, String description, int priority) {
        this.titel = titel;
        this.description = description;
        this.priority = priority;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
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
        return titel + " pryjotytet = " + priority;
    }
}
