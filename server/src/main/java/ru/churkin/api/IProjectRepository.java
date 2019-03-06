package ru.churkin.api;

import ru.churkin.entity.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IProjectRepository {

    Project createProject(Project project) throws SQLException;

    Project findProjectByName(String name) throws SQLException;

    Project findProjectById(String id);

    void updateProject(Project project) throws SQLException;

    void deleteProject(Project project) throws SQLException;

    List<Project> getProjectList() throws SQLException;

}
