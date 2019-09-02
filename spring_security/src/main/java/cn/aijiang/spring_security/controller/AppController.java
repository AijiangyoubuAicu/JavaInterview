package cn.aijiang.spring.spring_security.controller;

import org.springframework.stereotype.Controller;

/**
 * 创建一个不受保护的应用的控制器
 */
@Controller
public class AppController {

    String home() {
        return "Hello,Spring Security!";
    }

}
