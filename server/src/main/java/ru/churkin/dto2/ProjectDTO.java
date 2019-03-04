package ru.churkin.dto2;

import ru.churkin.entity.Project;

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

    public ProjectDTO() {
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

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
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
