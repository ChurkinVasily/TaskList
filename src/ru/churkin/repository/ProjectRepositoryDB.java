package ru.churkin.repository;

import ru.churkin.api.IProjectRepository;
import ru.churkin.entity.Project;

import java.sql.*;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static ru.churkin.Bootstrap.*;

public class ProjectRepositoryDB implements IProjectRepository {

    public static final String CREATE_PROJECT = "insert into projects (id, name, description, timeStart, timeFinish) values ('?', '?', '?', '?', '?');";
    public static final String FIND_PROJECT_BY_NAME = "select * from projects where name='?';";
    public static final String UPDATE_PROJECT = "update projects set name = '?', description = '?', timeStart = '?', timeFinish = '?' where id = '?';";
    public static final String DELETE_PROJECT = "delete from projects  where id = '?';";
    public static final String GET_ALL_PROJECTS = "select * from projects;";

    @Override
    public void createProject(Project project) {
        String id = UUID.randomUUID().toString();
        project.setId(id);
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(CREATE_PROJECT);
            ps.setString(1, project.getId());
            ps.setString(2, project.getName());
            ps.setString(3, project.getDescription());
            ps.setString(4, project.getTimeStart());
            ps.setString(5, project.getTimeFinish());
            ps.executeUpdate();

            ps.close();
            connection.close();
        }
        catch (SQLException e) {
            System.out.println("mistake when add");
            e.printStackTrace();
        }
    }

    @Override
    public Project findProjectByName(String name) {
        Project project = null;
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(FIND_PROJECT_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            project = new Project(rs.getString(1), // id
                    rs.getString(2), //name
                    rs.getString(3), //description
                    rs.getString(4), //timeStart
                    rs.getString(5)); //timeFinish

            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("mistake when search project");
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void updateProject(Project project) {
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(UPDATE_PROJECT);
            ps.setString(1, project.getName()); // name
            ps.setString(2, project.getDescription()); // description
            ps.setString(3, project.getTimeStart()); // timeStart
            ps.setString(4, project.getTimeFinish()); //timeFinish
            ps.setString(5, project.getId());  // id
            ps.executeUpdate();

            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("mistake when update");
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProject(String id) {
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(DELETE_PROJECT);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("mistake when delete project");
            e.printStackTrace();
        }

    }

    @Override
    public Map<String, Project> getProjectMap() {
        Map<String, Project> projectMap = new HashMap<>();
        try {
            Connection connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_PROJECTS);

            while (rs.next()){
                projectMap.put(rs.getString(1),  // project id
                        new Project(rs.getString(1), // project id
                                    rs.getString(2), // name
                                    rs.getString(3),  // description
                                    rs.getString(4), // timeStart
                                    rs.getString(5)  //timeFinish
                        ));
            }
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Mistake when get all projects");
            e.printStackTrace();
        }
        return projectMap;
    }
}
