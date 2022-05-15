package com.atguigu.mybatis.test;


import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSeesionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName ResultMapTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/27 16:10
 **/
public class ResultMapTest {

    @Test
    public void test01(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void test02(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteMore("4,5,6");
        System.out.println(result);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserByIdTableName("t_user");
        System.out.println(list);
    }

    @Test
    public void test04(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(null,"李铭洋","123456",20,"男","123456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void test05(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        allEmp.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void test06(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpAndDept(1);
        System.out.println(emp);
    }

    @Test
    public void test07(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println("********");
        System.out.println(emp.getDept());
    }

    @Test
    public void test08(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void test09(){
        SqlSession sqlSession=SqlSeesionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getEmpAndDeptByStepTwo(1);
        System.out.println(dept.getDeptName());
    }
}
