package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSeesionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName com.atguigu.mybatis.test.ResultMapTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/11 18:48
 **/
public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况
     * a>为字段名起别名,保持和属性名的一致
     * b>设置全局配置,将_自动映射为驼峰
     * select eid,emp_name empName,age,sex,email from t_emp;
     * c>通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *    <id property="eid" column="eid"></id>
     *    <result property="empName" column="emp_name"></result>
     *    <result property="age" column="age"></result>
     *    <result property="sex" column="sex"></result>
     *    <result property="email" column="email"></result>
     * </resultMap>
     *
     * 处理多对一的关系
     * a> 级联映射
     * b>association
     * c>分布查询
     *
     * 处理一对多的映射关系
     * a>collection
     * b>分布查询
     */
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testEmpAndDept(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(3);
        System.out.println(emp);
    }

    @Test
    public void testEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println("**************");
        System.out.println(emp.getDept());
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepone(1);
        System.out.println(dept.getDeptName());
    }
}
