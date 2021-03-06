package com.zyank.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloWordAspect {

	// 前置通知
	public void beforeAdvice() {
		System.out.println("=========before advice========");
	}

	// 后置最终通知
	public void afterFinallyAdvice() {
		System.out.println("=========after finally advice========");
	}

	// 后置返回通知
	public void afterReturningAdvice(Object retVal) {
		System.out.println("=========after return advice retVal:" + retVal);
	}

	// 后置异常通知
	public void afterThrowingAdvice(Exception exception) {
		System.out.println("===========after throwing advice exception:" + exception);
	}
	
	// 后置环绕通知
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {  
	    System.out.println("===========around before advice");  
	    Object retVal = pjp.proceed(new Object[] {"replace"});  
	    System.out.println("===========around after advice");  
	    return retVal;  
	}  
}
