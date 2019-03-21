package ru.churkin.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.churkin.tm.entity.Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {

    private String id;
    private String name;
    private String description;
    private String timeStart;
    private String timeFinish;

    public ProjectDTO(String id, String name, String description, String timeStart, String timeFinish) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
    }

    public ProjectDTO(final Project project) {
        if (project == null) return;
        id = project.getId();
        name = project.getName();
        description = project.getDescription();
        timeStart = project.getTimeStart();
        timeFinish = project.getTimeFinish();
    }

    public static ProjectDTO toDto(final Project project) {
        if (project == null) return null;
        return new ProjectDTO(project);
    }

    public static List<ProjectDTO> toDTO(final Collection<Project> projects) {
        if (projects == null || projects.isEmpty()) return Collections.emptyList();
        List<ProjectDTO> list = new ArrayList<>();
        for (Project project : projects) {
            list.add(new ProjectDTO(project));
        }
        return list;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeFinish='" + timeFinish + '\'' +
                '}';
    }

}
