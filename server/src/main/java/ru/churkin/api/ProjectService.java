package ru.churkin.api;

import ru.churkin.entity.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ProjectService {

    boolean createProject(Project project) throws SQLException;

    Project findProjectByName(String name) throws SQLException;

    boolean updateProject(String id, Project project) throws SQLException;

    boolean deleteProject(String id) throws SQLException;

//    Map<String, Project> getProjectAll() throws SQLException;

    List<Project> getProjectAll() throws SQLException;

}
