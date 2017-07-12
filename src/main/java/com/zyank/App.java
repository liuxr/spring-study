package com.zyank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyank.spring.HelloWord;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("helloword.xml");
        
        //HelloWord helloWord=(HelloWord) ctx.getBean("helloword");
        //两种方式都可以达到效果，区别？
        //HelloWord helloWord=ctx.getBean("helloword",HelloWord.class);
        
        //静态工场模式
        HelloWord helloWord=ctx.getBean("bean1",HelloWord.class);
        
        
        helloWord.Say();
    }
}
