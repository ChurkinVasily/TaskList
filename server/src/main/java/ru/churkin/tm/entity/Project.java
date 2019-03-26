package ru.churkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String name;
    @Nullable
    private String description;
    @Nullable
    private String timeStart;
//    @Nullable
//    private Date timeStart;
    @Nullable
    private String timeFinish;

    @Nullable
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public Project(String id, String name, String description, String timeStart, String timeFinish) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
    }

    public Project(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeFinish='" + timeFinish + '\'' +
                '}';
    }
}
