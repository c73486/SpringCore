package spring.core.session02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.session02.bean.Author;
import spring.core.session02.bean.Book;
import spring.core.session02.bean.Color;
import spring.core.session02.bean.Paper;
import spring.core.session02.bean.Size;

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
	
	@Bean
	public Book book1() {
		return new Book();
	}
	
	@Bean
	public Book book2() {
		Book book = new Book();
		book.setName("Java");
		book.setPrice(500);
		book.setAuthor(author2());
		return book;
	}
	
	@Bean
	public Book book3() {
		return new Book("Spring", 600, author3());
	}
	
	@Bean
	public Book book4() {
		Book book = new Book();
		book.setName("Python");
		book.setPrice(450);
		book.setAuthor(author4());
		return book;
	}
	
	@Bean
	public Book book5() {
		return new Book("VB", 280, author5());
	}
	
	@Bean
	public Color white() {
		Color white = new Color();
		white.setName("白");
		return white;
	}
	
	@Bean(name = "color")
	public Color yellow() {
		Color yellow = new Color();
		yellow.setName("黃");
		return yellow;
	}
	
	@Bean
	public Size a4() {
		Size a4 = new Size();
		a4.setName("A4");
		return a4;
	}
	
	@Bean(name = "size")
	public Size b5() {
		Size b5 = new Size();
		b5.setName("B5");
		return b5;
	}
	
	@Bean
	//查找順序 byName -> byType 
	public Paper paper1(Color white, Size a4) {
		Paper paper = new Paper();
		paper.setId(1);
		paper.setColor(white);
		paper.setSize(a4);
		return paper;
	}
	
	@Bean
	public Paper paper2(Color color, Size size) {
		Paper paper = new Paper();
		//使用方法參數進行裝配
		paper.setId(2);
		paper.setColor(color);
		paper.setSize(size);
		return paper;
	}
	
	@Bean
	public Paper paper3(Color color, Size size) {
		//使用建構子進行裝配
		Paper paper = new Paper(color, size);
		paper.setId(3);
		return paper;
	}
	
}
