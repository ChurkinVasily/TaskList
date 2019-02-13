package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.io.IOException;


public class TaskCreate extends CommandAbstract {

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
        newTask.setName(serviceLocator.getTerminalService().nextLine());
        newTask.setDescription(serviceLocator.getTerminalService().nextLine());
        newTask.setTimeStart(serviceLocator.getTerminalService().nextLine());
        newTask.setTimeFinish(serviceLocator.getTerminalService().nextLine());
        newTask.setProjectId(serviceLocator.getTerminalService().nextLine());
        boolean isCreate = serviceLocator.getTaskService().createTask(newTask);

        if (isCreate) {
            System.out.println("задача (Task) успешно создана");
        } else System.out.println("вы задали существующее или пустое имя");
    }
}
