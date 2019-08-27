package cn.aijiang.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Programmer {

    private HelloWorld hw;

    @Autowired
    public Programmer(HelloWorld hw) {
        this.hw = hw;
    }

    public void print() {
        System.out.println("这名程序员打出人生的第一行代码：" + hw.toString());
    }
}
