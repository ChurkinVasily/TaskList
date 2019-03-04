package ru.churkin.service;

import ru.churkin.api.ProjectService;
import ru.churkin.entity.Project;
import ru.churkin.repository.ProjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProjectServiceHib implements ProjectService {

    private EntityManagerFactory entityManagerFactory;

    public ProjectServiceHib(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean createProject(String projectName) {
        Project project = new Project(projectName);
        return createProject(project);
    }

    @Override
    public boolean createProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectRepository projectRepository = new ProjectRepository(entityManager);
        String id = UUID.randomUUID().toString();
        project.setId(id);
        String projectName = project.getName();
        boolean isConsist = false;
        for (Map.Entry<String, Project> map : projectRepository.getProjectMap().entrySet()) {
            if (projectName.equals(map.getValue().getName())) {
                isConsist = true;
            }
        }
        if (isConsist || project.getName().equals("")) {
            return false;
        } else {
            entityManager.getTransaction().begin();
            projectRepository.createProject(project);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public Project findProjectByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectRepository projectRepository = new ProjectRepository(entityManager);
        entityManager.getTransaction().begin();
        boolean isConsist = false;
        for (Map.Entry<String, Project> entry : projectRepository.getProjectMap().entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                isConsist = true;
            }
        }
        if (isConsist) {
            Project project = projectRepository.findProjectByName(name);
            entityManager.close();
            return project;
        } else return null;
    }

    @Override
    public boolean updateProject(String name, Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectRepository projectRepository = new ProjectRepository(entityManager);
        entityManager.getTransaction().begin();
        boolean isConsist = false;
        for (Map.Entry<String, Project> map : projectRepository.getProjectMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                String id = map.getValue().getId();
                project.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            projectRepository.updateProject(project);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public boolean deleteProject(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectRepository projectRepository = new ProjectRepository(entityManager);
        entityManager.getTransaction().begin();
        boolean isConsist = false;
        String idForRemove = "";
        for (Map.Entry<String, Project> entry : projectRepository.getProjectMap().entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                idForRemove = entry.getValue().getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            projectRepository.deleteProject(idForRemove);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public List<Project> getProjectAll() {
        List<Project> listProject = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectRepository projectRepository = new ProjectRepository(entityManager);
        entityManager.getTransaction().begin();
        Map<String, Project> mapProject = projectRepository.getProjectMap();
        if (!mapProject.isEmpty()) {
            for (Map.Entry<String, Project> entry : mapProject.entrySet()) {
                Project project = entry.getValue();
                listProject.add(project);
            }
        }
        entityManager.close();
        return listProject;
    }
}
