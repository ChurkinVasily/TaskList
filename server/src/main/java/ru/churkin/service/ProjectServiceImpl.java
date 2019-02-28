package ru.churkin.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.ProjectService;
import ru.churkin.entity.Project;
import ru.churkin.repository.ProjectMapper;

import java.util.Map;
import java.util.UUID;

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
        for (Map.Entry<String, Project> map : mapper.getProjectMap().entrySet()) {
            if (projectName.equals(map.getValue().getName())) {
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
    public Map<String, Project> getProjectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        try {
            if (!mapper.getProjectMap().isEmpty()) {
                return mapper.getProjectMap();
            }
            return null;
        } finally {
            session.close();
        }
    }
}
