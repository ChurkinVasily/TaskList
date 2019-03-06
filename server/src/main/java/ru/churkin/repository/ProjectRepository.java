package ru.churkin.repository;

import ru.churkin.api.IProjectRepository;
import ru.churkin.entity.Project;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    private EntityManager entityManager;

    public ProjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createProject(Project project) {
        entityManager.persist(project);
    }

    @Override
    public Project findProjectByName(String name) {
        return entityManager.createQuery("select e from Project e where e.name = :projectName", Project.class)
                .setParameter("projectName", name)
                .getSingleResult();
    }

    @Override
    public Project findProjectById(String id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public void updateProject(Project project) {
        entityManager.merge(project);
    }

    @Override
    public void deleteProject(Project project) {
        entityManager.remove(project);
    }

    @Override
    public List<Project> getProjectList() {
    return entityManager.createQuery("select e from Project e", Project.class)
                .getResultList();
    }
}
