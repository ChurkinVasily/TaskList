package ru.churkin.api;

import ru.churkin.entity.Project;

import java.util.Map;

public interface ProjectService {

    boolean createProject(Project project);

    Project findProjectByName(String name);

    boolean updateProject(String id, Project project);

    boolean deleteProject(String id);

    Map<String, Project> getAllProjects();

}
