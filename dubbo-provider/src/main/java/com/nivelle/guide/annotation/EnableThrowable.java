package com.nivelle.guide.annotation;

import com.nivelle.guide.spring.hock.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义注解@Import的用法
 *
 * @author fuxinzhong
 * @date 2019/08/25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {MyImportBeanDefinitionRegistrar.class})
public @interface EnableThrowable {

    Class<?>[] targets() default {};

}
