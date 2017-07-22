package com.zyank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*
 * mysql
 */
public class jdbcTemplateMysqlTest {

	private static JdbcTemplate jdbcTemplate;

	@BeforeClass
	public static void setUpClass() {
		
		// 方法一：一个赋值
		// String
		// url="jdbc:mysql://localhost:3306/meimei?useUnicode=true&amp;characterEncoding=UTF-8";
		// String username="root";
		// String password="81520302";
		// DriverManagerDataSource dataSource
		// =new DriverManagerDataSource(url,username,password);
		// dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");

		// 方法二：读取配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("sql.xml");
		DriverManagerDataSource dataSource = context.getBean("dataSource", DriverManagerDataSource.class);

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Test
	public void QueryTest() {
		String sql = "select * from mm_user";

		jdbcTemplate.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// 2.处理结果集
				String value = rs.getString("NICK_NAME");
				System.out.println("Column TABLENAME:" + value);
			}
		});
	}

}
