package spring.core.group_buy.entity;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private Integer level;
	
	public User() {
		
	}

	public User(Integer userId, String username, String password, Integer level) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.level = level;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", level=" + level
				+ "]";
	}
	
}
