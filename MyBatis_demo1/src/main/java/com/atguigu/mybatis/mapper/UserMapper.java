package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/10 23:15
 **/
public interface UserMapper {

    /**
     * Mybatis面向接口编程的两个一致
     * 1.映射文件的namespace要和mapper接口的全类名一致
     * 2.映射文件中SQL语句的id要和mapper接口中的方法名一致
     *
     */

    /**
     * 添加用户信息
     */

    int insertUser();

    /**
     *修改用户信息
     */

    void updateUser();

    /**
     * 删除用户信息
     */

    void deleteUser();

    /**
     *根据id查询用户信息
     */

    User getUserById();

    /**
     *查询所有的用户信息
     */
    List<User> getAllUser();
}
