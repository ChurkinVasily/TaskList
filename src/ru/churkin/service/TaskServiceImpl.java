package ru.churkin.service;

import ru.churkin.entity.Task;
import ru.churkin.repository.TaskRepository;

import java.util.Map;

public class TaskServiceImpl implements Service {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void createTask(Task task) {
        String taskName = task.getName();
        int count = 0;
        for (Map.Entry<String, Task> map : taskRepository.getTaskMap().entrySet()) {
            Task nTask = map.getValue();
            if (taskName.equals(nTask.getName())) {
                ++count;
            }
        }
        if (count > 0) {
            System.out.println("это имя уже существует");
        } else taskRepository.createTask(task);
    }

    @Override
    public Task findTaskByName(String name) {
        Task task = new Task();
        for (Map.Entry<String, Task> map : taskRepository.getTaskMap().entrySet()) {
            Task nTask = map.getValue();
            if (name.equals(nTask.getName())) {
                task = taskRepository.findTaskByName(name);
            }
        }
        return task;
    }

    @Override
    public void updateTask(String name, Task task) {
        int count = 0;
        for (Map.Entry<String, Task> map : taskRepository.getTaskMap().entrySet()) {
            Task nTask = map.getValue();
            if (name.equals(nTask.getName())) {
                String id = nTask.getId();
                taskRepository.updateTask(id, task);
                ++count;
            }
        }
        if (count > 0) System.out.println("task успешно обновлен");
        else {
            System.out.println("это имя не существует. невозможно обновить Task");
        }
    }

    @Override
    public void deleteTask(String id) {
        if (taskRepository.getTaskMap().containsKey(id)) {
            taskRepository.deleteTask(id);
            System.out.println("успешно удалено");
        } else System.out.println("нет такого id. невозможно завершить операцию удаления");
    }

//    private Map<String, Command> commandList;
//
//    public TaskServiceImpl(TaskRepository taskRepository, Map<String, Command> commandList) {
//        this.taskRepository = taskRepository;
//        this.commandList = commandList;
//    }
//
//    public void execute(String commandName) throws IOException {
//        Command command = commandList.get(commandName);
//        if (command == null) {
//            System.out.println("no such command");
//        }
//        command.execute();
//    }

}
