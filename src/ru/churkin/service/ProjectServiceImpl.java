package ru.churkin.service;

import ru.churkin.api.ProjectService;
import ru.churkin.entity.Project;
import ru.churkin.repository.ProjectRepository;

import java.util.Map;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean createProject(Project project) {
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
            projectRepository.createProject(project);
            return true;
        }

    }

    @Override
    public Project findProjectByName(String name) {
        boolean isConsist = false;
        for (Map.Entry<String, Project> map : projectRepository.getProjectMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                isConsist = true;
            }
        }
        if (isConsist) {
            return projectRepository.findProjectByName(name);
        } else return null;
    }

    @Override
    public boolean updateProject(String name, Project project) {
        boolean isConsist = false;
        String id = "";
        for (Map.Entry<String, Project> map : projectRepository.getProjectMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                id = map.getValue().getId();
                project.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            projectRepository.updateProject(id, project);
            return true;
        }
    }

    @Override
    public boolean deleteProject(String name) {
        boolean isConsist = false;
        String idForRemove = "";
        for (Map.Entry<String, Project> map : projectRepository.getProjectMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                idForRemove = map.getValue().getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            projectRepository.deleteProject(idForRemove);
            return true;
        }
    }
}
