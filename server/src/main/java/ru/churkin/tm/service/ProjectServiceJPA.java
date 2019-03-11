package ru.churkin.tm.service;

import ru.churkin.tm.api.ProjectService;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.repository.ConnectionInitializer;
import ru.churkin.tm.repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProjectServiceJPA implements ProjectService {

//   @Inject
//   private ConnectionInitializer connectionInitializer;

    @Inject
    private EntityManagerFactory entityManagerFactory;

    @Inject
    private ProjectRepository projectRepository;

//    public ProjectServiceJPA(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }

// ///////   private EntityManagerFactory entityManagerFactory = connectionInitializer.getEntityManagerFactory();

    public boolean createProject(String projectName) {
        Project project = new Project(projectName);
        return createProject(project);
    }

    @Override
    public boolean createProject(Project project) {
//        final EntityManager entityManager = entityManagerFactory.createEntityManager();
//        final ProjectRepository projectRepository = new ProjectRepository(entityManager);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        projectRepository.setEntityManager(entityManager);
        String id = UUID.randomUUID().toString();
        project.setId(id);
        String projectName = project.getName();
        boolean isConsist = false;
        for (Project cProject : projectRepository.getProjectList()) {
            if (projectName.equals(cProject.getName())) {
                isConsist = true;
            }
        }
        if (isConsist || project.getName().isEmpty()) {
            return false;
        }
        entityManager.getTransaction().begin();
        projectRepository.createProject(project);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public Project findProjectByName(String name) {
//        final EntityManager entityManager = entityManagerFactory.createEntityManager();
//        final ProjectRepository projectRepository = new ProjectRepository(entityManager);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        projectRepository.setEntityManager(entityManager);
        boolean isConsist = false;
        for (Project cProject : projectRepository.getProjectList()) {
            if (name.equals(cProject.getName())) {
                isConsist = true;
            }
        }
        if (!isConsist) {
            return null;
        }
        entityManager.getTransaction().begin();
        Project project = projectRepository.findProjectByName(name);
        entityManager.close();
        return project;
    }

    @Override
    public Project findProjectById(String id) {
//        final EntityManager entityManager = entityManagerFactory.createEntityManager();
//        final ProjectRepository projectRepository = new ProjectRepository(entityManager);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        projectRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        Project project = projectRepository.findProjectById(id);
        entityManager.close();
        return project;
    }

    @Override
    public boolean updateProject(String name, Project project) {
//        final EntityManager entityManager = entityManagerFactory.createEntityManager();
//        final ProjectRepository projectRepository = new ProjectRepository(entityManager);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        projectRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        boolean isConsist = false;
        for (Project cProject : projectRepository.getProjectList()) {
            if (name.equals(cProject.getName())) {
                String id = cProject.getId();
                project.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.isEmpty()) {
            return false;
        }
        projectRepository.updateProject(project);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }


    @Override
    public boolean deleteProject(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        ProjectRepository projectRepository = new ProjectRepository(entityManager);
        projectRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        boolean isConsist = false;
        String idForRemove = "";
        for (Project cProject : projectRepository.getProjectList()) {
            if (name.equals(cProject.getName())) {
                idForRemove = cProject.getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        }
            projectRepository.deleteProject(projectRepository.findProjectById(idForRemove));
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
    }

    @Override
    public List<Project> getProjectAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        ProjectRepository projectRepository = new ProjectRepository(entityManager);
        projectRepository.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        List<Project> listProject = projectRepository.getProjectList();
        if (listProject.isEmpty()) return null;
        entityManager.close();
        return listProject;
    }
}
