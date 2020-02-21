
public class User {

	private String username;
	private String password;
	private String name;

	public boolean verify;
	
	public User() {
		this.username = "";
		this.password = "";
		this.name = "";
	}
	
	public User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean verify(String testUsername, String testPassword) {
		if (this.username.equalsIgnoreCase(testUsername) && this.password.equals(testPassword)) {
			return true;
		}
		return false;
	}

}
