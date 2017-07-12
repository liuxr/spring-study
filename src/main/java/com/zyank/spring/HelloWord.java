package com.zyank.spring;

public class HelloWord {
	
	private String name;
	
	public void setName(String name) {
		this.name= name;
	}
	public HelloWord(){}
	public HelloWord(String name){
		
		this.name=name;
	}
	
	public void Say(){
		System.out.println("Hello:"+name);
		
	}
}
