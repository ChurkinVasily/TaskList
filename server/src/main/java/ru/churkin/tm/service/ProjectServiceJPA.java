package ru.churkin.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.churkin.tm.api.ProjectService;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.repository.ProjectRepositoryDS;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Transactional
public class ProjectServiceJPA implements ProjectService {

    @Inject
    private ProjectRepositoryDS projectRepository;

//    public void pers(Project project) {
//        projectRepository.persist(project);
//    }  /// ------ тестовый метод. создавался для тестирования транзакций

    public boolean createProject(String projectName) {
        Project project = new Project(projectName);
        return createProject(project);
    }

    @Override
    public boolean createProject(Project project) {
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
        projectRepository.persist(project);
        return true;
    }

    @Override
    public Project findProjectByName(String name) {
        boolean isConsist = false;
        for (Project cProject : projectRepository.findAll()) {
            if (name.equals(cProject.getName())) {
                isConsist = true;
            }
        }
        if (!isConsist) {
            return null;
        }
        Project project = projectRepository.findProjectByName(name);
        return project;
    }

    @Override
    public Project findProjectById(String id) {
        Project project = projectRepository.findBy(id);
        return project;
    }

    @Override
    public boolean updateProject(String name, Project project) {
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
        return true;
    }

    @Override
    public boolean deleteProject(String name) {
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
        return true;
    }

    @Override
    public List<Project> getProjectAll() {
        List<Project> listProject = projectRepository.findAll();
        if (listProject.isEmpty()) return null;
        return listProject;
    }
}
