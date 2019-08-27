package cn.aijiang.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 实现接口的实现类
 * 使用 @Component 注解告知 Spring 要为这个实现类配置 bean
 */
@Component
public class HelloWorld implements ToStringInt {

    @Override
    public String toString() {
        return "Hello World!";
    }

}
