package ru.churkin.repository;

import ru.churkin.entity.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectRepository {

    private Map<String, Project> projectMap = new HashMap<>();

    {
        projectMap.put("p1", new Project("p1", "proj1", "project 1", "111", "1111"));
        projectMap.put("p2", new Project("p2", "proj2", "project 2", "222", "2222"));
        projectMap.put("p3", new Project("p3", "proj3", "project 3", "333", "3333"));
    }

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
