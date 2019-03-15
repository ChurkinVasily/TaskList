package ru.churkin.tm.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.churkin.tm.entity.Project;

@Repository
public interface ProjectRepositoryDS extends FullEntityRepository<Project, String> {

//   ------ не нужен
//    void setEntityManager(EntityManager entityManager);

//   ---- унаследован от родителя. persist метод
//   void createProject(Project project) throws SQLException;


    @NotNull
    @Query(value = "select e from Project e where e.name = :projectName")
    Project findProjectByName(@QueryParam("projectName") String name);


//    ---- унаследован от родителя. find метод
//    Project findProjectById(String id);

//    ---- унаследован от родителя. merge метод
//    void updateProject(Project project) throws SQLException;

//    ---- унаследован от родителя. remove метод
//    void deleteProject(Project project) throws SQLException;

//    ---- унаследован от родителя. findAll метод
//    public List<Project> getProjectList() {
//        return entityManager.createQuery("select e from Project e", Project.class)
//                .getResultList();
//    }



}
