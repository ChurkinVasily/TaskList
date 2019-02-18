package ru.churkin.ui;

import java.io.IOException;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public String name() {
        return "pd";
    }

    @Override
    public String description() {
        return "Project Deleting";
    }

    @Override
    public void execute() throws IOException {
        String userId = serviceLocator.getUserService().currentUser.getId();
        System.out.println("введите имя проекта (project) для удаления");
        String id = serviceLocator.getTerminalService().nextLine();
        boolean isDelete = serviceLocator.getProjectService().deleteProject(id);
        if (isDelete) System.out.println("успешно удалено");
        else System.out.println("ошибка удаления. пустое или не существующее имя");
    }
}
