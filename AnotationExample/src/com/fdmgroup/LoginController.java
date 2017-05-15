package com.fdmgroup;

@Controller(name = "LoginController", urlPattern = "/login")
public class LoginController {
	
	@Size(min = 4, max = 10)
	private String username;
	
	@Size(min = 6, max = 16)
	private String password;
	
	public LoginController(){
		super();
	}

	public LoginController(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	@Runner
	public boolean login(){
		if (username.equals("david") && password.equals("123456")){
			return true;
		}
		return false;
	}
	
	
}
