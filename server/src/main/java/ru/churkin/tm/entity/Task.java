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
