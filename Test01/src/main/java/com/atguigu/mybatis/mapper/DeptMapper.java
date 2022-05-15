package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName DeptMapper
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/27 16:05
 **/
public interface DeptMapper {

    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    Dept getDeptAndEmp(@Param("did") Integer did);

    Dept getDeptAndEmpByStepone(@Param("did") Integer did);
}
