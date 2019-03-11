package ru.churkin.tm.api;

import ru.churkin.tm.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectService {

    boolean createProject(Project project) throws SQLException;

    boolean createProject(String projectName);

    Project findProjectByName(String name) throws SQLException;

    Project findProjectById(String id) throws SQLException;

    boolean updateProject(String name, Project project) throws SQLException;

    boolean deleteProject(String name) throws SQLException;

    List<Project> getProjectAll() throws SQLException;

}
