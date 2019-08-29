package cn.aijiang.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MapperTest {

    private InputStream in;
    private SqlSession session;
    private UserMapper mapper;

    @Before
    public void doBefore() throws IOException {
        // 读取mybatis-config.xml文件
        in = Resources.getResourceAsStream("aijiangConfiguration.xml");
        // 初始化SqlSession工厂的建造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 获取一个工厂类，创建SqlSessionFactory类的实例
        SqlSessionFactory factory = builder.build(in);
        // 通过SqlSessionFactory类的工厂模式获得一个session实例
        session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void doAfter() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void testInsert() {
        Integer rows = mapper.count();
        System.out.println("用户的总数：" + rows);    // 用户的总数：6
    }

}
