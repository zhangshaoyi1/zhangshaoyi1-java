package com.zsy.jdbc.test;

import java.io.IOException;
import java.util.Properties;

/**
 * 加载配置文件（properties）
 * @author Administrator
 *
 */
public class peizhi {
/** 
 * 下面是配置文件的内容
 * mysqlDriver=com.mysql.jdbc.Driver
 * jdbc.url=dbc:mysql://localhost:3306/jeesite?useUnicode=true&characterEncoding=utf-8
 *jdbc.username=root
 *jdbc.password=888 
 */
	static Properties pros= null;
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
