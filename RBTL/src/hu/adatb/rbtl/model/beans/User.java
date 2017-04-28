package hu.adatb.rbtl.model.beans;

public class User {

	private String name, email, password;
	private boolean torzsvasarlo;
	
	/**
	 * User constructor
	 * @param name - Name of the user
	 * @param email - E-mail address
	 * @param password - Password
	 */
	public User(String name, String email, String password){
		this.name = name;
		this.email = email;
		this.password = password;
		torzsvasarlo = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isTorzsvasarlo() {
		return torzsvasarlo;
	}

	public void setTorzsvasarlo(boolean torzsvasarlo) {
		this.torzsvasarlo = torzsvasarlo;
	}

}
