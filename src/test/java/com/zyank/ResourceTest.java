package com.zyank;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ResourceTest {
	@Test
	public void ByteArrayResourceTest(){
		Resource resource=
				new org.springframework.core.io.ByteArrayResource("Hello1 World!".getBytes());
		if(resource.exists()){
			dumpStream(resource);
		}
	}
	
	@Test
	public void FileResourceTest(){
		File file=new java.io.File("d:/test1.txt");
		Resource resource=new FileSystemResource(file);
		if(resource.exists()){
			dumpStream(resource);
		}		
	}
	
	/*
	 * 多资源通配符
	 */
	@Test
	public void ClassPathPrefix() throws IOException{
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource [] resources=resolver.getResources("classpath*:*.properties");
//		System.out.println(resources[0].getFilename());
//		System.out.println(resources.length);
//		Assert.assertTrue(resources.length==2);
		for(Resource resource :resources){
			
			System.out.println(resource.getFilename());
		}
		
	}
	
	private void  dumpStream(Resource resource) {
		InputStream iStream=null;
		try {
			//1.获取文件资源
			iStream=resource.getInputStream();
			//2.读取资源
			byte [] descBytes=new byte[iStream.available()];
			iStream.read(descBytes);
			System.out.println(new String(descBytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//3.关闭资源
				iStream.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}
}
