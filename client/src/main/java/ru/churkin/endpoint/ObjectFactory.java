
package ru.churkin.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.churkin.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://endpoint.churkin.ru/", "Exception");
    private final static QName _CreateProject_QNAME = new QName("http://endpoint.churkin.ru/", "createProject");
    private final static QName _CreateProjectResponse_QNAME = new QName("http://endpoint.churkin.ru/", "createProjectResponse");
    private final static QName _DeleteProject_QNAME = new QName("http://endpoint.churkin.ru/", "deleteProject");
    private final static QName _DeleteProjectResponse_QNAME = new QName("http://endpoint.churkin.ru/", "deleteProjectResponse");
    private final static QName _FindProjectByName_QNAME = new QName("http://endpoint.churkin.ru/", "findProjectByName");
    private final static QName _FindProjectByNameResponse_QNAME = new QName("http://endpoint.churkin.ru/", "findProjectByNameResponse");
    private final static QName _GetAllProjects_QNAME = new QName("http://endpoint.churkin.ru/", "getAllProjects");
    private final static QName _GetAllProjectsResponse_QNAME = new QName("http://endpoint.churkin.ru/", "getAllProjectsResponse");
    private final static QName _UpdateProject_QNAME = new QName("http://endpoint.churkin.ru/", "updateProject");
    private final static QName _UpdateProjectResponse_QNAME = new QName("http://endpoint.churkin.ru/", "updateProjectResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.churkin.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link CreateProject }
     * 
     */
    public CreateProject createCreateProject() {
        return new CreateProject();
    }

    /**
     * Create an instance of {@link CreateProjectResponse }
     * 
     */
    public CreateProjectResponse createCreateProjectResponse() {
        return new CreateProjectResponse();
    }

    /**
     * Create an instance of {@link DeleteProject }
     * 
     */
    public DeleteProject createDeleteProject() {
        return new DeleteProject();
    }

    /**
     * Create an instance of {@link DeleteProjectResponse }
     * 
     */
    public DeleteProjectResponse createDeleteProjectResponse() {
        return new DeleteProjectResponse();
    }

    /**
     * Create an instance of {@link FindProjectByName }
     * 
     */
    public FindProjectByName createFindProjectByName() {
        return new FindProjectByName();
    }

    /**
     * Create an instance of {@link FindProjectByNameResponse }
     * 
     */
    public FindProjectByNameResponse createFindProjectByNameResponse() {
        return new FindProjectByNameResponse();
    }

    /**
     * Create an instance of {@link GetAllProjects }
     * 
     */
    public GetAllProjects createGetAllProjects() {
        return new GetAllProjects();
    }

    /**
     * Create an instance of {@link GetAllProjectsResponse }
     * 
     */
    public GetAllProjectsResponse createGetAllProjectsResponse() {
        return new GetAllProjectsResponse();
    }

    /**
     * Create an instance of {@link UpdateProject }
     * 
     */
    public UpdateProject createUpdateProject() {
        return new UpdateProject();
    }

    /**
     * Create an instance of {@link UpdateProjectResponse }
     * 
     */
    public UpdateProjectResponse createUpdateProjectResponse() {
        return new UpdateProjectResponse();
    }

    /**
     * Create an instance of {@link Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "createProject")
    public JAXBElement<CreateProject> createCreateProject(CreateProject value) {
        return new JAXBElement<CreateProject>(_CreateProject_QNAME, CreateProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "createProjectResponse")
    public JAXBElement<CreateProjectResponse> createCreateProjectResponse(CreateProjectResponse value) {
        return new JAXBElement<CreateProjectResponse>(_CreateProjectResponse_QNAME, CreateProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "deleteProject")
    public JAXBElement<DeleteProject> createDeleteProject(DeleteProject value) {
        return new JAXBElement<DeleteProject>(_DeleteProject_QNAME, DeleteProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "deleteProjectResponse")
    public JAXBElement<DeleteProjectResponse> createDeleteProjectResponse(DeleteProjectResponse value) {
        return new JAXBElement<DeleteProjectResponse>(_DeleteProjectResponse_QNAME, DeleteProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProjectByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "findProjectByName")
    public JAXBElement<FindProjectByName> createFindProjectByName(FindProjectByName value) {
        return new JAXBElement<FindProjectByName>(_FindProjectByName_QNAME, FindProjectByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProjectByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "findProjectByNameResponse")
    public JAXBElement<FindProjectByNameResponse> createFindProjectByNameResponse(FindProjectByNameResponse value) {
        return new JAXBElement<FindProjectByNameResponse>(_FindProjectByNameResponse_QNAME, FindProjectByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "getAllProjects")
    public JAXBElement<GetAllProjects> createGetAllProjects(GetAllProjects value) {
        return new JAXBElement<GetAllProjects>(_GetAllProjects_QNAME, GetAllProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "getAllProjectsResponse")
    public JAXBElement<GetAllProjectsResponse> createGetAllProjectsResponse(GetAllProjectsResponse value) {
        return new JAXBElement<GetAllProjectsResponse>(_GetAllProjectsResponse_QNAME, GetAllProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "updateProject")
    public JAXBElement<UpdateProject> createUpdateProject(UpdateProject value) {
        return new JAXBElement<UpdateProject>(_UpdateProject_QNAME, UpdateProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.churkin.ru/", name = "updateProjectResponse")
    public JAXBElement<UpdateProjectResponse> createUpdateProjectResponse(UpdateProjectResponse value) {
        return new JAXBElement<UpdateProjectResponse>(_UpdateProjectResponse_QNAME, UpdateProjectResponse.class, null, value);
    }

}
