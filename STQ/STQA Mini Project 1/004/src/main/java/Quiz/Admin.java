package Quiz;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Admin extends JFrame 
{

	private JPanel contentPane;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField ans;
	private JTextPane textPane;
	private JLabel lblimage;
	private JLabel lblEnableTest;
	private JLabel lblNewLabel;
	private JTextField txtMin;
	private JTextField txtSec;
	private JTextField textField;
	private JLabel lblActivate;
	private JLabel lblacttxt;
	private JLabel lblNoOfQuest;
	private JLabel lblNoOfQuestion;
	private JLabel lblDuration_1;
	private JLabel lblDuration;
	private JLabel lblmockback;
	private JLabel lblClear;
	private JLabel lblClear_1;
	boolean fl=false;
	private JTextPane txtpnNoteClear;
	JOptionPane jop = new JOptionPane();
	private JLabel lblUploadtxt;
	private JLabel lblortxt;
	private JLabel lblor;
	private JLabel lblupload;
	private int uid;
	private JLabel name;
	private JLabel subname;
	
	//TEST
	
	//private JFrame frame; //private JFrame frame; 

	//Event dispath thread manages the starting of the program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin(1);
					window.setVisible(true);
					window.setTitle("It's Quiz Time");
					window.setResizable(false);
					window.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//TEST END
	public void checkrecenttest()
	{
		DBConnection conn=new DBConnection();
 		Connection con=conn.conn();
 		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("Delete from quiz.cppmockque");
				stmt.executeUpdate();
				stmt = con.prepareStatement("Delete from quiz.cppmockans");
				stmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Admin(int id)
	{
		uid = id; 
		setTitle("ADMIN");
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		 //contentPane.add(lblDuration);
		 
		 
		 lblimage = new JLabel("");
		 lblimage.setIcon(new ImageIcon(Admin.class.getResource("/images/circle-cropped(3).png")));
		 lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		 lblimage.setBackground(Color.BLUE);
		 lblimage.setBounds(32, 306, 80, 63);
		 // contentPane.add(lblimage);
		 
		  lblEnableTest = new JLabel("ACTIVE MOCK");
		  lblEnableTest.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent arg0) 
		  	{
		  		lblmockback.setVisible(true);
		  	}	
		  });
		final JScrollPane scrollPane = new JScrollPane();
		textPane=new JTextPane();
		textPane.setFont(new Font("Calibri", Font.BOLD, 14));
		textPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textPane.getText().contentEquals("enter the question"))
				{
					textPane.setText("");
			}
			}			@Override
			public void focusLost(FocusEvent e) {
				if(textPane.getText().contentEquals(""))
				{
					textPane.setText("enter the question");
		  		 							}
		  		 							}
});
		  		 						
		textPane.setText("enter the question");
		final JLabel panel=new JLabel(new ImageIcon(Admin.class.getResource("/images/welcome1.jpg")));
		panel.setBounds(0,100,340,250);
		final JLabel lb1=new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
		final JLabel lb2=new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
		final JLabel lb3=new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
		final JLabel aname=new JLabel("Username");
		aname.setForeground(Color.BLACK);
		aname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		final JLabel sub=new JLabel("Subject");
		sub.setForeground(Color.BLACK);
		sub.setFont(new Font("Times New Roman", Font.BOLD, 20));
		aname.setBounds(20,40,150,30);
		sub.setBounds(20,90,150,30);
		final JLabel info=new JLabel(new ImageIcon(Admin.class.getResource("/images/pr2.jpg")));
		
	    name=new JLabel("Teacher Name");
		name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		name.setForeground(Color.BLUE);
		
		subname=new JLabel ("java programming");
		subname.setForeground(Color.BLUE);
		subname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		final JLabel prof = new JLabel(new ImageIcon(Admin.class.getResource("/images/p6.png")));
		prof.setBounds(95, 80, 140, 100);
		
				 info.setBounds(0,170,335,200);
				 name.setBounds(140,40,200,30);
				 subname.setBounds(140,90,200,30);
				 
				 		 
 		JLabel lblNewLabel_2= new JLabel(new ImageIcon(Admin.class.getResource("/images/pic3.jpg")));
 		lblNewLabel_2.setBounds(150, 0, 335, 460);
 		lblNewLabel_2.setForeground(Color.BLACK);
 		lblNewLabel_2.setBackground(Color.CYAN);
 		ans=new JTextField("enter the answer");
 		ans.setFont(new Font("Calibri", Font.BOLD, 14));
 		ans.addFocusListener(new FocusAdapter() {
 			@Override
 			public void focusGained(FocusEvent e) {
 				if(ans.getText().equals("enter the answer"))
 				{
 					ans.setText("");
 				}
 			}
 			@Override
 			public void focusLost(FocusEvent e) {
 				if(ans.getText().equals(""))
 				{
 					ans.setText("enter the answer");
 				}
 			}
 		});
 		ans.setBounds(50,270,210,30);
 		lblNewLabel_2.add(ans);
 		ans.setVisible(false);
 		t2=new JTextField("option 1");
 		t2.setFont(new Font("Calibri", Font.BOLD, 14));
 		t2.addFocusListener(new FocusAdapter() {
 			@Override
 			public void focusGained(FocusEvent e) {
 				if(t2.getText().equals("option 1"))
 				{
 					t2.setText("");
 				}
 			}
 			@Override
 			public void focusLost(FocusEvent e) {
 				if(t2.getText().equals(""))
 				{
 					t2.setText("option 1");
 				}
 			}
 		});
 		t2.setBounds(10,150,150,30);
 		
 		t3=new JTextField("option 2");
 		t3.setFont(new Font("Calibri", Font.BOLD, 14));
 		t3.addFocusListener(new FocusAdapter() {
 			@Override
 			public void focusGained(FocusEvent e) {
 				if(t3.getText().equals("option 2"))
 				{
 					t3.setText("");
 				}
 			}
 			@Override
 			public void focusLost(FocusEvent e) {
 				if(t3.getText().equals(""))
 				{
 					t3.setText("option 2");
 				}
 			}
 		});
 		t3.setBounds(170,150,150,30);
 		t4=new JTextField("option 3");
 		t4.setFont(new Font("Calibri", Font.BOLD, 14));
 		t4.addFocusListener(new FocusAdapter() {
 			@Override
 			public void focusGained(FocusEvent e) {
 				if(t4.getText().equals("option 3"))
 				{
 					t4.setText("");
 				}
 			}
 			@Override
 			public void focusLost(FocusEvent e) {
 				if(t4.getText().equals(""))
 				{
 					t4.setText("option 3");
 				}
 			}
 		});
 		t4.setBounds(10,210,150,30);
 		t5=new JTextField("option 4");
 		t5.setFont(new Font("Calibri", Font.BOLD, 14));
 		t5.addFocusListener(new FocusAdapter() {
 			@Override
 			public void focusGained(FocusEvent e) {
 				if(t5.getText().equals("option 4"))
 				{
 					t5.setText("");
 				}
 			}
 			@Override
 			public void focusLost(FocusEvent e) {
 				if(t5.getText().equals(""))
 				{
 					t5.setText("option 4");
 				}
 			}
 		});
 		t5.setBounds(170,210,150,30);
 		lblNewLabel_2.add(t2);
 		t2.setVisible(false);
 		lblNewLabel_2.add(t3);
 		t3.setVisible(false);
 		lblNewLabel_2.add(t4);
 		t4.setVisible(false);
 		lblNewLabel_2.add(t5);
 		t5.setVisible(false);
 		final JLabel s=new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
 		
 		
 		s.setBounds(50,350,100,30);
 		lblNewLabel_2.add(s);
 		s.setVisible(false);
 		final JLabel save = new JLabel("SUBMIT");
 		save.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				if(submitted())
 				{
 					System.out.println("inserted");
 					textPane.setText("enter the question");
 					t2.setText("option 1");
 					t3.setText("option 2");
 					t4.setText("option 3");
 					t5.setText("option 4");
 					ans.setText("enter the answer");
 					
 				}
 			}
 		});
 		save.setHorizontalAlignment(SwingConstants.CENTER);
 		save.setForeground(Color.GREEN);
 		save.setBackground(Color.WHITE);
 		save.setFont(new Font("Times New Roman", Font.BOLD, 24));
 		save.setBounds(0,0, 100, 30);
 		s.add(save);
 		final JLabel c=new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
 		c.setBounds(160,350,100,30);
 		lblNewLabel_2.add(c);
 		c.setVisible(false);
 		final JLabel cancel = new JLabel( "CANCEL");
 		cancel.setHorizontalAlignment(SwingConstants.CENTER);
 		
 		cancel.setForeground(Color.GREEN);
 		cancel.setBackground(Color.WHITE);
 		cancel.setFont(new Font("Times New Roman", Font.BOLD, 24));
 		cancel.setBounds(0,0, 100, 30);
 		c.add(cancel);
 		final JLabel d=new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
 		d.setBounds(50,350,100,30);
 		lblNewLabel_2.add(d);
 		d.setVisible(false);
 		
 		final JLabel u=new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
			 		u.setBounds(50,350,100,30);
			 		lblNewLabel_2.add(u);
			 		u.setVisible(false);
							 		
							 				
