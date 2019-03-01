package ru.churkin.repository;

import org.apache.ibatis.annotations.*;
import ru.churkin.api.IProjectRepository;
import ru.churkin.dto.Project;

import java.util.Map;

public interface ProjectMapper extends IProjectRepository {

    @Insert("insert into projects (id, name, description, timeStart, timeFinish) values (#{id}, #{name}, #{description}, #{timeStart}, #{timeFinish})")
    void createProject(Project project);

    @Select("select * from projects where name=#{name}")
    Project findProjectByName(String name);

    @Update("update projects set name = #{name}, description = #{description}, timeStart = #{timeStart}, timeFinish = #{timeFinish} where id = #{id}")
    void updateProject(Project project);

    @Delete("delete from projects where id = #{id}")
    void deleteProject(String id);

    @Select("select * from projects")
    @MapKey("id")
    Map<String, Project> getProjectMap();
}

