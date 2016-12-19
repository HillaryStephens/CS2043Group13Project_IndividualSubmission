import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

public class MobileApp {

	private JFrame frame;
	
	//Create Account UI
	private JPanel createAccountUI;
	private JTextField createUserField;
	private JPasswordField createPassField;
	private JButton btnCreate;
	private JButton btncancel;
	
	//Login UI
	private JPanel loginUI;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton btnSignIn;
	private JButton btnCreateAccount;
	
	//Session UI
	private JPanel sessionUI;
	private JButton btnCreateSession;
	private JButton btnStartSession;
	private JButton btnEndSession;
	private JLabel lblSessionID;
	
	//Control Classes
	private CreateAccountControl createControl = new CreateAccountControl();
	private LoginControl loginControl = new LoginControl();
	private SessionControl sessionControl = new SessionControl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MobileApp window = new MobileApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MobileApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//creates the frame for the application
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//creates the buttons, text fields and labels for the Login UI
		JPanel loginUI = new JPanel();
		frame.getContentPane().add(loginUI, "name_298376552787788");
		loginUI.setLayout(null);
		loginUI.setVisible(true);
		
		JLabel lblAppName = new JLabel("Dog Walker App");
		lblAppName.setBounds(169, 26, 77, 14);
		loginUI.add(lblAppName);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(193, 51, 46, 14);
		loginUI.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(54, 96, 63, 14);
		loginUI.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(54, 134, 63, 14);
		loginUI.add(lblPassword);
		
		userField = new JTextField();
		userField.setBounds(121, 93, 199, 20);
		loginUI.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 131, 199, 20);
		loginUI.add(passwordField);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(158, 172, 107, 23);
		loginUI.add(btnSignIn);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(158, 206, 107, 23);
		loginUI.add(btnCreateAccount);
		loginUI.setVisible(false);
		
		//creates the buttons, text fields and labels for the CreateAccount UI
		JPanel createAccountUI = new JPanel();
		frame.getContentPane().add(createAccountUI, "name_298371963838751");
		createAccountUI.setLayout(null);
		createAccountUI.setVisible(false);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setBounds(171, 25, 90, 14);
		createAccountUI.add(lblCreateAccount);
		
		JLabel lblCreateUser = new JLabel("Username:");
		lblCreateUser.setBounds(50, 74, 68, 14);
		createAccountUI.add(lblCreateUser);
		
		JLabel lblCreatePass = new JLabel("Password:");
		lblCreatePass.setBounds(50, 121, 68, 14);
		createAccountUI.add(lblCreatePass);
		
		createUserField = new JTextField();
		createUserField.setBounds(128, 71, 211, 20);
		createAccountUI.add(createUserField);
		createUserField.setColumns(10);
		
		createPassField = new JPasswordField();
		createPassField.setBounds(128, 118, 211, 20);
		createAccountUI.add(createPassField);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setBounds(103, 186, 107, 23);
		createAccountUI.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(220, 186, 107, 23);
		createAccountUI.add(btnCancel);
		
		
		//creates the buttons, text fields and labels for the Session UI
		JPanel sessionUI = new JPanel();
		frame.getContentPane().add(sessionUI, "name_298379468984596");
		sessionUI.setLayout(null);
	
		JButton btnCreateSession = new JButton("Create Session");
		btnCreateSession.setBounds(39, 11, 111, 23);
		sessionUI.add(btnCreateSession);
		
		JButton btnStartSession = new JButton("Start Session");
		btnStartSession.setBounds(160, 11, 111, 23);
		sessionUI.add(btnStartSession);
		
		JButton btnEndSession = new JButton("End Session");
		btnEndSession.setBounds(281, 11, 111, 23);
		sessionUI.add(btnEndSession);
		
		JLabel lblSessionID = new JLabel("");
		lblSessionID.setBounds(160, 39, 111, 14);
		lblSessionID.setVisible(false);
		sessionUI.add(lblSessionID); 
		 
		//Action Listeners - LoginUI
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUI.setVisible(false);
				createAccountUI.setVisible(true);
				
			}
		});
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean signedIn = true;//loginControl.signIn(userField.toString(),passwordField.toString()); 
				if(signedIn) {
					loginUI.setVisible(false);
					sessionUI.setVisible(true);
				}
			}
		});
		
		//Action Listeners - CreateAccountUI
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean created = createControl.createAccount(createUserField.toString(), createPassField.toString());
				if(created) {
					createAccountUI.setVisible(false);
					loginUI.setVisible(true);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAccountUI.setVisible(false);
				loginUI.setVisible(true);
			}
		});
		
		//Action Listeners - SessionUI
		btnCreateSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int sessionID = sessionControl.createSession("Max");
					lblSessionID.setText("Session ID: "+ sessionID);
				}
				catch (FileNotFoundException fe) {
					fe.printStackTrace();
				}
				lblSessionID.setVisible(true);
			}
		});
		
		btnStartSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sessionControl.startSession();
			}
		});
		
		btnEndSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sessionControl.endSession();
			}
		});
		
	/*	TimerTask task = new TimerTask();
		Timer timer = new Timer();
		int twoMins = 2*60*1000;
		timer.scheduleAtFixedRate(task,0,twoMins);  */
		
		
		

	}
}