final JLabel l2=new JLabel("DELETE ALL ");
l2.setHorizontalAlignment(SwingConstants.CENTER);
final JLabel l3=new JLabel("UPLOAD NOTES");
l3.setHorizontalAlignment(SwingConstants.CENTER);
final JLabel l1=new JLabel(" ADD QUESTION");
l1.setHorizontalAlignment(SwingConstants.CENTER);
l1.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		lblor.setVisible(true);
		lblortxt.setVisible(true);
		lblupload.setVisible(true);
		lblUploadtxt.setVisible(true);
		
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		textPane.setVisible(true);
		t2.setVisible(true);
		t3.setVisible(true);
		t4.setVisible(true);
		t5.setVisible(true);
		scrollPane.setVisible(true);
		s.setVisible(true);
		save.setVisible(true);
		c.setVisible(true);
		cancel.setVisible(true);
		
		ans.setVisible(true);
		
		panel.setVisible(false);
		aname.setVisible(false);
		sub.setVisible(false);
		name.setVisible(false);
		subname.setVisible(false);
		prof.setVisible(false);
		lb1.setVisible(false);
		lb2.setVisible(false);
		lb3.setVisible(false);
		//lb4.setVisible(false);
		info.setVisible(false);
	}
});
l2.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		JOptionPane jop =new JOptionPane();		
		if(jop.showConfirmDialog(jop,"Are you Sure?","Warning",jop.YES_NO_OPTION)== jop.YES_OPTION)
{
	System.out.println("Yes Deleted");
	//deleted();
}
else
{
	System.out.println("No");
		}
	}
});
l3.addMouseListener(new MouseAdapter() 
{
	@Override
	public void mouseClicked(MouseEvent e) {
				savefile svf =  new savefile();
				svf.saveFiles();
	}
});

		l1.setBounds(0,0,200,30);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
