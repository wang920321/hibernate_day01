/**  

* Title: Demo.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年3月21日  

* @version 1.0  

*/
package cn.itheima.a_hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itheima.domain.Customer;

/**  

* Title: Demo  

* Description:    测试hibernate框架

* @author 172219902  

* @date 2018年3月21日  

*/
public class Demo {
	@Test
	//保持客户
    public  void fun1(){
    	Configuration conf=new Configuration().configure();
    	
    	SessionFactory sessionFactory = conf.buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	//----------------------
    	Customer c=new Customer();
    	c.setCust_name("百度公司");
    	session.save(c);//执行保存
    	//----------------------
    	
    	tx.commit();
    	session.close();
    	sessionFactory.close();
    }
}
