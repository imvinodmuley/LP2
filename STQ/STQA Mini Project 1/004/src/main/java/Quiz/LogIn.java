package Quiz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

//import sun.nio.cs.UnicodeEncoder;

import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class LogIn extends JFrame {
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblvalidUserPass;
	@SuppressWarnings("unused")
	private JLabel lblvalidate;
	@SuppressWarnings("unused")
	private JLabel lblLogin;
	int uid=0;
	String username=null,mobile = null;
	private JLabel lblSignUp;
	private JLabel lblForgotPassword;
	private JLabel lblForgetpanel;
	private JTextField txtEnterMobileNo;
	private JButton btnLogin;
	private JLabel lblvalidateMobileNo;
	private JLabel lblSetPasswpanel;
	private JPasswordField txtResetPassword;
	private JPasswordField txtResetConfPassword;
	private JLabel lblvalidateConfPassword;
	private String userCategory;
	
	
	public LogIn(final String userCategory) {
		this.userCategory = userCategory;
		setTitle("It's Quiz Time - Log In");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblvalidUserPass = new JLabel("Please Enter Correct Username or Password");
		//lblvalidUserPass.setOpaque(true);
		lblvalidUserPass.setForeground(Color.white);
		lblvalidUserPass.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblvalidUserPass.setBounds(113, 361, 268, 20);
		lblvalidUserPass.setVisible(false);
		
		lblForgetpanel = new JLabel("");
		lblForgetpanel.setBounds(134, 183, 224, 103);
		lblForgetpanel.setVisible(false);
		contentPane.add(lblForgetpanel);
		
		lblSetPasswpanel = new JLabel("");
		lblSetPasswpanel.setBounds(134, 183, 224, 200);
		lblSetPasswpanel.setVisible(false);
		contentPane.add(lblSetPasswpanel);
		
		
		contentPane.add(lblvalidUserPass);
		
		lblSignUp = new JLabel("Not a User ? Sign Up");
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Castellar", Font.BOLD, 13));
		lblSignUp.setBounds(160,343,174,16);
		lblSignUp.setVisible(true);
		contentPane.add(lblSignUp);
		lblSignUp.setToolTipText("Click To SignUp");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setForeground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp signup = new SignUp(userCategory);
				signup.setVisible(true);
				signup.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		lblForgotPassword = new JLabel("Forgot Password ?");
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setFont(new Font("Castellar", Font.BOLD, 11));
		lblForgotPassword.setBounds(205,267,153,16);
		lblForgotPassword.setVisible(true);
		contentPane.add(lblForgotPassword);
		lblForgotPassword.setToolTipText("Click To SignUp");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblForgotPassword.setForeground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblForgotPassword.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblForgetpanel.setVisible(true);
				txtPassword.setVisible(false);
				txtUsername.setVisible(false);
				btnLogin.setVisible(false);
				lblSignUp.setVisible(false);
				lblForgotPassword.setVisible(false);
			}
		});
		
		 btnLogin = new JButton("Log In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(loggedIn()){
					if(userCategory.equals("admin"))
					{
						System.out.println("Admin Login SuccessFull");
						Admin admin = new Admin(uid);
						admin.setVisible(true);
						admin.setLocationRelativeTo(null);
						dispose();
					}
					else {
						System.out.println("User Login SuccessFull");
						Dashborad1 Dash=new Dashborad1(uid,username,mobile);
						Dash.setVisible(true);
						Dash.setLocationRelativeTo(null);
						setVisible(false);
						}
					}
			}
			});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnLogin.setBounds(175, 299, 140, 33);
		contentPane.add(btnLogin);
		
		txtPassword = new JPasswordField(){
			  @Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
		txtPassword.setText("ReEnter Password"); //place holder
		txtPassword.setForeground(Color.GRAY);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("ReEnter Password")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("ReEnter Password");
					txtPassword.setForeground(Color.GRAY);
				}
			}
			
		});
		txtPassword.setToolTipText("Password");
		txtPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(138, 234, 210, 33);
		contentPane.add(txtPassword);
		
		txtUsername = new JTextField(){
			  @Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
		txtUsername.setText("Enter UserName"); //place holder.
		
		txtUsername.setForeground(Color.GRAY);
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Enter UserName")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Enter UserName");
					txtUsername.setForeground(Color.GRAY);
				}
			}		
		});
		txtUsername.setToolTipText("UserName");
		txtUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtUsername.setBounds(138, 183, 210, 33);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		JLabel lblLogin = new JLabel("Log In");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFocusable(true);
		lblLogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblLogin.setBounds(200, 137, 79, 29);
		contentPane.add(lblLogin);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBackground.setIcon(new ImageIcon(SignUp.class.getResource("/images/SignupBackground.jpg")));
		lblBackground.setBounds(0, 0, 500, 500);
		contentPane.add(lblBackground);
		
		txtEnterMobileNo = new JTextField();
		txtEnterMobileNo.setToolTipText("Enter Mobile No");
		//txtEnterMobileNo.setText("Enter Mobile No");
		txtEnterMobileNo.setForeground(Color.GRAY);
		txtEnterMobileNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtEnterMobileNo.setColumns(10);
		txtEnterMobileNo.setBounds(0,0,210,33);
		txtEnterMobileNo.setText("Enter Mobile No"); //place holder.
		
		txtEnterMobileNo.setForeground(Color.GRAY);
		txtEnterMobileNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterMobileNo.getText().equals("Enter Mobile No")) {
					txtEnterMobileNo.setText("");
					txtEnterMobileNo.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterMobileNo.getText().equals("")) {
					txtEnterMobileNo.setText("Enter Mobile No");
					txtEnterMobileNo.setForeground(Color.GRAY);
				}
			}		
		});
		lblForgetpanel.add(txtEnterMobileNo);
		
		JButton btnSubmitMob = new JButton("Submit");
		btnSubmitMob.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(validateMobile())
				{
					//lblResetPassword.setVisible(true);
					lblSetPasswpanel.setVisible(true);
					lblForgetpanel.setVisible(false);
			}
			}
		});
		btnSubmitMob.setForeground(Color.BLUE);
		btnSubmitMob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnSubmitMob.setBackground(Color.WHITE);
		btnSubmitMob.setBounds(30,60,150,29);
		lblForgetpanel.add(btnSubmitMob);
		
		lblvalidateMobileNo = new JLabel("Please Enter 10 Digit Mobile Number");
		lblvalidateMobileNo.setForeground(Color.WHITE);
		lblvalidateMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblvalidateMobileNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblvalidateMobileNo.setBounds(0,35,210,20);
		lblForgetpanel.add(lblvalidateMobileNo);
		lblvalidateMobileNo.setVisible(false);
		txtEnterMobileNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterMobileNo.getText().equals("Enter Mobile Number")) {
					txtEnterMobileNo.setText("");
					txtEnterMobileNo.setForeground(Color.BLACK);
				}
				if(txtEnterMobileNo.getText().length() < 10 || 	txtEnterMobileNo.getText().length() > 10 )
				{
					lblvalidateMobileNo.setVisible(true);
				}
				else {
					lblvalidateMobileNo.setVisible(false);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterMobileNo.getText().equals("")) {
					txtEnterMobileNo.setText("Enter Mobile Number");
					txtEnterMobileNo.setForeground(Color.GRAY);
				}
				if(txtEnterMobileNo.getText().length() < 10 || txtEnterMobileNo.getText().length() > 10 )
				{
					lblvalidateMobileNo.setVisible(true);
				}
				else {
					lblvalidateMobileNo.setVisible(false);
				}
			}
			
		});
		
		//SetPasswordPanel
		txtResetPassword = new JPasswordField();
		txtResetPassword.setToolTipText("Enter Password");
		txtResetPassword.setForeground(Color.GRAY);
		txtResetPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtResetPassword.setBounds(0,0,210,33);
		txtResetPassword.setText("Enter Mobile No"); //place holder.
		
		txtResetPassword.setForeground(Color.GRAY);
		txtResetPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtResetPassword.getText().equals("Enter Mobile No")) {
					txtResetPassword.setText("");
					txtResetPassword.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtResetPassword.getText().equals("")) {
					txtResetPassword.setText("Enter Mobile No");
					txtResetPassword.setForeground(Color.GRAY);
				}
			}		
		});
		lblSetPasswpanel.add(txtResetPassword);
		JButton btnSubmitPass = new JButton("Submit");
		btnSubmitPass.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(validatePass())
				{
					//lblResetPassword.setVisible(true);
					JOptionPane jop = new JOptionPane();
					jop.showConfirmDialog(jop, "Yo Pass Submitted", "Error", jop.DEFAULT_OPTION, jop.WARNING_MESSAGE);
					LogIn login = new LogIn(userCategory);
					login.setVisible(true);
					dispose();				
				}
				else {
					JOptionPane jop = new JOptionPane();
					jop.showConfirmDialog(jop, "Yo Pass Not Submitted", "Error", jop.DEFAULT_OPTION, jop.WARNING_MESSAGE);
					
				}
			}
		});
		btnSubmitPass.setForeground(Color.BLUE);
		btnSubmitPass.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnSubmitPass.setBackground(Color.WHITE);
		btnSubmitPass.setBounds(30,113,150,29);
		lblSetPasswpanel.add(btnSubmitPass);
		
		txtResetConfPassword = new JPasswordField();
		txtResetConfPassword.setText("ReEnter Password"); //place holder
		txtResetConfPassword.setForeground(Color.GRAY);
		txtResetConfPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtResetConfPassword.getText().equals("ReEnter Password")) {
					txtResetConfPassword.setText("");
					txtResetConfPassword.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtResetConfPassword.getText().equals("")) {
					txtResetConfPassword.setText("ReEnter Password");
					txtResetConfPassword.setForeground(Color.GRAY);
				}
			}
			
		});
		txtResetConfPassword.setToolTipText("Confirm Password");
		txtResetConfPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtResetConfPassword.setBounds(0, 53, 210, 33);
		lblSetPasswpanel.add(txtResetConfPassword);
		
		lblvalidateConfPassword = new JLabel("Password not matched reenter Password");
		lblvalidateConfPassword.setForeground(Color.WHITE);
		lblvalidateConfPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblvalidateConfPassword.setBounds(0, 88, 350, 20);
		lblvalidateConfPassword.setVisible(false);
		lblSetPasswpanel.add(lblvalidateConfPassword);

	}
	
	public void setUsername(String s) {
		txtUsername.setText(s);
	}
	
	public void setPass(String s) {
		txtPassword.setText(s);
	}
	
	public void setMobileNo(String s) {
		txtEnterMobileNo.setText(s);
	}
	
	public void setResetPassword(String s) {
		txtResetPassword.setText(s);
	}
	
	public void setResetConfPassword(String s) {
		txtResetConfPassword.setText(s);
	}
	
	public JLabel getForgetPanel() {
		return lblForgetpanel;
	}
	
	public String generate(String s)
	{
		String s1="",s2="";
		for(int i=0;i<s.length();i++)
		{
				int a=(int) s.charAt(i);
				s2=String.valueOf(a);
				s1+=s2;
		}
		return s1;
	}
