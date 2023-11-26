package spring.core.session01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session01.bean.Hello;
import spring.core.session01.conf.JavaSpringConfig;

public class TestHello {
	
	public static void main(String[] args) {
		//傳統方式
		Hello hello = new Hello();
		System.out.println(hello.today());
		
		//利用Spring來管理new物件的問題
		//利用JavaSpringConfig(Java配置)來取得bean物件
		//1.得到應用程式配置環境
		ApplicationContext ctx1 = new AnnotationConfigApplicationContext(JavaSpringConfig.class);
		//2.取bean
		Hello hello1 = ctx1.getBean("hello",Hello.class);
		System.out.println(hello1.today());
		
		//利用Spring來管理new物件的問題
		//使用conf/beans-config1.xml(XML配置)來取得bean物件
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("beans-config1.xml");
		Hello hello2 = ctx2.getBean("hello",Hello.class);
		System.out.println(hello2.today());
		
	}
	
}
