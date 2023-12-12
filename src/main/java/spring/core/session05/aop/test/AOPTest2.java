package spring.core.session05.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session05.aop.Computer;

public class AOPTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config5-aop.xml");
		Computer computer = ctx.getBean("computerImpl",Computer.class);
		System.out.println(computer.add(10, 20));
		System.out.println(computer.div(10, 2));
		System.out.println(computer.div(10, 0));
	}

}
