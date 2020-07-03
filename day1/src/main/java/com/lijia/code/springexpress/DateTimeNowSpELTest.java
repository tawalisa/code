package com.lijia.code.springexpress;

import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.time.OffsetDateTime;

public class DateTimeNowSpELTest {
    public static void main(String[] args) throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext seContext = new StandardEvaluationContext();
        seContext.registerFunction("DATETIMENOW",Function.class.getDeclaredMethod("datetimeNow",
                new Class[] { DateTimeNowInterval.class, Integer.class }));
        seContext.addPropertyAccessor(new PropertyAccessor(){
            @Override
            public Class<?>[] getSpecificTargetClasses() {
                return null;
            }
            @Override
            public boolean canRead(EvaluationContext evaluationContext, Object o, String s) throws AccessException {
                return DateTimeNowInterval.contains(s);
            }
            @Override
            public TypedValue read(EvaluationContext evaluationContext, Object o, String s) throws AccessException {
                return new TypedValue(DateTimeNowInterval.valueOf(s));
            }
            @Override
            public boolean canWrite(EvaluationContext evaluationContext, Object o, String s) throws AccessException {
                return false;
            }
            @Override
            public void write(EvaluationContext evaluationContext, Object o, String s, Object o1) throws AccessException {
            }
        });
        OffsetDateTime offsetDateTime =  parser.parseExpression("#DATETIMENOW( DAY ,  '-1') ").getValue(seContext, OffsetDateTime.class);
        System.out.println(offsetDateTime);
    }
    enum DateTimeNowInterval{
        DAY;
        public static boolean contains(String test) {
            for (DateTimeNowInterval dateTimeNowInterval : values()) {
                if (dateTimeNowInterval.name().equals(test)) {
                    return true;
                }
            }
            return false;
        }
    }
    abstract static class Function{
        public static OffsetDateTime datetimeNow(DateTimeNowInterval dateTimeNowInterval, Integer interval){
            System.out.println(dateTimeNowInterval);
            System.out.println(interval);
            return OffsetDateTime.now();
        }
    }
}