l1.setForeground(Color.GREEN);

l1.setVisible(false);

lb1.setBounds(80,120,200,30);
lb1.add(l1);
lblNewLabel_2.add(lb1);
lb1.setVisible(false);

	l2.setBounds(0,0,200,30);
	l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
l2.setForeground(Color.GREEN);

l2.setVisible(false);
lb2.setBounds(80,180,200,30);
lb2.add(l2);
lblNewLabel_2.add(lb2);
lb2.setVisible(false);

l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
l3.setForeground(Color.GREEN);

l3.setVisible(false);
l3.setBounds(0,0,200,30);
lb3.setBounds(80,240,200,30);
lb3.add(l3);
lblNewLabel_2.add(lb3);
lb3.setVisible(false);
cancel.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		lblor.setVisible(false);
		lblortxt.setVisible(false);
		lblupload.setVisible(false);
		lblUploadtxt.setVisible(false);
	
		l1.setVisible(true);
		l2.setVisible(true);
		l3.setVisible(true);
		//l4.setVisible(true);
		textPane.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		t4.setVisible(false);
		t5.setVisible(false);
		scrollPane.setVisible(false);
		s.setVisible(false);
		save.setVisible(false);
		c.setVisible(false);
		cancel.setVisible(false);
		d.setVisible(false);
		//delete.setVisible(true);
		u.setVisible(false);
		//update.setVisible(false);
		
		panel.setVisible(false);ans.setVisible(false);
		lb1.setVisible(true);
		lb2.setVisible(true);
		lb3.setVisible(true);
		//lb4.setVisible(true);
		aname.setVisible(false);
		sub.setVisible(false);
		name.setVisible(false);
		subname.setVisible(false);
		prof.setVisible(false);
		info.setVisible(false);
		
	}
});
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				LogIn login = new LogIn("admin");
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setIcon(new ImageIcon(Admin.class.getResource("/images/logout_1 (1).jpg")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label.setBounds(407, 11, 77, 28);
		contentPane.add(label);

 //contentPane.add(txtpnNoteClear);

		lblmockback = new JLabel("");
		lblmockback.setBounds(150, 0, 335, 472);
		lblmockback.setIcon(new ImageIcon(Admin.class.getResource("/images/back_image.jpg")));
		contentPane.add(lblmockback);
		
		txtpnNoteClear = new JTextPane();
		txtpnNoteClear.setEditable(false);
		txtpnNoteClear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtpnNoteClear.setForeground(Color.BLACK);
		txtpnNoteClear.setText("NOTE :- If You have to Activate new Mock test , then clear the previous one first , if present.");
		txtpnNoteClear.setBounds(176-150, 390, 278, 60);
		lblmockback.add(txtpnNoteClear);
		
		lblClear_1 = new JLabel("CLEAR");
		
		 lblClear_1.addMouseListener(new MouseAdapter() 
		 {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) 
		 	{
		 		DBConnection conn=new DBConnection();
		 		Connection con=conn.conn();
		 		PreparedStatement stmt;
				try {
					stmt = con.prepareStatement("Delete from quiz.cppmockque");
					stmt.executeUpdate();
					stmt=con.prepareStatement("update quiz.login set status=0");
					stmt.executeUpdate();
												} 
							catch (SQLException e) 
							{
								// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jop.showConfirmDialog(jop, "No Active Test Left ,You can Create New Test Now","Success", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);	
		 	}
		 });
		 lblClear_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblClear_1.setForeground(Color.RED);
		 lblClear_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 lblClear_1.setBounds(324-150, 299, 73, 41);
		 lblmockback.add(lblClear_1);
		 //contentPane.add(lblClear_1);
		 
		 lblClear = new JLabel("CLEAR");
		 lblClear.setIcon(new ImageIcon(Admin.class.getResource("/images/013 Heavy Rain.png")));
		 lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		 lblClear.setForeground(Color.RED);
		 lblClear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 lblClear.setBounds(324-150, 299, 73, 41);
		 lblmockback.add(lblClear);
		 //contentPane.add(lblClear);
		 lblActivate = new JLabel("ACTIVATE");
		 //contentPane.add(lblActivate);
		 lblActivate.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) 
		 	{
		 		DBConnection conn=new DBConnection();
		 		Connection con=conn.conn();
		 		try 
		 		{
		 			checkrecenttest();	
		 			if(!(txtMin.getText().equals("MIN") || txtMin.getText().equals("") || textField.getText().equals("")) )
		 			{
		 			
		 				if(activateMock())
		 				jop.showConfirmDialog(jop, "Mock Test Activated", "Success", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
		 			
		 			}
		 			else
		 			{
		 				
		 				jop.showConfirmDialog(jop, "Invalid credentials", "Error", jop.DEFAULT_OPTION, jop.WARNING_MESSAGE);
		 			}
		 		txtMin.setText("");
		 		txtSec.setText("");
		 		textField.setText("");
		 		} 
		 		catch (SQLException e) 
		 		{
		 			e.printStackTrace();
		 		}
		 	}
		 });
		 lblActivate.setForeground(Color.RED);
		 lblActivate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 lblActivate.setHorizontalAlignment(SwingConstants.CENTER);
		 lblActivate.setBounds(204-150, 299, 98, 41);
		 lblmockback.add(lblActivate);
		 //contentPane.add(lblActivate);
		 
		 lblacttxt = new JLabel("NO OF QUESTION");
		 //contentPane.add(lblacttxt);
		 lblacttxt.setIcon(new ImageIcon(Admin.class.getResource("/images/013 Heavy Rain.png")));
		 lblacttxt.setHorizontalAlignment(SwingConstants.CENTER);
		 lblacttxt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 lblmockback.add(lblacttxt);
		 lblacttxt.setBounds(204-150, 299, 98, 41);
		 
		 textField = new JTextField();
		 textField.setHorizontalAlignment(SwingConstants.CENTER);
		 textField.setForeground(Color.GRAY);
		 textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 textField.setColumns(10);
		 textField.setBounds(326-150, 217, 48, 42);
		 lblmockback.add(textField);
		 //contentPane.add(textField);
		 
		 lblNoOfQuest = new JLabel("NO. OF QUEST.");
		 lblNoOfQuest.setForeground(Color.WHITE);
		 lblNoOfQuest.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 lblNoOfQuest.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoOfQuest.setBounds(184-150, 217, 108, 41);
		 lblmockback.add(lblNoOfQuest);
		 //contentPane.add(lblNoOfQuest);
		 
		  lblNoOfQuestion = new JLabel("NO OF QUESTION");
		  lblNoOfQuestion.setIcon(new ImageIcon(Admin.class.getResource("/images/SignupBackground.jpg")));
		  lblNoOfQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNoOfQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  lblNoOfQuestion.setBounds(184-150, 217, 108, 41);
		  lblmockback.add(lblNoOfQuestion);
		  //contentPane.add(lblNoOfQuestion);
		  
		  lblDuration_1 = new JLabel("DURATION");
		  lblDuration_1.setForeground(Color.WHITE);
		  lblDuration_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  lblDuration_1.setHorizontalAlignment(SwingConstants.CENTER);
		  lblDuration_1.setBounds(184-150, 145, 108, 41);
		  lblmockback.add(lblDuration_1);
		  //contentPane.add(lblDuration_1);
		  
		  txtSec = new JTextField();
		  txtSec.addFocusListener(new FocusAdapter() {
		  	@Override
		  	public void focusGained(FocusEvent arg0) 
		  	{
		  		if(txtSec.getText().equals("SEC"))
		  		{
		  			txtSec.setText("");
		  		}
		  	}
		  	@Override
		  	public void focusLost(FocusEvent arg0) 
		  	{
		  		if(txtSec.getText().equals(""))
		  		{
		  			txtSec.setText("SEC");
		  		}	
		  	}
		  });
		  txtSec.setForeground(Color.GRAY);
		  txtSec.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  txtSec.setHorizontalAlignment(SwingConstants.CENTER);
		  txtSec.setText("SEC");
		  txtSec.setColumns(10);
		  txtSec.setBounds(384-150, 145, 48, 42);
		  lblmockback.add(txtSec);
		  //contentPane.add(txtSec);
		  
		  txtMin = new JTextField();
		  txtMin.addFocusListener(new FocusAdapter() {
		  	@Override
		  	public void focusGained(FocusEvent arg0) 
		  	{
		  		if(txtMin.getText().equals("MIN"))
		  		{
		  			txtMin.setText("");
		  		}		  		
		  	}
		  	@Override
		  	public void focusLost(FocusEvent arg0) 
		  	{
		  		if(txtMin.getText().equals(""))
		  		{
		  			txtMin.setText("MIN");
		  		}	
		  	}
		  });
		  txtMin.setHorizontalAlignment(SwingConstants.CENTER);
		  txtMin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  txtMin.setForeground(Color.GRAY);
		  txtMin.setText("MIN");
		  txtMin.setBounds(321-150, 145, 53, 42);
		  lblmockback.add(txtMin);
		  //contentPane.add(txtMin);
		  txtMin.setColumns(10);
		  
		   lblDuration = new JLabel("Duration:");
		   lblDuration.setIcon(new ImageIcon(Admin.class.getResource("/images/SignupBackground.jpg")));
		   lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		   lblDuration.setFont(new Font("Times New Roman", Font.BOLD, 14));
		   lblDuration.setBounds(184-150, 145, 108, 42);
		   lblmockback.add(lblDuration);
		   lblmockback.setVisible(false);
