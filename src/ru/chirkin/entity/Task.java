package ru.chirkin.entity;

import java.util.Date;

public class Task {

    private String name;
    private String description;
    private String timeStart;
    private String timeFin;

    public Task(String name) {
       this.name = name;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeFin(String timeFin) {
        this.timeFin = timeFin;
    }

    public String getTimeFin() {
        return timeFin;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeStart() {
        return timeStart;
    }
}
