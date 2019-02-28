package ru.churkin.api;

import ru.churkin.entity.Project;

import java.sql.SQLException;
import java.util.Map;

public interface IProjectRepository {

    void createProject(Project project) throws SQLException;

    Project findProjectByName(String name) throws SQLException;

    void updateProject(Project project) throws SQLException;

    void deleteProject(String id) throws SQLException;

    Map<String, Project> getProjectMap() throws SQLException;

}
