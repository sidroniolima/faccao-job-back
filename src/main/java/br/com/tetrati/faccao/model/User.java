package br.com.tetrati.faccao.model;

import java.util.ArrayList;
import java.util.List;

public class User 
{
	private String username;
	private String password;
	private List<Roles> roles;
	private boolean isEnabled;
	
	public User() 
	{
		roles = new ArrayList<Roles>();
		roles.add(Roles.ROLE_USER);
		isEnabled = true;
	}
	
	public User(String username, String password) 
	{
		this();
		this.setPassword(password);
		this.username = username;
	}
	
	public User(String username, String password, List<Roles> roles) 
	{
		this();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public User(String username, List<Roles> roles) 
	{
		this();
		this.username = username;
		this.roles = roles;
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
		this.password = password;//= new StandardPasswordEncoder().encode(password);
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}
