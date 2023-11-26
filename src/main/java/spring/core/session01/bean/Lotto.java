package spring.core.session01.bean;

import java.util.Random;

public class Lotto {
	
	private int number;
	
	public Lotto() {
		System.out.println("Lotto建構子");
		Random random = new Random();
		number = random.nextInt(100);
	}
	
	public int getNumber() {
		return number;
	}
	
	
}
