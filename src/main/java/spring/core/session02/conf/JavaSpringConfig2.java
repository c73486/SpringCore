package spring.core.session02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.session02.bean.Author;

@Configuration
public class JavaSpringConfig2 {
	
	@Bean
	public Author author1() {
		return new Author();
	}
	
	@Bean
	public Author author2() {
		Author author = new Author();
		author.setName("fifi");
		author.setSex('女');
		author.setAge(0);
		return author;
	}
	
	@Bean
	public Author author3() {
		return new Author("May",'女',30);
	}
	
	@Bean
	public Author author4() {
		Author author = new Author();
		author.setName("ccc");
		author.setSex('中');
		author.setAge(50);
		return author;
	}
	
	@Bean
	public Author author5() {
		return new Author("ddd",'中',100);
	}
	
}
