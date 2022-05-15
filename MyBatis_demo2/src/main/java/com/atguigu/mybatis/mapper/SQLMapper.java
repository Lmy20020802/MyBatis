package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName SQLMapper
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/11 17:15
 **/
public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     */

    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */

    int deleteMore(@Param("ids") String ids);

    /**
     *查询指定表中的数据
     */

    List<User> getUserByIdTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     */
    void insertUser(User user);
}
