package ru.churkin.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.ProjectService;
import ru.churkin.entity.Project;
import ru.churkin.repository.ProjectMapper;

import java.sql.SQLException;
import java.util.*;

public class ProjectServiceImpl implements ProjectService {

    private SqlSessionFactory sqlSessionFactory;

    public ProjectServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public boolean createProject(Project project) {
        SqlSession session = sqlSessionFactory.openSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        String id = UUID.randomUUID().toString();
        project.setId(id);
        String projectName = project.getName();
        boolean isConsist = false;
        for (Map.Entry<String, Project> entry : mapper.getProjectMap().entrySet()) {
            if (projectName.equals(entry.getValue().getName())) {
                isConsist = true;
            }
        }
        if (isConsist || project.getName().equals("")) {
            return false;
        } else {
            mapper.createProject(project);
            session.commit();
            session.close();
            return true;
        }
    }

    @Override
    public Project findProjectByName(String name) {
        SqlSession session = sqlSessionFactory.openSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        try {
            boolean isConsist = false;
            for (Map.Entry<String, Project> map : mapper.getProjectMap().entrySet()) {
                if (name.equals(map.getValue().getName())) {
                    isConsist = true;
                }
            }
            if (isConsist) {
                return mapper.findProjectByName(name);
            } else return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateProject(String name, Project project) {
        SqlSession session = sqlSessionFactory.openSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        boolean isConsist = false;
        String id = "";
        for (Map.Entry<String, Project> map : mapper.getProjectMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                id = map.getValue().getId();
                project.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            mapper.updateProject(project);
            session.commit();
            session.close();
            return true;
        }
    }

    @Override
    public boolean deleteProject(String name) {
        SqlSession session = sqlSessionFactory.openSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        boolean isConsist = false;
        String idForRemove = "";
        for (Map.Entry<String, Project> map : mapper.getProjectMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                idForRemove = map.getValue().getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            mapper.deleteProject(idForRemove);
            session.commit();
            session.close();
            return true;
        }
    }

    @Override
    public List<Project> getProjectAll() {
        List<Project> listProject = new ArrayList<>();
        SqlSession session = sqlSessionFactory.openSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        Map<String, Project> mapProject = mapper.getProjectMap();
        try {
          if (!mapProject.isEmpty()) {
              for(Map.Entry<String, Project> entry : mapProject.entrySet()) {
                  Project project = entry.getValue();
                  listProject.add(project);
              }
          }
        }
        finally {
            session.close();
        }
        return listProject;
    }
}
