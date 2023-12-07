package spring.core.session03.mvc.model.repository;

import java.util.List;

import spring.core.session03.mvc.model.bean.User;

public interface UserDao {
	void create(User user);
	List<User> readUsers();
}
