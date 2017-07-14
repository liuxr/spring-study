package com.zyank.aop.service.impl;

import com.zyank.aop.service.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {

	@Override
	public void sayHello() {
		System.out.println("======Hello World!=====");
	}

	@Override
	public boolean sayAfterReturning() {
		System.out.println("=========after returning");
		return true;
	}

	@Override
	public void sayAfterThrowing() {
		 System.out.println("============before throwing");  
		    throw new RuntimeException();  
	}

	@Override
	public void sayAround(String param) {
		  System.out.println("============around param:" + param);  		
	}
}
