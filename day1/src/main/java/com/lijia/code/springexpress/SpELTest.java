package com.lijia.code.springexpress;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
public class SpELTest {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext seContext = new StandardEvaluationContext();
    	seContext.registerFunction("getStringLen",StringLength.class.getDeclaredMethod("getStringLen", 
          new Class[] { String.class }));
		Integer len =  parser.parseExpression("#getStringLen('concretepage.com')").getValue(seContext, Integer.class);
		System.out.println(len);
	}
}
abstract class StringLength {
	  public static int getStringLen(String str) {
	    return str.length()+10;
	  }
}