package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.utils.SqlSeesionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName SelectMapperTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/11 16:10
 **/
public class SelectMapperTest {

    /**
     * Mybatis的各种查询功能
     * 1.若查询出的数据只有一条,可以通过实体类对象接收
     * a>可以通过实体类对象接收
     * b>可以通过list集合接收
     * c>可以通过map集合接收
     * 结果:{password=123, sex=女, id=3, age=23, email=12345@qq.com, username=张三}
     * 2.若查询的数据有多条
     * a>可以通过list集合接收
     * b>可以通过Map类型的list集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解,此时就可以将每条数据转换的map集合作为值,以某个字段的值作为键,放在同一个map集合中
     * 注意:一定不能通过实体类对象接收结果,此时会抛出异常TooManyResultsException
     *
     * MyBatis中设置了默认的类型别名
     * Java.lang.Integer-->int,integer
     * int-->_int,_integer
     * Map-->map
     * String-string
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSeesionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(3));
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession= SqlSeesionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession= SqlSeesionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession= SqlSeesionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession= SqlSeesionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
}