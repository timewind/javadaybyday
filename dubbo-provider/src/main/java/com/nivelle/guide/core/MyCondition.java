package com.nivelle.guide.core;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * T
 *
 * @author fuxinzhong
 * @date 2019/09/24
 */
public class MyCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String osName = context.getEnvironment().getProperty("os.name");

        System.err.println("OSNAME is" + osName);

        if (osName.contains("Mac")) {
            System.err.println("OSNAME is" + "true");
            return false;
        } else {
            return false;
        }
    }

}
