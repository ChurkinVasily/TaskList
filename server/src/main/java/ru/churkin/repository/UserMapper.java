package ru.churkin.repository;

import org.apache.ibatis.annotations.*;
import ru.churkin.api.IUserRepository;
//import ru.churkin.dto.User;
import ru.churkin.entity.User;

import java.util.Map;

public interface UserMapper extends IUserRepository {

    @Insert("insert into users (id, name, password) values (#{id}, #{name}, #{password})")
    void createUser(User user);

    @Select("select * from users where name = #{name}")
    User findUserByName(String name);

    @Select("select * from users where id = #{id}")
    User findUserById(String id);

    @Update("update users set name = #{name}, password = #{password} where id = #{id}")
    void updateUser(String id, User user);

    @Delete("delete from users where id = #{id}")
    void deleteUser(String id);

    @Select("select * from users")
    @MapKey("id")
    Map<String, User> getUserMap();
}
