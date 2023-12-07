package spring.core.session03.mvc.model.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import spring.core.session03.mvc.model.bean.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	//定義一個in-memory集合來放user物件資料
	private static List<User> users = new CopyOnWriteArrayList<>();

	@Override
	public void create(User user) {
		System.out.println("呼叫UserDao create()");
		users.add(user);
	}

	@Override
	public List<User> readUsers() {
		return users;
	}

}
