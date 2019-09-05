package com.zyx.ssm.dao;

import com.zyx.ssm.domain.Role;
import com.zyx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户持久层
 */
@Repository("userDao")
public interface IUserDao {

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(email,userName,PASSWORD,phoneNum,STATUS) values(#{email},#{userName},#{passWord},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;


    @Select("select * from users where username=#{userName}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "email", column = "email"),
            @Result(property = "passWord", column = "PASSWORD"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zyx.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUserName(String userName) throws Exception;

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "email", column = "email"),
            @Result(property = "passWord", column = "PASSWORD"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zyx.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id) throws Exception;


    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findOthersRole(String userId) throws Exception;

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
