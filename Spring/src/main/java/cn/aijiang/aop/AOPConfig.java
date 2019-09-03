package cn.aijiang.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AOPConfig {

    /**
     * 声明为 Audience Bean
     * @return 返回一个 Audience 实例
     */
    @Bean
    public Audience audience() {
        return new Audience();
    }
}
