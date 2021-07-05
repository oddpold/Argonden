package Argonden.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		String messaageString = "앞에서 실행 될 로직 : fnName = " + method.getName();
		System.out.println(messaageString);
	}

}
