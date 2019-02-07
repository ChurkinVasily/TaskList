package ru.chirkin.repository;

import ru.chirkin.entity.Project;
import ru.chirkin.entity.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectRepository {

    Map<String, Project> projectMap = new HashMap<>();

    public void createProject() {
        Project project = new Project();
        String id = UUID.randomUUID().toString();
        project.setName();
        project.setDescription();
        project.setListTask(null);
        project.setTimeStart();
        project.setTimeFin();
        projectMap.put(id,project);
    }

    public Project findProjectByName(String name) {
        for (Map.Entry<String, Project> entry : projectMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                return entry.getValue();
            }
            else return null;
        }
    }

    public void updateProject(String id) {
        Project project = projectMap.get(id);
        project.setName();
        project.setDescription();
        project.setListTask(null);
        project.setTimeStart();
        project.setTimeFin();
        projectMap.put(id,project);
    }

    public void deleteProject(String id) {
        projectMap.remove(id);
    }

}
