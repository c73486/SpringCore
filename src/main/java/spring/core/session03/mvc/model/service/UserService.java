package spring.core.session03.mvc.model.service;

import java.util.List;

import spring.core.session03.mvc.model.bean.User;

public interface UserService {
	void addUser(User user);
	List<User> queryUsers();
}
