package spring.core.session03.factory;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

import spring.core.session03.bean.Car;

/*
 * FactoryBean的使用時機
 * 若需要對bean做一系列的複雜程序
 * 1.建立一個bean物件後ㄝ,必須要連線資料庫取得相關資料後,將該資訊注入到指定物件屬性中
 * 2.建立一個bean物件後ㄝ,必須要連某一個雲端資源取得相關資源後,將該資訊注入到指定物件屬性中
 * 情境：有一個天氣物件Weather
 * 當使用者要取得天氣物件的時候,該物件在建立的時期會先到https://openweathermap.org/api 透過API取得目前天氣資料
 * 此時因為建立天氣物件時候過程有複雜性,所以適合用FactoryBean來管理此物件
 */
public class CarFactory implements FactoryBean<Car>{

	@Override
	public Car getObject() throws Exception {
		//Car car = new Car(); //空的(無設定屬性資料) car物件
		Random random = new Random();
		int price = random.nextInt(200_0000);
		Car car = new Car("BMW",price);
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
