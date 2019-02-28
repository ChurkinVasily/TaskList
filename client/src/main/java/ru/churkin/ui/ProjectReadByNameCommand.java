package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectReadByNameCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "pf";
    }

    @Override
    public String description() {
        return "Project Find by name";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("для просмотра нужного проекта (project) введите его имя");
        String name = serviceLocator.getTerminalService().nextLine();
        try {
            System.out.println(serviceLocator.getProjectEndpoint().findProjectByName(name).toString());
        } catch (NullPointerException | Exception_Exception e) {
            System.out.println("нет проекта с таким именем");
        }
    }
}
