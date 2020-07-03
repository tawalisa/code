package com.lijia.code;

import org.springframework.binding.expression.Expression;
import org.springframework.binding.expression.spel.SpringELExpressionParser;
import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;

public class SpringExpression {

    public static void main(String[] args) {
        final SpelParserConfiguration configuration = new SpelParserConfiguration();
        final SpelExpressionParser spelExpressionParser = new SpelExpressionParser(configuration);
        final SpringELExpressionParser parser = new SpringELExpressionParser(spelExpressionParser);
//        parser.addPropertyAccessor(new PropertyAccessor(){
//
//            @Override
//            public Class<?>[] getSpecificTargetClasses() {
//                System.out.println("1");
//                return new Class[0];
//            }
//
//            @Override
//            public boolean canRead(EvaluationContext evaluationContext, Object o, String s) throws AccessException {
//                System.out.println("2");
//                return false;
//            }
//
//            @Override
//            public TypedValue read(EvaluationContext evaluationContext, Object o, String s) throws AccessException {
//                System.out.println("3");
//                return null;
//            }
//
//            @Override
//            public boolean canWrite(EvaluationContext evaluationContext, Object o, String s) throws AccessException {
//                System.out.println("4");
//                return false;
//            }
//
//            @Override
//            public void write(EvaluationContext evaluationContext, Object o, String s, Object o1) throws AccessException {
//                System.out.println("5");
//
//            }
//        });
        Expression exp = parser.parseExpression("'System.exit(9)'", null);
        String message = (String) exp.getValue(null);
        System.out.println(message);
    }
}
