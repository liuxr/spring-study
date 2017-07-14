package com.zyank;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyank.aop.service.IHelloWorldService;

public class AopTest {

	/*
	 * HelloWorld切面测试
	 */
	@Test
	public void HelloWorldTest(){
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");
		IHelloWorldService helloWorldService=ctx.getBean("helloWorldService",IHelloWorldService.class);
		helloWorldService.sayHello();
		
	}
	
	@Test
	public void SchemaAfterReturningAdviceTest(){
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");
		IHelloWorldService helloWorldService=ctx.getBean("helloWorldService",IHelloWorldService.class);
		helloWorldService.sayAfterReturning();
		
	}
	
	@Test
	public void SchemaAfterThorwingAdviceTest(){
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");
		IHelloWorldService helloWorldService=ctx.getBean("helloWorldService",IHelloWorldService.class);
		helloWorldService.sayAfterThrowing();
		
	}
	
	@Test  
	public void testSchemaAroundAdvice() {  
	    System.out.println("======================================");  
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");  
	    IHelloWorldService helloworldService =  
	    ctx.getBean("helloWorldService", IHelloWorldService.class);  
	    helloworldService.sayAround("haha");  
	    System.out.println("======================================");  
	}  
}
