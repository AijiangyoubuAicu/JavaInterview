package cn.aijiang.spring_security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置 Security 组件
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // 配置了哪些 URL 需要被保护，哪些不需要被保护
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()    // 定义当需要登录时候，转到登录页面（如果没有则会自动跳转到默认登录页面）
                .and()
                .httpBasic();

    }
}
