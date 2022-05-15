package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/27 23:24
 **/
public interface UserMapper {
    List<User> getUserByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);

    List<User> getUserByIdTableName(@Param("tableName") String tableName);

    void insertUser(User user);
}
