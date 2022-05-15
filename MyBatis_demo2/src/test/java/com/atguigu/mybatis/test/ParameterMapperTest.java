package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSeesionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ParameterMapperTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/11 13:43
 **/
public class ParameterMapperTest {

    @Test
    public void  testgetAllUser(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testJDBC() throws Exception {
        String username = "admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        //PreparedStatement ps = connection.prepareStatement("select * from t_user where username = '" + username + "'");
        PreparedStatement ps = connection.prepareStatement("selelt * from t_user where username = ?");
        ps.setString(1, username);
    }
    /**
     *Mybatis获取参数值的两种方式${},#{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * MyBatis获取参数值的各种情况
     * 1.mapper接口方法为单个的字面量类型
     * 可以通过${}和#{}以任意的字符串获取参数值,但是需要注意${}的单引号问题
     * 2.mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中,以两种方式进行存储
     * a>以arg0,arg1...为键 以参数为值
     * b>以param1,param2...为键 以参数为值
     * 因此我们只需要用#{}和${}以键的方式来访问值即可,但是需要注意${}的单引号问题
     * 3.若mapper接口方法的参数有多个时,可以手动将这些参数放如果一个map集合中
     * 只需要通过#{}和${}以键的方式访问值即可 但是需要注意${}的单引号问题
     * 4.mapper接口方法的参数是实体类类型的参数
     * 只需要通过#{}和${}以属性的方式访问属性值即可,但是需要注意${}的单引号问题
     * 5.使用@Param注解命名参数
     * 此时IMybatis会将这些参数放在一个map集合中,以两种方式进行传输
     * a>以@param为键,以参数为值
     * b>以param1,param2...为键 以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
     */

    @Test
    public void  testGetUserByUsername(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User admin = mapper.getUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void  testCheakLogin(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user= mapper.checkLogin("admin", "123");
        System.out.println(user);
    }

    @Test
    public void  testCheakLoginByMap(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","123");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void  testInsertUser(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "李铭洋", "020802", 19, "男", "3226282152@qq.com"));
        System.out.println(result);
    }

    @Test
    public void  testCheakLoginByParam(){
        SqlSession sqlSession = SqlSeesionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user= mapper.checkLoginByParam("admin", "123");
        System.out.println(user);
    }
}
