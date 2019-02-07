package ru.chirkin.entity;

import java.util.Date;
import java.util.List;

public class Project {

    private String name;
    private String description;
    private Date timeStart;
    private Date timeFin;
    private List<Task> listTask;

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

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(Date timeFin) {
        this.timeFin = timeFin;
    }

    public List<Task> getListTask() {
        return listTask;
    }

    public void setListTask(List<Task> listTask) {
        this.listTask = listTask;
    }
}
