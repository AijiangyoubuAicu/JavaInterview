package cn.aijiang.spring;

import org.springframework.context.annotation.ComponentScan;

/**
 * 创建一个类使用 @ComponentScan 注解在 Spring 中启动组件扫描
 *
 * @ComponentScan 默认会扫描与配置类相同的包
 * 因为类ToStringIntConfig位于cn.aijiang.spring包中，因此
 * Spring将会扫描这个包以及这个包下的所有子包，查找带
 * 有 @Component 注解的类
 *
 * 所以这个被 @ComponentScan 注解的类所处的包很关键，它决定了扫描的范围大小
 */
@ComponentScan
public class ToStringIntConfig {
}
