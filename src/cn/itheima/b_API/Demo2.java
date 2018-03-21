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

* Description:    学习SessionFactory对象，SessionFactory功能:用于创建操作数据库核心对象session对象的工厂
                  注意：1.sessionFactory负责保存和使用所有配置信息，消耗内存资源非常大
          2.sessionFactory属于线程安全的对象设计
          结论:保证web项目中，只创建一个        
* @author 172219902  

* @date 2018年3月21日  

*/
public class Demo2 {
	@Test
	//保持客户
    public  void fun1(){
        //1创建,调用无惨构造
		Configuration conf=new Configuration();
		//2读取指定配置文件=>无参加载方法，默认加载src下的hibernate.cfg.xml文件
		
		conf.configure();
		//3 读取指定orm元数据(扩展),如果主配置中已经引入映射配置.不需要手动加载
		//conf.addResource(resourceName);
		//conf.addClass(persistentClass);
		//4 根据配置信息,创建 SessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		//5获得session
		//打开一个新的session对象
		sf.openSession();
		//获得一个与线程绑定的session对象
		sf.getCurrentSession();
    }
}
