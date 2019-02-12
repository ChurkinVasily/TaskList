package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.entity.Task;
import ru.churkin.service.ServiceLocator;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskCreate implements Command {

//    private ServiceLocator locator;
//    TaskServiceImpl taskServiceImpl = locator.getTaskService();

    private BufferedReader reader;
    private TaskServiceImpl taskServiceImpl;

    public TaskCreate(BufferedReader reader , TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskServiceImpl = taskServiceImpl;
    }

    public TaskCreate() {
    }

    @Override
    public String name() {
        return "tc";
    }

    @Override
    public String description() {
        return "Task Creation";
    }

    @Override
    public void execute() throws IOException {
        Task newTask = new Task();
        System.out.println("enter new task parameters: name, description, timeStart, timeFinish");
        newTask.setName(reader.readLine().trim());
        newTask.setTimeStart(reader.readLine().trim());
        newTask.setTimeFinish(reader.readLine().trim());
        newTask.setProjectId(reader.readLine().trim());
        boolean isCreate = taskServiceImpl.createTask(newTask);
        if (isCreate) {
            System.out.println("задача (Task) успешно создана");
        } else System.out.println("вы задали существующее или пустое имя");
    }
}
