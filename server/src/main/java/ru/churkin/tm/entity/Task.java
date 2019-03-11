package ru.churkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    private String id;
    private String name;
    private String description;
    private String timeStart;
    private String timeFinish;

    @ManyToOne
    @JoinColumn(name = "projectID")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    public Task(String name, User user, Project project) {
        this.name = name;
        this.user = user;
        this.project = project;
    }

    public Task(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Task(String id, String name, String description, String timeStart, String timeFinish, Project project, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.project = project;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setTimeFinish(String timeFin) {
        this.timeFinish = timeFin;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeStart() {
        return timeStart;
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return user.getId();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeFinish='" + timeFinish + '\'' +
                ", project='" + project.getName() + '\'' +
                ", user='" + user.getName() + '\'' +
                '}';
    }
}
