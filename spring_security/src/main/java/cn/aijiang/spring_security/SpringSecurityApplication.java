package cn.aijiang.spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Hashtable;

@SpringBootApplication
public class SpringSecurityApplication {

    Hashtable hashtable;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
