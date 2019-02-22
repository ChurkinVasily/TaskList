package ru.churkin.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.ITaskRepository;
import ru.churkin.api.TaskService;
import ru.churkin.repository.ConnectionDB;
import ru.churkin.repository.TaskMapper;
import ru.churkin.entity.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TaskServiceImpl implements TaskService {

    private SqlSessionFactory sqlSessionFactory;

    public TaskServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

//    SqlSession sqlSession = sqlSessionFactory.openSession();
//    TaskMapper taskRepository = sqlSession.getMapper(TaskMapper.class);

    @Override
    public boolean createTask(Task task) {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
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

    @Override
    public List<Task> findTaskByUserId(String userId)  {
        SqlSession session = sqlSessionFactory.openSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        boolean isConsist = false;
        for (Map.Entry<String, Task> entry : mapper.getTaskMap().entrySet()) {
            if (userId.equals(entry.getValue().getUserId())) {
                isConsist = true;
            }
        }
        if (isConsist) return mapper.findTasksByUserId(userId);
        else return null;
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
        if (!mapper.getTaskMap().isEmpty()) {
            return mapper.getTaskMap();
        } else return null;
    }
}
