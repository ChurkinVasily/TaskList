package ru.churkin.service;

import ru.churkin.api.IProjectRepository;
import ru.churkin.api.ProjectService;
import ru.churkin.entity.Project;

import java.sql.SQLException;
import java.util.Map;

public class ProjectServiceImpl implements ProjectService {

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean createProject(Project project) throws SQLException {
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
    public Project findProjectByName(String name) throws SQLException {
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
    public boolean updateProject(String name, Project project) throws SQLException {
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
            projectRepository.updateProject(project);
            return true;
        }
    }

    @Override
    public boolean deleteProject(String name) throws SQLException {
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

    @Override
    public Map<String, Project> getProjectAll() throws SQLException {
        if (!projectRepository.getProjectMap().isEmpty()) {
            return projectRepository.getProjectMap();
        }
        return null;
    }
}
