package ru.churkin.tm.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.churkin.tm.entity.User;

@Repository
public interface UserRepositoryDS extends FullEntityRepository<User, String> {

    @NotNull
    @Query("select e from User e where e.name = :userName")
    User findUserByName(@QueryParam("userName") String name);

//    ------ не нужен
//    void setEntityManager(EntityManager entityManager);

//    --- унаследован от родителя. persist
//    void createUser(User user) throws SQLException;

//    -- find
//    User findUserById(String id);

//    --- merge
//    void updateUser(String id, User user);

//    --- remove
//    void deleteUser(String id);

//    --- findAll
//    List<User> getUserList();
}
