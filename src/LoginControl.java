public class LoginControl extends CreateAccountControl {
	
	public boolean signIn(String username, String password) {
		
		return server.login(username, password);
	}
	
}