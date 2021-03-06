package ru.churkin.ui;

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
    public void execute() throws IOException, SQLException {
        System.out.println("для просмотра нужного проекта (project) введите его имя");
        String name = serviceLocator.getTerminalService().nextLine();
        try {
            System.out.println(serviceLocator.getProjectService().findProjectByName(name).toString());
        } catch (NullPointerException e) {
            System.out.println("нет проекта с таким именем");
        }
    }
}
