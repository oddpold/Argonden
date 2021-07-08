package Argonden.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed();
		
		long end = System.currentTimeMillis();
		
		String message = "AroundAdvice : calculated time is " + (end - start) + " ms";
		System.out.println(message);
		
		return result;
	}

}
