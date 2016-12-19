//import something
public class CreateAccountControl {
	
	protected Server server = new Server();
	boolean accountCreated = false;
	
	public boolean createAccount(String user, String passWord) {
	
		//if !username.equals("") &&  !password.equals("")
		//Goes to Web app communicator, sees if 
		//username is taken or available, if returns true:
		//accountCreated = true
		
		accountCreated = server.createAccount(user, passWord);
		
		return accountCreated;
		
	}
}