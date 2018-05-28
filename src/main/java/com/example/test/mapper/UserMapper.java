package com.example.test.mapper;

import com.example.test.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Date:Created by luzy on 2018/4/23.
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE login_name = #{userName} and password=#{password}")
    @ResultMap("userMap")
    User findUser(@Param("userName")String userName, @Param("password")String password);
    @Select("SELECT * FROM user WHERE login_name = #{userName}")
    @ResultMap("userMap")
    User findUserByName(String userName);
    @Insert("insert into user(login_name,password,ctime) values(#{loginName},#{password},#{ctime})")
    int save(User user);
    @Select("SELECT * FROM user")
    @Results(id = "userMap", value = {
            @Result(property = "lastTime", column = "last_time"),
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "loginName", column = "login_name")
    })
    List<User> findAll();
    @Select("update user set password=#{password} where id=#{id}")
    void updatePassword(@Param("password")String password,@Param("id")long id);
}
