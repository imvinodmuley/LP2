package Quiz;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.geom.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class SignUp extends JFrame { 	

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfPassword;
	private JTextField txtMobileno;
	private JTextField txtLanguage;		
	private JLabel lblLogin;
	private JLabel lblvalidate;
	@SuppressWarnings("unused")
	private String imgPath = "";
	private LogIn LogInObj;
	private JLabel lblvalidateUsername;
	private JLabel lblvalidatePassword;
	private JLabel lblvalidateConfPassword;
	private JLabel lblvalidateMobileNo;
	private String userCategory;
	private JButton btnSignup;
	public SignUp(final String userCategory) {
		LogInObj = new LogIn(userCategory);
		setTitle("It's Quiz Time - Sign Up");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.userCategory = userCategory;
		lblLogin = new JLabel("Already a User ? Log In");
		lblLogin.setToolTipText("Click To Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogin.setForeground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				LogInObj.setVisible(true);
				LogInObj.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		
		lblvalidate = new JLabel("Invalid");
		lblvalidate.setForeground(Color.RED);
		lblvalidate.setHorizontalAlignment(SwingConstants.CENTER);
		lblvalidate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblvalidate.setBounds(350, 281, 52, 20);
		lblvalidate.setVisible(false);
		
		
				lblvalidateUsername = new JLabel("UserName must be 8 or greater than 8 Character");
				lblvalidateUsername.setForeground(Color.WHITE);
				lblvalidateUsername.setHorizontalAlignment(SwingConstants.CENTER);
				lblvalidateUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
				lblvalidateUsername.setBounds(118, 138, 303, 20);
				lblvalidateUsername.setVisible(false);
				
				lblvalidatePassword = new JLabel("Password must be 8 or greater than 8 Character");
				lblvalidatePassword.setForeground(Color.WHITE);
				lblvalidatePassword.setHorizontalAlignment(SwingConstants.CENTER);
				lblvalidatePassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
				lblvalidatePassword.setBounds(118, 195, 303, 20);
				lblvalidatePassword.setVisible(false);
				
				lblvalidateConfPassword = new JLabel("Password not matched reenter Password");
				lblvalidateConfPassword.setForeground(Color.WHITE);
				lblvalidateConfPassword.setHorizontalAlignment(SwingConstants.CENTER);
				lblvalidateConfPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
				lblvalidateConfPassword.setBounds(99, 248, 303, 20);
				lblvalidateConfPassword.setVisible(false);
				
				lblvalidateMobileNo = new JLabel("Please Enter 10 Digit Mobile Number");
				lblvalidateMobileNo.setForeground(Color.WHITE);
				lblvalidateMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
				lblvalidateMobileNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
				lblvalidateMobileNo.setBounds(87, 312, 303, 20);
				lblvalidateMobileNo.setVisible(false);
				contentPane.add(lblvalidateMobileNo);
				contentPane.add(lblvalidateConfPassword);
				contentPane.add(lblvalidatePassword);
				contentPane.add(lblvalidateUsername);
		contentPane.add(lblvalidate);
		
	//	lblLogin.setForeground(Color.WHITE);
		//lblLogin.setFont(new Font("Castellar", Font.BOLD, 13));
		//lblLogin.setBounds(130, 380, 219, 26);
		//contentPane.add(lblLogin);
		
		btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table = "login";
				if(userCategory.equals("admin"))
					table = "adminlogin";
				else
					table = "login";
				
				if(userSignUp(table)) {
					LogInObj.setVisible(true);
					LogInObj.setLocationRelativeTo(null);
					setVisible(false);
				}
				
			}
		});
		btnSignup.setBackground(Color.WHITE);
		btnSignup.setForeground(Color.BLUE);
		btnSignup.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		//btnSignup.setBounds(164, 336, 140, 33);
		contentPane.add(btnSignup);
		
		txtMobileno = new JTextField(){
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
		txtMobileno.setText("Enter Mobile Number"); //place holder
		txtMobileno.setForeground(Color.GRAY);
		
		txtMobileno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMobileno.getText().equals("Enter Mobile Number")) {
					txtMobileno.setText("");
					txtMobileno.setForeground(Color.BLACK);
				}
				if(txtMobileno.getText().length() < 10 || txtMobileno.getText().length() > 10 )
				{
					lblvalidateMobileNo.setVisible(true);
				}
				else {
					lblvalidateMobileNo.setVisible(false);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMobileno.getText().equals("")) {
					txtMobileno.setText("Enter Mobile Number");
					txtMobileno.setForeground(Color.GRAY);
				}
				if(txtMobileno.getText().length() < 10 || txtMobileno.getText().length() > 10 )
				{
					lblvalidateMobileNo.setVisible(true);
				}
				else {
					lblvalidateMobileNo.setVisible(false);
				}
			}
			
		});
		 txtMobileno.setToolTipText("Mobile Number");
		txtMobileno.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtMobileno.setColumns(10);
		txtMobileno.setBounds(130, 275, 210, 33);
		contentPane.add(txtMobileno);
		
		txtLanguage = new JTextField(){
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
		adminAddField();
		
		txtConfPassword = new JPasswordField(){
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
		txtConfPassword.setText("ReEnter Password"); //place holder
		
		txtConfPassword.setForeground(Color.GRAY);
		txtConfPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtConfPassword.getText().equals("ReEnter Password")) {
					txtConfPassword.setText("");
					txtConfPassword.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtConfPassword.getText().equals("")) {
					txtConfPassword.setText("ReEnter Password");
					txtConfPassword.setForeground(Color.GRAY);
				}
			}
			
		});
		txtConfPassword.setToolTipText("Confirm Password");
		txtConfPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtConfPassword.setColumns(10);
		txtConfPassword.setBounds(130, 216, 210, 33);
		contentPane.add(txtConfPassword);
		
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
		txtPassword.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("ReEnter Password")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.BLACK);
				}
				if(txtPassword.getText().length() < 8 )
				{
					lblvalidatePassword.setVisible(true);
				}
				else {
					lblvalidatePassword.setVisible(false);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("ReEnter Password");
					txtPassword.setForeground(Color.GRAY);	
				}
				if(txtPassword.getPassword().toString().length() < 8 )
				{
					lblvalidatePassword.setVisible(true);
				}
				else {
					lblvalidatePassword.setVisible(false);
				}
				
			}
			
		});
		txtPassword.setToolTipText("Password");
		txtPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(130, 161, 210, 33);
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
				
		
		txtUsername.setText("Enter UserName"); //place holder
		txtUsername.setForeground(Color.GRAY);
		
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(txtUsername.getText().equals("Enter UserName")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.BLACK);
					}
				
				if(txtUsername.getText().length() < 8 )
				{
					lblvalidateUsername.setVisible(true);
				}
				else if(txtUsername.getText().length() >= 8 ) {
					lblvalidateUsername.setVisible(false);
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Enter UserName");
					txtUsername.setForeground(Color.GRAY);
				}
				
				if(txtUsername.getText().length() < 8 )
				{
					lblvalidateUsername.setVisible(true);
				}
				else if(txtUsername.getText().length() >= 8 ) {
					lblvalidateUsername.setVisible(false);
				}
			}
			
			
		});
		txtUsername.setToolTipText("UserName");
		txtUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		txtUsername.setBounds(130, 106, 210, 33);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Castellar", Font.BOLD, 13));
		//lblLogin.setBounds(130, 380, 219, 26);
		contentPane.add(lblLogin);
		
		JLabel lblSignup = new JLabel("Sign Up");
		lblSignup.setBackground(Color.WHITE);
		lblSignup.setFocusable(true);
		lblSignup.setForeground(Color.WHITE);
		lblSignup.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblSignup.setBounds(178, 47, 108, 45);
		contentPane.add(lblSignup);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBackground.setIcon(new ImageIcon(SignUp.class.getResource("/images/SignupBackground.jpg")));
		lblBackground.setBounds(0, 0, 500, 500);
		contentPane.add(lblBackground);
	}
	
	public void setUserName(String s) {
		txtUsername.setText(s);
	}
	
	public void setMobileNo(String s) {
		txtMobileno.setText(s);
	}
	
	public void setPassword(String s) {
		txtPassword.setText(s);
	}
	
	public void setConfPassword(String s) {
		txtConfPassword.setText(s);
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
	
	public boolean userSignUp(String table)
	{
		DBConnection dbc= new DBConnection(); 
		Connection con = dbc.conn();
		String username = txtUsername.getText();
		String mobileNo = txtMobileno.getText();
		String password = new String(txtPassword.getPassword());
		String pass = generate(password);
		if(isValidData()) {
		try {

			PreparedStatement stmt;
			if(userCategory.equals("user"))
			{
				stmt=con.prepareStatement("insert into quiz."+table+" (username,password,mobile) values (?,?,?)");  
				stmt.setString(1,username);  
				stmt.setString(2,pass);
				stmt.setString(3,mobileNo);
			}
			else {
				stmt=con.prepareStatement("insert into quiz."+table+" (username,password,mobile,language) values (?,?,?,?)");  
				stmt.setString(1,username);  
				stmt.setString(2,pass);
				stmt.setString(3,mobileNo);
				stmt.setString(4,txtLanguage.getText());
			}
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			//con.close();  
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
		if(lblvalidate.isVisible()|| lblvalidateUsername.isVisible()|| lblvalidatePassword.isVisible()
		   ||((txtPassword.getText().equals(txtConfPassword.getText())==false))||lblvalidateMobileNo.isVisible()) {
			lblvalidateConfPassword.setVisible(true);
		return false;
		}
		else {
			lblvalidateConfPassword.setVisible(false);
		return true;
		}
	}
	public void adminAddField() {
		  if(userCategory.equals("admin")) {
						txtLanguage.setText("Programming Language"); //place holder
						txtLanguage.setForeground(Color.GRAY);
						txtLanguage.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if(txtLanguage.getText().equals("Programming Language")) {
							txtLanguage.setText("");
							txtLanguage.setForeground(Color.BLACK);
							}
					}
					@Override
					public void focusLost(FocusEvent e) {
						if(txtLanguage.getText().equals("")) {
							txtLanguage.setText("Programming Language");
							txtLanguage.setForeground(Color.GRAY);
						}
					}
					
					
				});
				txtLanguage.setToolTipText("Language(cpp,java,sql)");
				txtLanguage.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
				txtLanguage.setBounds(130, 335, 210, 33);
				contentPane.add(txtLanguage);
				txtLanguage.setColumns(10);
				
				btnSignup.setBounds(164, 390, 140, 33);
				lblLogin.setBounds(131, 425, 219, 26);
		  }
		  else {
			  	btnSignup.setBounds(164, 336, 140, 33);
				lblLogin.setBounds(130, 380, 219, 26);
		  }
	}
	
	
}


class RoundedCornerBorder extends AbstractBorder {
	  /**
	 * Round Corner of text field or button
	 */
	private static final long serialVersionUID = 1L;
	private static final Color ALPHA_ZERO = new Color(0x0, true);
	  @Override 
	  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	    Graphics2D g2 = (Graphics2D) g.create();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    Shape border = getBorderShape(x, y, width - 1, height - 1);
	    g2.setPaint(ALPHA_ZERO);
	    Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
	    corner.subtract(new Area(border));
	    g2.fill(corner);
	    g2.setPaint(Color.GRAY);
	    g2.draw(border);
	    g2.dispose();
	  }
	  public Shape getBorderShape(int x, int y, int w, int h) {
	    int r = h; //h / 2;
	    return new RoundRectangle2D.Double(x, y, w, h, r, r);
	  }
	  @Override 
	  public Insets getBorderInsets(Component c) {
	    return new Insets(4, 8, 4, 8);
	  }
	  @Override 
	  public Insets getBorderInsets(Component c, Insets insets) {
	    insets.set(4, 8, 4, 8);
	    return insets;
	  }
	}



