package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;

import java.io.IOException;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "pd";
    }

    @Override
    public String description() {
        return "Project Deleting";
    }

    @Override
    public void execute() throws IOException, Exception_Exception {
        System.out.println("введите имя проекта (project) для удаления");
        String id = serviceLocator.getTerminalService().nextLine();
        boolean isDelete = serviceLocator.getProjectEndpoint().deleteProject(id);
        if (isDelete) System.out.println("успешно удалено");
        else System.out.println("ошибка удаления. пустое или не существующее имя");
    }
}
