package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.entity.Task;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TaskDelete implements Command {

    private BufferedReader reader;
    private TaskServiceImpl taskServiceImpl;

    public TaskDelete(BufferedReader reader, TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskServiceImpl = taskServiceImpl;
    }

    public TaskDelete() {
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
    public void execute() throws IOException {
        System.out.println("введите имя задачи (task) для удаления");
        String id = reader.readLine();
        boolean isDelete = taskServiceImpl.deleteTask(id);
        if (isDelete) System.out.println("успешно удалено");
        else System.out.println("ошибка удаления. пустой или не существующий id");
    }
}
