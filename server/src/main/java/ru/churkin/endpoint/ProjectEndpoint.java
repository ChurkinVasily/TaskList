package ru.churkin.endpoint;

import ru.churkin.api.IProjectEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.dto2.ProjectDTO;
import ru.churkin.entity.Project;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

import static ru.churkin.dto2.ProjectDTO.toDTO;

@WebService
public class ProjectEndpoint implements IProjectEndpoint {

    private ServiceLocator serviceLocator;

    public ProjectEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

//    @Override
//    public boolean createProject(@WebParam(name = "project") ProjectDTO projectDTO){
//        return serviceLocator.getProjectService().createProject(ProjectDTO(project));
////        return serviceLocator.getProjectService().createProject(project);
//    }

    @Override
    public boolean createProject(@WebParam(name = "projectName") String projectName){
        return serviceLocator.getProjectService().createProject(projectName);
    }

    @Override
    public ProjectDTO findProjectByName(@WebParam(name = "name") String name) throws Exception {
        ProjectDTO projectDTO = ProjectDTO.toDto(serviceLocator.getProjectService().findProjectByName(name));
        return projectDTO;
    }

    @Override
    public boolean updateProject(@WebParam(name = "name") String name,
                                 @WebParam(name = "newName") String newName,
                                 @WebParam(name = "newName") String description,
                                 @WebParam(name = "timeStart") String timeStart,
                                 @WebParam(name = "tineFinish") String timeFinish) throws Exception {
        Project project = serviceLocator.getProjectService().findProjectByName(name);
        project.setName(newName);
        project.setDescription(description);
        project.setTimeStart(timeStart);
        project.setTimeFinish(timeFinish);
        return serviceLocator.getProjectService().updateProject(name, project);
    }

    //    @Override
//    public boolean updateProject(@WebParam(name = "name") String name,
////                                 @WebParam(name = "project") Project project) throws Exception {
//        //DTO
////        return serviceLocator.getProjectService().updateProject(id, project);
//    }

    @Override
    public boolean deleteProject(@WebParam(name = "id")String id) throws Exception {
        return serviceLocator.getProjectService().deleteProject(id);
    }

    @Override
    public List<ProjectDTO> getAllProjects() throws Exception {
        List<Project> list = serviceLocator.getProjectService().getProjectAll();
        return toDTO(list);
    }
}