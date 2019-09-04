package cn.aijiang.aop;

import org.aspectj.lang.annotation.*;

/**
 * 定义一个切点
 *
 * 对于演出这个整体业务来说，观众在现实上表现得很重要(观众多，恰到钱就越多嘛)
 * 但在业务代码里，我们只关心演出业务，观众应作为切面来看待
 */
@Aspect
public class Audience {

//    /**
//     * 表演开始前的表现一
//     */
//    @Before("execution(* cn.aijiang.aop.Performance.perform(..))")
//    public void silenceCellPhones() {
//        System.out.println("手机静音了嗷。");
//    }
//
//    /**
//     * 表演开始前的表现二
//     */
//    @Before("execution(* cn.aijiang.aop.Performance.perform(..))")
//    public void takeSeats() {
//        System.out.println("谈话停止了嗷。");
//    }
//
//    /**
//     * 表演精彩时的表现
//     */
//    @AfterReturning("execution(* cn.aijiang.aop.Performance.perform(..))")
//    public void applause() {
//        System.out.println("喔喔喔喔！精彩极了啊！");
//    }
//
//    /**
//     * 表演失败之后的表现
//     */
//    @AfterThrowing("execution(* cn.aijiang.aop.Performance.perform(..))")
//    public void demandRefund() {
//        System.out.println("这表演真是太下饭，建议退钱！");
//    }

    /**
     * 定义命名的切点
     */
    @Pointcut("execution(* cn.aijiang.aop.Performance.perform(..))")
    public void performance() {

    }

    /**
     * 表演开始前的表现一
     */
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("手机静音了嗷。");
    }

    /**
     * 表演开始前的表现二
     */
    @Before("performance()")
    public void takeSeats() {
        System.out.println("谈话停止了嗷。");
    }

    /**
     * 表演精彩时的表现
     */
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("喔喔喔喔！精彩极了啊！");
    }

    /**
     * 表演失败之后的表现
     */
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("这表演真是太下饭，建议退钱！");
    }

}
