package ru.churkin.tm.endpoint;

import ru.churkin.tm.api.IProjectEndpoint;
import ru.churkin.tm.api.ProjectService;
import ru.churkin.tm.dto.ProjectDTO;
import ru.churkin.tm.entity.Project;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

import static ru.churkin.tm.dto.ProjectDTO.toDTO;

@WebService
public class ProjectEndpoint implements IProjectEndpoint {

    @Inject
    private ProjectService projectService;

    @Override
    public boolean createProject(@WebParam(name = "projectName") String projectName){
        return projectService.createProject(projectName);
    }

    @Override
    public ProjectDTO findProjectByName(@WebParam(name = "name") String name) throws Exception {
        ProjectDTO projectDTO = ProjectDTO.toDto(projectService.findProjectByName(name));
        return projectDTO;
    }

    @Override
    public ProjectDTO findProjectById(String projectId) throws Exception {
        ProjectDTO projectDTO = ProjectDTO.toDto(projectService.findProjectById(projectId));
        return projectDTO;
    }

    @Override
    public boolean updateProject(@WebParam(name = "name") String name,
                                 @WebParam(name = "newName") String newName,
                                 @WebParam(name = "description") String description,
                                 @WebParam(name = "timeStart") String timeStart,
                                 @WebParam(name = "timeFinish") String timeFinish) throws Exception {
        Project project = projectService.findProjectByName(name);
        project.setName(newName);
        project.setDescription(description);
        project.setTimeStart(timeStart);
        project.setTimeFinish(timeFinish);
        return projectService.updateProject(name, project);
    }

    @Override
    public boolean deleteProject(@WebParam(name = "id")String id) throws Exception {
        return projectService.deleteProject(id);
    }

    @Override
    public List<ProjectDTO> getAllProjects() throws Exception {
        List<Project> list = projectService.getProjectAll();
        return toDTO(list);
    }
}