package com.zyank.spring;

import java.util.List;

public class HelloWord {

	private String name;
	
	private Integer age;

	public void setName(String name) {
		this.name = name;
	}

	public HelloWord() {
	}

	public HelloWord(String name) {

		this.name = name;
	}
	
	public HelloWord(String name,int age){
		
		this.name=name;
		this.age=age;
	}
	
	

	public void Say() {
		System.out.println("Hello:" + name);
	}
	
	public void print(){		
		System.out.println("name:"+name+",age:"+age);
	}
	/*
	 * 集合注入
	 */
	private List<String> values;

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
}
