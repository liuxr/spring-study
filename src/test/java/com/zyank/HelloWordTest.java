package com.zyank;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyank.spring.HelloWord;

public class HelloWordTest {

	private ApplicationContext ctx;
	private HelloWord helloWord;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("helloword.xml");
	}

	/*
	 * 通过参数索引进行构造函数注入
	 * 
	 */
	@Test
	public void byIndexTest() {
		helloWord = ctx.getBean("byIndex", HelloWord.class);
		helloWord.print();
	}

	/*
	 * 通过参数类型进行构造函数注入
	 * 
	 */
	@Test
	public void byTypeTest() {

		helloWord = ctx.getBean("byType", HelloWord.class);
		helloWord.print();
	}

	/*
	 * 通过参数名称进行构造函数注入
	 * 
	 */
	
	@Test
	public void byNameTest() {

		helloWord = ctx.getBean("byName", HelloWord.class);
		helloWord.print();
	}

	/*
	 * 集合测试
	 */
	
	@Test
	public void listBeanTest() {
		helloWord = ctx.getBean("listBean", HelloWord.class);
		List<String> list = helloWord.getValues();
		for(String name:list){
			System.out.println(name);
		}
	}

}
