package cn.aijiang.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class HelloWorldTest {
    public static void main(String[] args) throws Throwable {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:spring-config.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("工厂初始化完成！");
        HelloWorld helloWorld= bf.getBean("HelloWorld",HelloWorld.class);
        System.out.println(helloWorld.toString());

        ClassPathXmlApplicationContext ac;
    }
}
