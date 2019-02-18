package ru.churkin.api;

import ru.churkin.entity.Project;

import java.util.Map;

public interface IProjectRepository {

    void createProject(Project project);

    Project findProjectByName(String name);

    void updateProject(Project project);

    void deleteProject(String id);

    Map<String, Project> getProjectMap();

}
