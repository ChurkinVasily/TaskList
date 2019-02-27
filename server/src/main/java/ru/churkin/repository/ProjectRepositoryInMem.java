package ru.churkin.repository;

import ru.churkin.api.IProjectRepository;
import ru.churkin.entity.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectRepositoryInMem implements IProjectRepository {

    private Map<String, Project> projectMap = new HashMap<>();

    {
        projectMap.put("p1", new Project("p1", "proj1", "project 1", "111", "1111"));
        projectMap.put("p2", new Project("p2", "proj2", "project 2", "222", "2222"));
        projectMap.put("p3", new Project("p3", "proj3", "project 3", "333", "3333"));
    }

    public ProjectRepositoryInMem() {
    }

    @Override
    public void createProject(Project project) {
        String id = UUID.randomUUID().toString();
        project.setId(id);
        projectMap.put(id, project);
    }

    @Override
    public Project findProjectByName(String name) {
        Project project = new Project();
        for (Map.Entry<String, Project> entry : projectMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                project = entry.getValue();
            }
        }
        return project;
    }

    @Override
    public void updateProject(Project project) {
        projectMap.put(project.getId(), project);
    }

    @Override
    public void deleteProject(String id) {
        projectMap.remove(id);
    }

    @Override
    public Map<String, Project> getProjectMap() {
        return projectMap;
    }

    public void setProjectMap(Map<String, Project> projectMap) {
        this.projectMap = projectMap;
    }


}
