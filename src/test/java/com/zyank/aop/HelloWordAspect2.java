package com.zyank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HelloWordAspect2 {

	@Pointcut(value = "execution(* com.zyank..*.sayBefore(..))&&args(param)", argNames = "param")
	public void beforePointcut(String param) {
		System.out.println("---------------" + param);
	}

	@Before(value = "beforePointcut(param)", argNames = "param")
	public void beforeAdvice(String param) {
		System.out.println("===========before advice param:" + param);

	}
	
	@Around(value="execution(* com.zyank..*.sayAround(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		
		Object retVal=pjp.proceed(new Object[]{"replace"});
		
		System.out.println("around after advice");
		
		return retVal;
	}
	
}
