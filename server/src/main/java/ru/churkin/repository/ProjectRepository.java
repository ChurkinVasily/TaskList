package ru.churkin.repository;

import ru.churkin.api.IProjectRepository;
import ru.churkin.entity.Project;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    private EntityManager entityManager;

    public ProjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createProject(Project project) {

    }

    @Override
    public Project findProjectByName(String name) {
        return null;
    }

    @Override
    public void updateProject(Project project) {

    }

    @Override
    public void deleteProject(String id) {

    }

    @Override
    public Map<String, Project> getProjectMap() {
        return null;
    }
}
