package ru.churkin.tm.api;

import ru.churkin.tm.entity.Project;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public interface IProjectRepository {

    void setEntityManager(EntityManager entityManager);

    void createProject(Project project) throws SQLException;

    Project findProjectByName(String name) throws SQLException;

    Project findProjectById(String id);

    void updateProject(Project project) throws SQLException;

    void deleteProject(Project project) throws SQLException;

    List<Project> getProjectList() throws SQLException;

}
