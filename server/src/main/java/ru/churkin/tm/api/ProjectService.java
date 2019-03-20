package ru.churkin.tm.api;

import ru.churkin.tm.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectService {

    boolean createProject(Project project);

    boolean createProject(String projectName);

    Project findProjectByName(String name);

    Project findProjectById(String id);

    boolean updateProject(String name, Project project);

    boolean deleteProject(String name);

    List<Project> getProjectAll();

//    void pers(Project project); //-- тестовый метод. создавался для тестирования транзакций

}
