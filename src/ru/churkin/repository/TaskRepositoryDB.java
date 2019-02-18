package ru.churkin.repository;

import ru.churkin.api.ITaskRepository;
import ru.churkin.entity.Task;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static ru.churkin.Bootstrap.*;

public class TaskRepositoryDB implements ITaskRepository {

    public static final String CREATE_TASK = "insert into tasks (id, name, description, timeStart, timeFinish, projectID, userID) values ('?', '?', '?', '?', '?', '?', '?');";
    public static final String FIND_TASK_BY_NAME = "select * from tasks where name = '?';";
    public static final String FIND_TASK_BY_USER_ID = "select * from tasks where userID = '?';";
    public static final String UPDATE_TASK = "update tasks set name = '?', description = '?', timeStart = '?', timeFinish = '?', projectID = '?', userID = '?' where id = '?';";
    public static final String DELETE_TASK = "delete from tasks where id = '?';";
    public static final String GET_TASKS = "select * from tasks;";

    @Override
    public void createTask(Task task) {
        String id = UUID.randomUUID().toString();
        task.setId(id);
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(CREATE_TASK);
            ps.setString(1, id);
            ps.setString(2, task.getName());
            ps.setString(3, task.getDescription());
            ps.setString(4, task.getTimeStart());
            ps.setString(5, task.getTimeFinish());
            ps.setString(6, task.getProjectId());
            ps.setString(7, task.getUserId());
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("mistake when create task");
            e.printStackTrace();
        }

    }

    @Override
    public Task findTaskByName(String name) {
        Task task = null;

        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(FIND_TASK_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            task.setId(rs.getString("id"));
            task.setName(rs.getString("name"));
            task.setDescription(rs.getString("description"));
            task.setTimeStart(rs.getString("timeStart"));
            task.setTimeFinish(rs.getString("timeFinish"));
            task.setProjectId(rs.getString("projectID"));
            task.setUserId(rs.getString("userID"));

            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("mistake when find task by name");
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public List<Task> findTasksByUserId(String userId) {
        List<Task> taskList = null;

        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(FIND_TASK_BY_USER_ID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                taskList.add(new Task(rs.getString("id"),
                                    rs.getString("name"),
                                    rs.getString("description"),
                                    rs.getString("timeStart"),
                                    rs.getString("timeFinish"),
                                    rs.getString("projectID"),
                                    rs.getString("userID"))
                );
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @Override
    public void updateTask(Task task) {

        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(UPDATE_TASK);
            ps.setString(1, task.getName());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getTimeStart());
            ps.setString(4, task.getTimeFinish());
            ps.setString(5, task.getProjectId());
            ps.setString(6, task.getUserId());
            ps.setString(7, task.getId());
            ps.executeUpdate();

            ps.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(String id) {

        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(DELETE_TASK);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<String, Task> getTaskMap() {
        Map<String, Task> taskMap = null;

        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(GET_TASKS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                taskMap.put(rs.getString("id"),
                        new Task(rs.getString("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getString("timeStart"),
                                rs.getString("timeFinish"),
                                rs.getString("projectID"),
                                rs.getString("userID")));
            }
            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskMap;
    }
}
