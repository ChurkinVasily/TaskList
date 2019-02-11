package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskReadByName implements Command {

    private BufferedReader reader;
    private TaskServiceImpl taskServiceImpl;

    public TaskReadByName(BufferedReader reader, TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskServiceImpl = taskServiceImpl;
    }

    @Override
    public String name() {
        return "tr";
    }

    @Override
    public String description() {
        return "find task by Name";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("для просмотра нужной задачи (task) введите ее имя");
        String name = reader.readLine();
        try {
            System.out.println(taskServiceImpl.findTaskByName(name).toString());
        }
        catch (NullPointerException e) {
            System.out.println("нет задачи с таким именем");
        }
    }
}
