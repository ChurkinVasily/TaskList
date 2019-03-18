package ru.churkin.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.churkin.tm.api.ProjectService;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.repository.ProjectRepository;
import ru.churkin.tm.repository.ProjectRepositoryDS;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.UUID;

//@ApplicationScoped
@Transactional
public class ProjectServiceJPA implements ProjectService {

//    @Inject
//    private EntityManagerFactory entityManagerFactory;

    @Inject
    private ProjectRepositoryDS projectRepository;

    public boolean createProject(String projectName) {
        Project project = new Project(projectName);
        return createProject(project);
    }

    @Override
    public boolean createProject(Project project) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        projectRepository.setEntityManager(entityManager);
        String id = UUID.randomUUID().toString();
        project.setId(id);
        String projectName = project.getName();
        boolean isConsist = false;
        for (Project cProject : projectRepository.findAll()) {
            if (projectName.equals(cProject.getName())) {
                isConsist = true;
            }
        }
        if (isConsist || project.getName().isEmpty()) {
            return false;
        }
//        entityManager.getTransaction().begin();
        projectRepository.persist(project);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return true;
    }

    @Override
    public Project findProjectByName(String name) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        projectRepository.setEntityManager(entityManager);
        boolean isConsist = false;
        for (Project cProject : projectRepository.findAll()) {
            if (name.equals(cProject.getName())) {
                isConsist = true;
            }
        }
        if (!isConsist) {
            return null;
        }
//        entityManager.getTransaction().begin();
        Project project = projectRepository.findProjectByName(name);
//        entityManager.close();
        return project;
    }

    @Override
    public Project findProjectById(String id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        projectRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        Project project = projectRepository.findBy(id);
//        entityManager.close();
        return project;
    }

    @Override
    public boolean updateProject(String name, Project project) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        projectRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        boolean isConsist = false;
        for (Project cProject : projectRepository.findAll()) {
            if (name.equals(cProject.getName())) {
                String id = cProject.getId();
                project.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.isEmpty()) {
            return false;
        }
        projectRepository.merge(project);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return true;
    }


    @Override
    public boolean deleteProject(String name) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        projectRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        boolean isConsist = false;
        String idForRemove = "";
        for (Project cProject : projectRepository.findAll()) {
            if (name.equals(cProject.getName())) {
                idForRemove = cProject.getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        }
            projectRepository.remove(projectRepository.findBy(idForRemove));
//            entityManager.getTransaction().commit();
//            entityManager.close();
            return true;
    }

    @Override
    public List<Project> getProjectAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        projectRepository.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
        List<Project> listProject = projectRepository.findAll();
        if (listProject.isEmpty()) return null;
//        entityManager.close();
        return listProject;
    }
}
