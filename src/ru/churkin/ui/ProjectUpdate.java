package ru.churkin.ui;

import ru.churkin.entity.Project;

import java.io.IOException;

public class ProjectUpdate extends CommandAbstract {

    @Override
    public String name() {
        return "pu";
    }

    @Override
    public String description() {
        return "Project Updating";
    }

    @Override
    public void execute() throws IOException {
        String userId = serviceLocator.getUserService().currentUser.getId();
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
