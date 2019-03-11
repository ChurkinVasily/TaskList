package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;

import java.io.IOException;

public class TaskDeleteCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "td";
    }

    @Override
    public String description() {
        return "Task Deleting";
    }

    @Override
    public void execute() throws IOException, Exception_Exception {
        System.out.println("введите имя задачи (task) для удаления");
        String name = serviceLocator.getTerminalService().nextLine();
        boolean isDelete = serviceLocator.getTaskEndpoint().deleteTask(name);
        if (isDelete) System.out.println("успешно удалено");
        else System.out.println("ошибка удаления. введено пустое или не существующее имя");
    }
}
