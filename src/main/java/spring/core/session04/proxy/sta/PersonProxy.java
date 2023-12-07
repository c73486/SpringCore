package spring.core.session04.proxy.sta;

//靜態代理
//代理物件就是執行所代理的任務(公用邏輯)
public class PersonProxy implements Person{

	private Person person;
	
	public PersonProxy(Person person) { //person可能是man woman child
		this.person = person;
	}
	
	@Override
	public void work() {
		// before 公用邏輯
		System.out.println("出門戴口罩");
		// 代理執行代理對象的業務方法
		try {
			person.work();
		} catch (Exception e) {
			//exception 公用例外邏輯
			System.out.println(e);
			System.out.println("若有例外發生： 沒口罩？");
			System.out.println("去買口罩");
			System.out.println("並將口罩戴回");
		}
		//end 公用邏輯
		System.out.println("回家脫口罩");
	}

}
