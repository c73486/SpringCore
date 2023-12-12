package spring.core.group_buy.dao;

import java.util.List;
import java.util.Optional;

import spring.core.group_buy.entity.Product;
import spring.core.group_buy.entity.User;

public interface GroupByDao {
	
	List<User> findAllUsers();
	
	void addUser(User uesr);
	
	void updateUserPassword(Integer userId, String newPassword);
	
	Optional<User> finUserByUsername(String username);
	
	Optional<User> finUserByUserId(String userId);
	
	List<Product> finrAllProducts();
	
	Optional<Product> findProductById(Integer productId);
	
	
	
}
