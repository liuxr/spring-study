package com.zyank.spring;

/*
 *	静态工场模式 
 */
public class HelloWordStaticFactory {
	public HelloWord newInstance(String name) {
		return new HelloWord(name);
	}
}