lblUploadtxt = new JLabel("UPLOAD");
lblUploadtxt.setHorizontalAlignment(SwingConstants.CENTER);
lblUploadtxt.setForeground(Color.GREEN);
lblUploadtxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
lblUploadtxt.setBackground(Color.WHITE);
lblUploadtxt.setBounds(259, 427, 103, 28);
contentPane.add(lblUploadtxt);

 lblortxt = new JLabel("OR");
lblortxt.setHorizontalAlignment(SwingConstants.CENTER);
lblortxt.setForeground(Color.WHITE);
lblortxt.setFont(new Font("Times New Roman", Font.BOLD, 24));
lblortxt.setBackground(Color.WHITE);
lblortxt.setBounds(286, 386, 45, 30);
contentPane.add(lblortxt);

lblor = new JLabel("SUBMIT");
lblor.setIcon(new ImageIcon(Admin.class.getResource("/images/back11.jpg")));
lblor.setHorizontalAlignment(SwingConstants.CENTER);
lblor.setForeground(Color.GREEN);
lblor.setFont(new Font("Times New Roman", Font.BOLD, 24));
lblor.setBackground(Color.WHITE);
lblor.setBounds(286, 386, 45, 30);
contentPane.add(lblor);

	lblupload = new JLabel("SUBMIT");
	lblupload.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			savefile_question s1=new savefile_question();
		}
	});
