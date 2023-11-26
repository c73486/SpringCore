package spring.core.session01.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.core.session01.bean.Hello;
import spring.core.session01.bean.Lotto;

//利用JavaSpringConfig來配置需管理的java物件(bean)
@Configuration
public class JavaSpringConfig {
	
	//管理Hello這個bean
	@Bean(name = "hello")
	@Scope("singleton")//singleton只會產生單一物件 prototype多物件 每一次的呼叫都會產生新的物件
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
	
	@Bean
	@Scope("prototype")
	public Lotto lotto() {
		return new Lotto();
	}
	
}
