package ru.churkin.repository;

import org.apache.ibatis.annotations.*;
import ru.churkin.api.ITaskRepository;
import ru.churkin.entity.Task;

import java.util.List;
import java.util.Map;

public interface TaskMapper extends ITaskRepository{

    @Insert("insert into tasks (id, name, description, timeStart, timeFinish, projectID, userID) values (#{id}, #{name}, #{description}, #{timeStart}, #{timeFinish}, #{projectId}, #{userId})")
    void createTask(Task task);

    @Select("select * from tasks where name = #{name}")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "timeStart", column = "timeStart"),
            @Result(property = "timeFinish", column = "timeFinish"),
            @Result(property = "projectId", column = "projectID"),
            @Result(property = "userId", column = "userID")})
    Task findTaskByName(String name);

    @Select("select * from tasks where userID = #{userID}")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "timeStart", column = "timeStart"),
            @Result(property = "timeFinish", column = "timeFinish"),
            @Result(property = "projectId", column = "projectID"),
            @Result(property = "userId", column = "userID")})
    List<Task> findTasksByUserId(String userId);

    @Update("update tasks set name = #{name}, description = #{description}, timeStart = #{timeStart}, timeFinish = #{timeFinish}, projectID = #{projectId}, userID = #{userId} where id = #{id}")
    void updateTask(Task task);

    @Delete("delete from tasks where id = #{id}")
    void deleteTask(String id);

    @Select("select * from tasks")
    @MapKey("id")
    Map<String, Task> getTaskMap();
}
