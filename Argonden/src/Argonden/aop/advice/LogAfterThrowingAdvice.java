package Argonden.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {
	public void afterThrowing(IllegalArgumentException e) {
		// 상황에 맞게 예외 처리를 하면 된다
		System.out.println("AfterThrowingAdvice : 예외가 발생 했습니다 : " + e.getMessage());
	}
}
