package ru.churkin.ui;

import ru.churkin.entity.Project;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "pu";
    }

    @Override
    public String description() {
        return "Project Updating";
    }

    @Override
    public void execute() throws IOException, SQLException {
        Project newProject = new Project();
        System.out.println("enter project-name for update Project");
        String name = serviceLocator.getTerminalService().nextLine();
        System.out.println("enter new parameters: name, description, time start, time finish");
        newProject.setName(serviceLocator.getTerminalService().nextLine());
        newProject.setDescription(serviceLocator.getTerminalService().nextLine());
        newProject.setTimeStart(serviceLocator.getTerminalService().nextLine());
        newProject.setTimeFinish(serviceLocator.getTerminalService().nextLine());
        boolean isUpdate = serviceLocator.getProjectService().updateProject(name, newProject);
        if (isUpdate) {
            System.out.println("project успешно обновлен");
        } else {
            System.out.println("не удалось обновить Project. пустое или несуществующее имя");
        }
    }
}
