package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DynamicSQLMapper
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/28 08:25
 **/
public interface DynamicSQLMapper {

    /**
     * 多条件查询
     */

    List<Emp> getEmpByCondition(Emp emp);


    /**
     * 测试choose when otherwise
     */

    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组来实现批量删除
     */

    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */

    int insertMoreByList(@Param("emps") List<Emp> emps);
}
