package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName CacheMapper
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/12 11:20
 **/
public interface CacheMapper {

    /**
     *测试一级缓存
     */

    Emp getEmpById(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
