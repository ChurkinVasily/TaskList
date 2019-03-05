package ru.churkin.repository;

import ru.churkin.api.IProjectRepository;
import ru.churkin.entity.Project;

import javax.persistence.EntityManager;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    private EntityManager entityManager;

    public ProjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createProject(Project project) {
        entityManager.merge(project);
    }

    @Override
    public Project findProjectByName(String name) {
        return null;
    }

    @Override
    public Project findProjectById(String id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public void updateProject(Project project) {
        entityManager.refresh(project);
    }

    @Override
    public void deleteProject(String id) {
        entityManager.remove(id);
    }

    @Override
    public Map<String, Project> getProjectMap() {

        Map<String, Project> projects = entityManager.createQuery();
        return null;
    }
}
