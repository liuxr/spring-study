package com.zyank;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

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
