package spring.core.session01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session01.bean.Lotto;
import spring.core.session01.conf.JavaSpringConfig;

public class TestLotto {
	
	public static void main(String[] args) {
		//XML配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config1.xml");
		Lotto lotto = ctx.getBean("lotto",Lotto.class);
		System.out.println(lotto.getNumber());
		
		Lotto lotto2 = ctx.getBean("lotto",Lotto.class);
		System.out.println(lotto2.getNumber());
		
		//JAVA配置
		ApplicationContext javactx = new AnnotationConfigApplicationContext(JavaSpringConfig.class);
		Lotto javalotto = javactx.getBean(Lotto.class);
		System.out.println(javalotto.getNumber());
		
		Lotto javalotto2 = javactx.getBean("lotto",Lotto.class);
		System.out.println(javalotto2.getNumber());
	}
	
}
