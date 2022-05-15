package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MBGTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/28 17:41
 **/
public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
            //根据条件查询
//            EmpExample example=new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("admin").andAgeGreaterThanOrEqualTo(20);
//            example.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample(example);
//            System.out.println(list);

            /**
             * updateByPrimaryKeySelective(选择性添加):值为null则不会改变
             * updateByPrimaryKey(普通添加): 值为null则会变成null
             */
            mapper.updateByPrimaryKeySelective(new Emp(1,"lmy",19,null,"32262@qq.com",3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