lblupload.setIcon(new ImageIcon(Admin.class.getResource("/images/back11.jpg")));
lblupload.setHorizontalAlignment(SwingConstants.CENTER);
lblupload.setForeground(Color.GREEN);
lblupload.setFont(new Font("Times New Roman", Font.BOLD, 24));
lblor.setVisible(false);
lblortxt.setVisible(false);
lblupload.setVisible(false);
lblUploadtxt.setVisible(false);
		 						lblupload.setBackground(Color.WHITE);
		 						lblupload.setBounds(258, 427, 103, 28);
		 						contentPane.add(lblupload);
		 						contentPane.add(lblNewLabel_2);
		 						textPane.setVisible(false);
		 						scrollPane.setVisible(false);
		 						scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		 						scrollPane.setBounds(10, 40, 320, 90);
		 						lblNewLabel_2.add(scrollPane);
		 						
		 						scrollPane.setViewportView(textPane);
		 						info.add(aname);
		 						info.add(sub);
		 						aname.setVisible(false);
		 						sub.setVisible(false);
		 						name.setVisible(false);
		 						subname.setVisible(false);
		 						prof.setVisible(false);
		 						info.add(name);
		 						info.add(subname);
		 						lblNewLabel_2.add(prof);
		 						lblNewLabel_2.add(info);
		 						info.setVisible(false);
		 						lblNewLabel_2.add(panel);
			  lblEnableTest.setFont(new Font("Times New Roman", Font.BOLD, 20));
				  lblEnableTest.setForeground(Color.GREEN);
				  lblEnableTest.setHorizontalAlignment(SwingConstants.CENTER);
				  lblEnableTest.setBounds(0, 367, 150, 45);
				  //contentPane.add(lblEnableTest);
				
			    
				  lblNewLabel = new JLabel(new ImageIcon(Admin.class.getResource("/images/image.jpg")));
				  lblNewLabel.setBounds(0, 0, 150, 500);
				  lblNewLabel.add(lblEnableTest);
				  lblNewLabel.add(lblimage);
				  contentPane.add(lblNewLabel);
				  				
				JLabel lblNewLabel_3 = new JLabel("PROFILE");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						getAdminProfile();
						lblor.setVisible(false);
						lblortxt.setVisible(false);
						lblupload.setVisible(false);
						lblUploadtxt.setVisible(false);
						
						 lblmockback.setVisible(false);
						ans.setVisible(false);
						l1.setVisible(false);
						l2.setVisible(false);
						l3.setVisible(false);
					//	l4.setVisible(false);
										panel.setVisible(false);
						textPane.setVisible(false);
						t2.setVisible(false);
						t3.setVisible(false);
						t4.setVisible(false);
						t5.setVisible(false);
						scrollPane.setVisible(false);
						s.setVisible(false);
						save.setVisible(false);
						c.setVisible(false);
						cancel.setVisible(false);
						d.setVisible(false);
					//	delete.setVisible(false);
						u.setVisible(false);
						//update.setVisible(false);
						lb1.setVisible(false);
						lb2.setVisible(false);
						lb3.setVisible(false);
						//lb4.setVisible(false);
						aname.setVisible(true);
						sub.setVisible(true);
						name.setVisible(true);
						subname.setVisible(true);
						prof.setVisible(true);
						info.setVisible(true);
					}
				});
				lblNewLabel_3.setForeground(Color.GREEN);
				lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
				lblNewLabel_3.setBounds(0, 100, 150, 40);
				lblNewLabel.add(lblNewLabel_3);
				JLabel lblNewLabel_5 = new JLabel(new ImageIcon(Admin.class.getResource("/images/pic.png")));
				lblNewLabel_5.setBounds(30, 40, 100, 70);
				lblNewLabel.add(lblNewLabel_5);
				
		
				JLabel lblNewLabel_4 = new JLabel("UPDATE");
				lblNewLabel.add(lblNewLabel_4);
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						lblor.setVisible(false);
						lblortxt.setVisible(false);
						lblupload.setVisible(false);
						lblUploadtxt.setVisible(false);
						
						lblmockback.setVisible(false);
						ans.setVisible(false);
						l1.setVisible(true);
						l2.setVisible(true);
						l3.setVisible(true);
						//l4.setVisible(true);
						panel.setVisible(false);
						textPane.setVisible(false);
						t2.setVisible(false);
						t3.setVisible(false);
						t4.setVisible(false);
						t5.setVisible(false);
						scrollPane.setVisible(false);
						s.setVisible(false);
						save.setVisible(false);
						c.setVisible(false);
						cancel.setVisible(false);
						d.setVisible(false);
						//delete.setVisible(false);
						u.setVisible(false);
						//update.setVisible(false);
						lb1.setVisible(true);
						lb2.setVisible(true);
						lb3.setVisible(true);
						aname.setVisible(false);
						sub.setVisible(false);
						name.setVisible(false);
						subname.setVisible(false);
						prof.setVisible(false);
						info.setVisible(false);
						
					}
				});
				lblNewLabel_4.setForeground(Color.GREEN);
				lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
				lblNewLabel_4.setBounds(0, 247, 150, 40);
				
				JLabel lblNewLabel_6 = new JLabel("");
				lblNewLabel_6.setBackground(Color.BLUE);
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_6.setIcon(new ImageIcon(Admin.class.getResource("/images/sc.png")));
				lblNewLabel_6.setBounds(35, 170, 80, 80);
				lblNewLabel.add(lblNewLabel_6);
				
				JLabel label_2 = new JLabel("SUBMIT");
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setForeground(Color.GREEN);
				label_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
				label_2.setBackground(Color.WHITE);
				label_2.setBounds(278, 386, 53, 34);
				contentPane.add(label_2);	
			}
		
	
	
	public void getAdminProfile() {
			DBConnection dbc= new DBConnection(); 
			Connection con = dbc.conn();
			try {
				System.out.println(uid);
				PreparedStatement stmt=con.prepareStatement("select username,language from quiz.adminlogin where id = ?");  
				stmt.setInt(1,uid);	
				ResultSet rs = stmt.executeQuery();  
				while(rs.next()) { 
					name.setText(rs.getString(1).toUpperCase());
					subname.setText(rs.getString(2).toUpperCase());
				}
			} catch (SQLException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	
	
	
	
public boolean submitted()
		{
			DBConnection dbc= new DBConnection(); 
			Connection con = dbc.conn();
			
			String question = textPane.getText();
			String option1 = t2.getText();
			String option2 = t3.getText();
			String option3 = t4.getText();
			String option4 = t5.getText();
			String answer = ans.getText();
			if(question.equals("enter the question")||option1.equals("option 1")||option2.equals("option 2")||option3.equals("option 3")||option4.equals("option 4"))
			{
				return false;
			}
			else {
				try {
				PreparedStatement stmt=con.prepareStatement("insert into quiz.cpp(question,op1,op2,op3,op4,ans) values (?,?,?,?,?,?)");  
				stmt.setString(1,question);	
				stmt.setString(2,option1);
				stmt.setString(3,option2);
				stmt.setString(4,option3);
				stmt.setString(5,option4);
				stmt.setString(6,answer);
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
		}
			public boolean deleted()
			{
				DBConnection dbc= new DBConnection(); 
				Connection con = dbc.conn();
				try {
					PreparedStatement stmt=con.prepareStatement("delete from quiz.cpp");  
				  
					int i=stmt.executeUpdate();  
					System.out.println(i+" records deleted");  
					con.close();  
					return true;  // return true  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false; 
				}
		
				
		}

			
			public boolean activateMock() throws SQLException {
				DBConnection conn=new DBConnection();
		 		Connection con=conn.conn();
				PreparedStatement stmt=con.prepareStatement("insert into quiz.cppmockque(duration,no_of_que,duration_sec) values(?,?,?)");
 				stmt.setString(1,txtMin.getText());
 				stmt.setString(2, textField.getText());
 				stmt.setString(3, txtSec.getText());
 				stmt.executeUpdate();
 				PreparedStatement stmt1=con.prepareStatement("update quiz.login set status=1");
 				stmt1.executeUpdate();
 				//jop.showConfirmDialog(jop, "Mock Test Activated", "Success", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
 				return true;
			}
			
			public void setTxtMin(String s) {
				txtMin.setText(s);
			}
			public void setTxtSec(String s) {
				  txtSec.setText(s);
			  }
			public void setQuestionNo(String s) {
				  textField.setText(s);
			  }
			
			public void setQuestion(String s) {
				  textPane.setText(s);
			  }
			public void setOption1(String s) {
				  t2.setText(s);
			  }
			public void setOption2(String s) {
				  t3.setText(s);
			  }
			public void setOption3(String s) {
				  t4.setText(s);
			  }
			public void setOption4(String s) {
				  t5.setText(s);
			  }
			public void setAnswer(String s) {
				  ans.setText(s);
			  }
			
			
			
			
			
			
			public JOptionPane getJOP() {
				return this.jop;
			}
		}
		
			
	
