package ru.churkin.repository;

import ru.churkin.entity.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectRepository {

    private Map<String, Project> projectMap = new HashMap<>();

    public ProjectRepository() {
    }

    public void createProject(Project project) {
        String id = UUID.randomUUID().toString();
        project.setId(id);
        projectMap.put(id, project);
    }

    public Project findProjectByName(String name) {
        Project project = new Project();
        for (Map.Entry<String, Project> entry : projectMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                project = entry.getValue();
            }
        }
        return project;
    }

    public void updateProject(String id, Project project) {
        projectMap.put(id, project);
    }

    public void deleteProject(String id) {
        projectMap.remove(id);
    }

    public Map<String, Project> getProjectMap() {
        return projectMap;
    }

    public void setProjectMap(Map<String, Project> projectMap) {
        this.projectMap = projectMap;
    }


}
