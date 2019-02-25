package ru.churkin.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.TaskService;
import ru.churkin.entity.Task;
import ru.churkin.repository.TaskMapper;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskServiceImpl implements TaskService {

    private SqlSessionFactory sqlSessionFactory;

    public TaskServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public boolean createTask(Task task) {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        String id = UUID.randomUUID().toString();
        task.setId(id);
        String taskName = task.getName();
        boolean isConsist = false;
        for (Map.Entry<String, Task> entry : mapper.getTaskMap().entrySet()) {
            if (taskName.equals(entry.getValue().getName())) {
                isConsist = true;
            }
        }
        if (isConsist || task.getName().equals("")) {
            return false;
        } else {
            mapper.createTask(task);
            session.commit();
            session.close();
            return true;
        }
    }

    @Override
    public Task findTaskByName(String name) {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        try {
            boolean isConsist = false;
            for (Map.Entry<String, Task> map : mapper.getTaskMap().entrySet()) {
                Task nTask = map.getValue();
                if (name.equals(nTask.getName())) {
                    isConsist = true;
                }
            }
            if (isConsist) {
                return mapper.findTaskByName(name);
            } else return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List<Task> findTaskByUserId(String userId)  {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        try {
            boolean isConsist = false;
            for (Map.Entry<String, Task> entry : mapper.getTaskMap().entrySet()) {
                if (userId.equals(entry.getValue().getUserId())) {
                    isConsist = true;
                }
            }
            if (isConsist) return mapper.findTasksByUserId(userId);
            else return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean updateTask(String name, Task task)  {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        boolean isConsist = false;
        String id = "";
        for (Map.Entry<String, Task> map : mapper.getTaskMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                id = map.getValue().getId();
                task.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            mapper.updateTask(task);
            session.commit();
            session.close();
            return true;
        }
    }

    @Override
    public boolean deleteTask(String name)  {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        boolean isConsist = false;
        String idForRemove = "";
        for (Map.Entry<String, Task> entry : mapper.getTaskMap().entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                idForRemove = entry.getValue().getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            mapper.deleteTask(idForRemove);
            session.commit();
            session.close();
            return true;
        }
    }

    @Override
    public Map<String, Task> getAllTasks()  {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        try {
            if (!mapper.getTaskMap().isEmpty()) {
                return mapper.getTaskMap();
            } else return null;
        }
        finally {
           session.close();
        }
    }
}