public boolean loggedIn()
{
		DBConnection dbc = new DBConnection();
		Connection con = dbc.conn();
		username = txtUsername.getText();
		String password = new String(txtPassword.getPassword());
		String pass =generate(password);
		String table = "login";
		if(userCategory.equals("admin"))
			table = "adminlogin";
		else
			table = "login";
		try {
			PreparedStatement stmt=con.prepareStatement("select id,username,password,mobile from "+table+" where username=? and password=?");
			stmt.setString(1,username);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{	
				if(username.equals(rs.getString(2)) && pass.equals(rs.getString(3)))
				{
					uid=rs.getInt(1);
					username=rs.getString(2);
					mobile = rs.getString(4);
					System.out.println(uid);
					lblvalidUserPass.setVisible(false);
				return true;
				}
			}
			//lblvalidUserPass.setVisible(true);
			JOptionPane jop = new JOptionPane("Enter Correct Username or Password",1,2);
			jop.showConfirmDialog(jop, "Enter Correct Username or Password", "Error", jop.DEFAULT_OPTION, jop.WARNING_MESSAGE);
			/*jop.WARNING_MESSAGE;
			jop.showMessageDialog(jop,"Enter Correct Username or Password");
			*/
			
			con.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
}
		
		public boolean validateMobile(){
			DBConnection dbc = new DBConnection();
			Connection con = dbc.conn();
			String mobno = "";
			try {
				PreparedStatement stmt=con.prepareStatement("select mobile from login where mobile=?");
				stmt.setString(1,txtEnterMobileNo.getText());
				//stmt.setString(2,pass);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{	
						mobno=rs.getString(1);
						System.out.println(mobno);
				}
				if(mobno.equals(""))
				{
					JOptionPane jop = new JOptionPane();
					jop.showConfirmDialog(jop, "Enter Correct Username or Password", "Error", jop.DEFAULT_OPTION, jop.WARNING_MESSAGE);
					//con.close();
					return false;
				}
				else
				{
					//con.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
		}
	
		}
		
		public boolean validatePass() {
			DBConnection dbc= new DBConnection(); 
			Connection con = dbc.conn();
			String password = new String(txtResetPassword.getPassword());
			System.out.println(password);
			String pass = generate(password);
			if(isValidData()) {
			try {
				PreparedStatement stmt=con.prepareStatement("update login set password = ? where mobile = ?");  
				stmt.setString(1,pass);
				stmt.setString(2, txtEnterMobileNo.getText());
		  
				int i=stmt.executeUpdate();  
				System.out.println(i+" records inserted");  
				con.close();  
				return true;  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false; 
			}
			}
			else {
				//DO Nothing
				return false;
			}
		}
		
		public boolean isValidData() { 
			System.out.println(txtResetPassword.getText());
			System.out.println(txtResetConfPassword.getText());
			if(!(txtResetPassword.getText().equals(txtResetConfPassword.getText()))) {
				lblvalidateConfPassword.setVisible(true);
				return false;
			}
			else {
				lblvalidateConfPassword.setVisible(false);
			return true;
			}
		}
}
