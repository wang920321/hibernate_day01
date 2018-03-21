/**  

* Title: Demo.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年3月21日  

* @version 1.0  

*/
package cn.itheima.b_API;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itheima.domain.Customer;

/**  

* Title: Demo  

* Description:    学习Session对象，Session功能:表达hibernate框架与数据库之间的连接(会话)
*                 类似于JDBC年代的connection对象，还可以完成对数据库中数据的增删改查操作
*                 session是hibernate操作数据库的核心对象
                     
* @author 172219902  

* @date 2018年3月21日  

*/
public class Demo3 {
	@Test
	//事务操作,添加用户
    public  void fun1(){
        //1创建,调用无惨构造
		Configuration conf=new Configuration().configure();
		
		//2 根据配置信息,创建 SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//3获得session
		Session session = sf.openSession();
		//4session获得操作事务的transaction对象
		Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象(建议使用)
		Transaction tx2 = session.beginTransaction();
		//----------------------------
		Customer c =new Customer();
		c.setCust_name("1234");
		session.save(c);
		//------------------------------
		tx2.commit();
		
		session.close();
		sf.close();
    }
	@Test
	//session查询
	//查询id为1的customer对象
    public  void fun2(){
        //1创建,调用无惨构造
		Configuration conf=new Configuration().configure();
		
		//2 根据配置信息,创建 SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//3获得session
		Session session = sf.openSession();
		//4session获得操作事务的transaction对象
		Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象(建议使用)
		Transaction tx2 = session.beginTransaction();
		//----------------------------
		Customer customer = session.get(Customer.class, 1L);
		System.out.println(customer);
		//------------------------------
		tx2.commit();
		
		session.close();
		sf.close();
    }
	@Test
	//修改
    public  void fun3(){
        //1创建,调用无惨构造
		Configuration conf=new Configuration().configure();
		
		//2 根据配置信息,创建 SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//3获得session
		Session session = sf.openSession();
		//4session获得操作事务的transaction对象
		Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象(建议使用)
		Transaction tx2 = session.beginTransaction();
		//----------------------------
		//1获得要修改的对象
		Customer customer = session.get(Customer.class, 1L);
		//2修改
		customer.setCust_name("dage");
		//3执行update
		session.update(customer);
		//------------------------------
		tx2.commit();
		
		session.close();
		sf.close();
    }
	@Test
	//修改
    public  void fun4(){
        //1创建,调用无惨构造
		Configuration conf=new Configuration().configure();
		
		//2 根据配置信息,创建 SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//3获得session
		Session session = sf.openSession();
		//4session获得操作事务的transaction对象
		Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象(建议使用)
		Transaction tx2 = session.beginTransaction();
		//----------------------------
		//1获得要修改的对象
		Customer customer = session.get(Customer.class, 1L);
		
		//2调用delete删除对象
		session.delete(customer);
		//------------------------------
		tx2.commit();
		
		session.close();
		sf.close();
    }
}
