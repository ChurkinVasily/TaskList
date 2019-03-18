package ru.churkin.tm.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.churkin.tm.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserRepositoryDS extends FullEntityRepository<User, String> {

//    ------ не нужен
//    void setEntityManager(EntityManager entityManager);
@Inject
void setEntityManager(EntityManager entityManager);

//    --- унаследован от родителя. persist
//    void createUser(User user) throws SQLException;

    @NotNull
    @Query("select e from User e where e.name = :userName")
    User findUserByName(@QueryParam("userName") String name);

//    -- find
//    User findUserById(String id);

//    --- merge
//    void updateUser(String id, User user);

//    --- remove
//    void deleteUser(String id);

//    --- findAll
//    List<User> getUserList();


}
