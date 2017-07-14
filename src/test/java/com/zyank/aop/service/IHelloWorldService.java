package com.zyank.aop.service;

public interface IHelloWorldService {

	public void sayHello();
	
	public boolean sayAfterReturning();
	
	public void sayAfterThrowing();
	
	public void sayAround(String param);
	
}
