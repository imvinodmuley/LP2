package Quiz;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import java.awt.Label;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;


//import miniproject1.Dashborad;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;
import java.awt.Panel;
import java.awt.Scrollbar;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
public class Dashborad1 extends JFrame
{
	int uid,subx;
	int x=0,st=0;
	int duration,no_of_quest,duration_sec;
	Vector <String> fname;
	String uname=null,mobile=null;
	boolean mockclick=true;
	private JLabel lbldown;
	private JTextPane txtpndiscuss1;
	private JTextPane txtpndiscuss2;
	private JLabel lblDiscussUser1;
	private JLabel lblDiscussionBox;
	private JLabel lblDiscussUser2;
	private JTextPane txtpnNoThing;
	private JScrollPane leaderscrollPane;
	private JScrollPane scrollPane_download=new JScrollPane();
	private Vector<String> username;
	private Vector<Integer> score;
	private JTextField txtEnterNewMobile;
	private JPasswordField txtEnterNewPassword;
	private JLabel lblSubmit_1;
	private JLabel lblSubmit;
	private JLabel lblQuizking;
	private JLabel lblHacker;
	private JLabel label_12;
	private JLabel label_11;
	private JLabel label_9;
	private JLabel label_13;
	private JLabel lblvalidateMobileNo;
	private JLabel lbl_Update;
	private JLabel lblvalidateConfPassword;
	private JPasswordField txtResetConfPassword;
	private JTextPane lblNote;
	private JLabel lblLetsPlay;
	private JLabel lblcombo =  new JLabel();
	private String language = "cpp";
	private boolean leaderBoardflag = false;
	private String strlang = "cpp";
	public JLabel lblmock_text;
	public JLabel lblmock;
	private JLabel lblUsername;
	private JLabel lblRank;
	private JLabel lblrow;
	private JLabel lblPoints;
	private JLabel lblleader;
	public Dashborad1(int uid,String username,String mobile)
	{
		this.uid=uid;
		this.uname = username;
		this.mobile = mobile;
		initialize();
	}
	
	public Dashborad1 getDashObject() {
		return this;
	}
	
	
	public void setLanguage(String s) {
		this.language = s;
	}
	public int getDuration() {
		return this.duration;
	}
	
	public int getDurationSec() {
		return this.duration_sec;
	}
	
	public void checkmockstatus() 
	{
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select status from quiz.login where id =?");
			stmt.setInt(1,uid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				st=rs.getInt(1);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("status="+st);
		
		if(st==1)
		{
			try 
			{
				stmt = con.prepareStatement("select duration,no_of_que,duration_sec from quiz.cppmockque");
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
					duration=Integer.parseInt(rs.getString(1));
					no_of_quest=Integer.parseInt(rs.getString(2));
					duration_sec=Integer.parseInt(rs.getString(3));
				}
				System.out.println(duration);
				System.out.println(no_of_quest);
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				lblmock_text.setVisible(true);
				lblmock.setVisible(true);
		}		
		}

	private void initialize() 
	{

		setTitle("It's Quiz Time - Dashboard User - "+uname);
		setResizable(false);
		leaderscrollPane = new JScrollPane();
		Border b=BorderFactory.createLineBorder(Color.DARK_GRAY);
		final Border b2=BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		final Border b3=BorderFactory.createLineBorder(Color.black);
		
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(200, 100, 493, 493);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		drawComboBox(260, 74, 148, 34);
		
		lblmock_text = new JLabel("Mocktest");
		lblmock_text.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblmock_text.setForeground(Color.RED);
		lblmock_text.setHorizontalAlignment(SwingConstants.CENTER);
		lblmock_text.setBounds(194, 11, 88, 35);
		lblmock_text.setVisible(false);
		getContentPane().add(lblmock_text);
		
		lblmock = new JLabel("mocktest");
		lblmock.setVisible(false);
		lblmock.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				quizclass quiz = new quizclass(true,uid,Dashborad1.this,language,true,duration,no_of_quest,duration_sec);
				quiz.setVisible(true);
				quiz.setLocationRelativeTo(null);
				lblmock.setVisible(false);
				lblmock_text.setVisible(false);
				mockclick=false;
				setVisible(false);
			}
		});
		lblmock.setBorder(b);
		lblmock.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/SignupBackground.jpg")));
		lblmock.setHorizontalAlignment(SwingConstants.CENTER);
		lblmock.setBounds(194, 12, 88, 35);
		getContentPane().add(lblmock);
		checkmockstatus();
		final JLabel label_quiz = new JLabel("");
		label_quiz.setBackground(new Color(100, 149, 237));
		label_quiz.setBounds(165, 0, 324, 467);
		label_quiz.setBorder(b3);
		label_quiz.setVisible(false);
		
		final JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/profileround.png")));
		label_3.setBounds(280, 35, 96, 83);
		label_3.setVisible(false);
		
		final JLabel lblProgress = new JLabel("PROGRESS");
		lblProgress.setForeground(Color.BLUE);
		lblProgress.setBackground(Color.WHITE);
		lblProgress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(progressBarEvent()) {
					System.out.println("Progressbar Event Success");
				} else {
					System.out.println("Progressbar Event Failed");
				}
			}
		});
		lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgress.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblProgress.setBounds(350, 375, 117, 34);
		 lblProgress.setVisible(false);
		
		final JLabel lblResume = new JLabel("Resume");
		lblResume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 329, 304, 81);
		scrollPane.setVisible(false);
		
		final JLabel lblLogout = new JLabel("");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogIn login = new LogIn("user");
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblLogout.setToolTipText("Logout");
		lblLogout.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/logout_1 (2).jpg")));
		lblLogout.setBounds(408, 11, 71, 24);
		lblLogout.setVisible(true);
		getContentPane().add(lblLogout);
		
		getContentPane().add(scrollPane);
		
		lblDiscussionBox = new JLabel();
		lblDiscussionBox.setBounds(175, 11, 304, 307);
		lblDiscussionBox.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/back_image.jpg")));
		getContentPane().add(lblDiscussionBox);
		lblDiscussionBox.setBorder(null);
		
		lblDiscussUser1 = new JLabel("User 1");
		lblDiscussUser1.setBounds(0, 5, 70, 20);
		lblDiscussionBox.add(lblDiscussUser1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 30, 304, 114);
		lblDiscussionBox.add(scrollPane_2);
		
		txtpndiscuss1 = new JTextPane();
		txtpndiscuss1.setEditable(false);
		txtpndiscuss1.setVisible(false);
		scrollPane_2.setViewportView(txtpndiscuss1);
		
		
		lblDiscussUser2 = new JLabel("User 2");
		lblDiscussUser2.setBounds(0, 150, 70, 20);
		lblDiscussionBox.add(lblDiscussUser2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 175, 304, 122);
		lblDiscussionBox.add(scrollPane_1);
		
		txtpndiscuss2 = new JTextPane();
		txtpndiscuss2.setEditable(false);
		txtpndiscuss2.setVisible(false);
		scrollPane_1.setViewportView(txtpndiscuss2);
		
		 txtpnNoThing = new JTextPane();
		scrollPane.setViewportView(txtpnNoThing);
		txtpnNoThing.setVisible(false);
		
		final JButton btnAddComment = new JButton("AddComment");
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtpnNoThing.getText().equals("")) {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(jop, "Enter Your Question or Comment");
				}
				else
				{
					setComment();
					txtpnNoThing.setText(null);
				}
			}
		});
		btnAddComment.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddComment.setBackground(Color.WHITE);
		btnAddComment.setBounds(334, 421, 129, 34);
		getContentPane().add(btnAddComment);
		btnAddComment.setVisible(false);
		lblResume.setForeground(Color.GRAY);
		lblResume.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblResume.setHorizontalAlignment(SwingConstants.CENTER);
		lblResume.setBounds(349, 276, 106, 30);
		getContentPane().add(lblResume);
		
				final JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int qid=0,anscount=0;
				try
				{
					DBConnection conn=new DBConnection();
					Connection con=conn.conn();
					PreparedStatement stmt=con.prepareStatement("select cppqid,score from cpprecentlog where id=? and language=?");
					stmt.setInt(1,uid);
					stmt.setString(2,language);
					ResultSet rs=stmt.executeQuery();
					//optional if
					//if(count<questionCount)
					System.out.println("outsid"+qid);		
					System.out.println("outsid"+anscount);
					while(rs.next())
					{
						qid=rs.getInt(1);
						anscount=rs.getInt(2);
						System.out.println(qid);		
						System.out.println(anscount);
					}
					System.out.println(language);
					
				}
				catch(Exception exp)
				{
					System.out.println(exp);
				}
				if(qid!=0){
				boolean flag2 = false;
				quizclass quiz = new quizclass(false,uid,Dashborad1.this,language,false,duration,no_of_quest,duration_sec);
				quiz.setVisible(true);
				quiz.setLocationRelativeTo(null);
				quiz.setCount(qid,anscount);
				}
				else
				{
					JOptionPane jop = new  JOptionPane();
					jop.showMessageDialog(jop,"No Recent Activity Found, Please Click On Get Started.");
				}
			}
		});
		label_2.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/resume (2).png")));
		label_2.setBounds(377, 196, 71, 80);
		getContentPane().add(label_2);
		
		final JLabel lblGetStarted = new JLabel("Get Started");
		lblGetStarted.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGetStarted.setForeground(new Color(153, 0, 255));
		lblGetStarted.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetStarted.setBounds(178, 276, 122, 30);
		getContentPane().add(lblGetStarted);
		lblDiscussionBox.setVisible(false);
		
		final JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{	
				boolean flag = isRecentLog();
				if(flag) {
				if(getStatus())
				{
					quizclass quiz = new quizclass(true,uid,Dashborad1.this,language,false,duration,no_of_quest,duration_sec);
					//quizclass quiz1 = new quizclass(flag2, uid, th, language, mockstatus, duration, no_of_quest, duration_sec)
					quiz.setVisible(true);
					quiz.setLocationRelativeTo(null);
					setVisible(false);
				
				}
				else
				{
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(jop, language+" language is already Completed.");
				}
				}
			}
		});
		label_1.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/playbut.png")));
		label_1.setBounds(207, 192, 75, 84);
		getContentPane().add(label_1);
		getContentPane().add(lblProgress);
		//Update Profile
		 lbl_Update = new JLabel("");
			lbl_Update.setForeground(Color.WHITE);
			lbl_Update.setBounds(165, 123, 324, 344);
			lbl_Update.setVisible(false);
			
			
			getContentPane().add(lbl_Update);
			
		
		lblvalidateMobileNo = new JLabel("Please Enter 10 Digit Mobile Number");
		lblvalidateMobileNo.setForeground(Color.BLACK);
		lblvalidateMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblvalidateMobileNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblvalidateMobileNo.setBounds(232-165, 147-78, 192, 20);
		lbl_Update.add(lblvalidateMobileNo);
		lblvalidateMobileNo.setVisible(false);
		
		txtEnterNewMobile = new JTextField();
		txtEnterNewMobile.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) 
			{
				if(txtEnterNewMobile.getText().equals("Enter New Mobile Number"))
				{
					txtEnterNewMobile.setText("");
				}
				if(txtEnterNewMobile.getText().length() < 10 || 	txtEnterNewMobile.getText().length() > 10 )
				{
					lblvalidateMobileNo.setVisible(true);
				}
				else {
					lblvalidateMobileNo.setVisible(false);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				if(txtEnterNewMobile.getText().isEmpty())
				{
					txtEnterNewMobile.setText("Enter New Mobile Number");
				}
				if(txtEnterNewMobile.getText().length() < 10 || txtEnterNewMobile.getText().length() > 10 )
				{
					lblvalidateMobileNo.setVisible(true);
				}
				else {
					lblvalidateMobileNo.setVisible(false);
				}
			}
			
		});
		
		lblvalidateConfPassword = new JLabel("Password not matched reenter Password");
		lblvalidateConfPassword.setForeground(Color.BLACK);
		lblvalidateConfPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblvalidateConfPassword.setBounds(232-165, 238-40, 192, 20);
		lblvalidateConfPassword.setVisible(false);
		lbl_Update.add(lblvalidateConfPassword);

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
		txtResetConfPassword.setBounds(232-165, 238-85, 192, 45);
		lbl_Update.add(txtResetConfPassword);
		
		
		txtEnterNewPassword = new JPasswordField();
		txtEnterNewPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) 
			{
				if(txtEnterNewPassword.getText().equals("Enter New PassWord"))
				{
					txtEnterNewPassword.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				if(txtEnterNewPassword.getText().isEmpty())
				{
					txtEnterNewPassword.setText("Enter New PassWord");
				}
			}
		});

		txtEnterNewPassword.setText("Enter New PassWord");
		txtEnterNewPassword.setForeground(Color.LIGHT_GRAY);
		txtEnterNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtEnterNewPassword.setColumns(10);
		txtEnterNewPassword.setBounds(232-165, 238-150, 192, 45);
		txtEnterNewMobile.setText("Enter New Mobile Number");
		txtEnterNewMobile.setForeground(Color.LIGHT_GRAY);
		txtEnterNewMobile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtEnterNewMobile.setBounds(232-165, 147-123, 192, 45);
		txtEnterNewMobile.setColumns(10);
		lblSubmit_1 = new JLabel("SUBMIT");
		lblSubmit_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(updateData()) 
				{
					System.out.println("Thats Done");
				}
			}
		});
		lblSubmit_1.setForeground(Color.WHITE);
		lblSubmit_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSubmit_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit_1.setBounds(280-165, 317-90, 102, 34);
		
		lblNote = new JTextPane();
		lblNote.setBackground(Color.WHITE);
		lblNote.setText("NOTE:- Don't Want to Change Mobile No. or Password then Keep that field Empty");
		lblNote.setEditable(false);
		lblNote.setForeground(Color.BLACK);
		//lblNote.setBackground();
		//lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNote.setBounds(35, 317-35, 250, 40);
		lbl_Update.add(lblNote);
		//lblNote.setVisible(false);
		
		
		
		lblSubmit = new JLabel("");
		lblSubmit.setForeground(Color.WHITE);
		lblSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				lblSubmit.setBorder(b3);
			}
		});
		lblSubmit.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/Submit_111.JPG")));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSubmit.setBounds(280-165, 317-90, 102, 34);
		lblSubmit.setBorder(b2);
		lbl_Update.add(txtEnterNewMobile);
		lbl_Update.add(txtEnterNewPassword);
		lbl_Update.add(lblSubmit_1);
		lbl_Update.add(lblSubmit);
		
		final JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setForeground(Color.BLUE);
		lblUpdate.setBackground(Color.WHITE);
		lblUpdate.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				lbl_Update.setVisible(true);
				lblProgress.setVisible(false);
				lblUpdate.setVisible(false);
				label_13.setVisible(false);
				lblQuizking.setVisible(false);
				label_12.setVisible(false);
				label_11.setVisible(false);
				label_9.setVisible(false);
				lblHacker.setVisible(false);
			
			}
		});
		lblUpdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setBounds(195, 375, 103, 34);
		lblUpdate.setVisible(false);
		getContentPane().add(lblUpdate);
		
		label_13 = new JLabel(mobile);
		label_13.setBackground(Color.WHITE);
		label_13.setForeground(Color.BLACK);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_13.setBounds(260, 263, 148, 44);
		label_13.setVisible(false);
		getContentPane().add(label_13);
		
		lblQuizking = new JLabel(uname);
		lblQuizking.setBackground(Color.WHITE);
		lblQuizking.setForeground(Color.BLACK);
		lblQuizking.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuizking.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuizking.setBounds(260, 185, 148, 44);
		lblQuizking.setVisible(false);
		getContentPane().add(lblQuizking);
		
		label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/backprofile.png")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_12.setBounds(350, 368, 117, 47);
		label_12.setBorder(b3);
		label_12.setVisible(false);
		getContentPane().add(label_12);
		
		label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/backprofile.png")));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_11.setBounds(187, 368, 117, 47);
		label_11.setVisible(false);
		label_11.setBorder(b3);
		getContentPane().add(label_11);
		
		label_9 = new JLabel("");
		label_9.setBackground(Color.WHITE);
		label_9.setIcon(null);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_9.setBounds(242, 263, 182, 44);
		 label_9.setBorder(b2);
		label_9.setVisible(false);
		getContentPane().add(label_9);
		
		lblHacker = new JLabel("");
		lblHacker.setBackground(Color.WHITE);
		lblHacker.setIcon(null);
		lblHacker.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHacker.setForeground(Color.BLACK);
		lblHacker.setHorizontalAlignment(SwingConstants.CENTER);
		lblHacker.setBounds(242, 196, 182, 44);
		lblHacker.setVisible(false);
		lblHacker.setBorder(b2);
		getContentPane().add(lblHacker);
		
		final JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/013 Heavy Rain.png")));
		lblNewLabel_3.setBounds(165, 123, 324, 344);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(label_3);
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setBorder(b2); 
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/stopwatch-tool-to-control-test-time (1).png")));
		label_6.setBounds(5, 233, 55, 53);
		getContentPane().add(label_6);
		
		JLabel label_5 = new JLabel("");
		label_5.setVerticalAlignment(SwingConstants.BOTTOM);
		label_5.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/discuss-issue (2).png")));
		label_5.setBounds(5, 157, 63, 62);
		getContentPane().add(label_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/chevron (1).png")));
		label_4.setBounds(5, 310, 50, 53);
		getContentPane().add(label_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/man (3).png")));
		label.setBounds(7, 100, 50, 50);
		getContentPane().add(label);
		getContentPane().add(label_quiz);
		
		lblLetsPlay = new JLabel("");
		lblLetsPlay.setBounds(165, 0, 329, 482);
		getContentPane().add(lblLetsPlay);
		final JLabel lblStartQuiz = new JLabel("START QUIZ   ");
		lblStartQuiz.setToolTipText("start quiz");
		
		lblStartQuiz.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartQuiz.setForeground(Color.WHITE);
		lblStartQuiz.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStartQuiz.setBounds(0, 223, 164, 72);
		getContentPane().add(lblStartQuiz);
		
		
		final JLabel lblDiscussion = new JLabel("DISCUSSION   ");
		lblDiscussion.setToolTipText("discussion");
		
		lblDiscussion.setIcon(null);
		lblDiscussion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiscussion.setForeground(Color.WHITE);
		lblDiscussion.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiscussion.setBounds(0, 157, 165, 62);
		getContentPane().add(lblDiscussion);
		
		final JLabel lblLeaderboard = new JLabel("   LEADERBOARD ");
		lblLeaderboard.setToolTipText("Leaderboard");
	
		lblLeaderboard.setIcon(null);
		lblLeaderboard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeaderboard.setForeground(Color.WHITE);
		lblLeaderboard.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLeaderboard.setBounds(-2, 301, 165, 62);
		getContentPane().add(lblLeaderboard);
		JLabel lbldown_image = new JLabel("");
		lbldown_image.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/down-arrow (2) (1).png")));
		lbldown_image.setBounds(5, 371, 50, 53);
		getContentPane().add(lbldown_image);

		final JLabel lblDownload = new JLabel("            DOWNLOAD");
		lblDownload.setToolTipText("DOWNLOAD");
		lblDownload.setHorizontalAlignment(SwingConstants.CENTER);
		lblDownload.setForeground(Color.WHITE);
		lblDownload.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDownload.setBackground(Color.WHITE);
		lblDownload.setBounds(0, 365, 165, 61);
		getContentPane().add(lblDownload);

		
		final JLabel btnProfile = new JLabel("           PROFILE   ");
		System.out.println("user id="+uid);
		btnProfile.setToolTipText("Profile");
		btnProfile.setBackground(Color.WHITE);
		btnProfile.setIcon(null);
		btnProfile.setForeground(new Color(255, 255, 255));
		btnProfile.setHorizontalAlignment(SwingConstants.CENTER);
		btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnProfile.setBounds(0, 95, 165, 61);
		getContentPane().add(btnProfile);
		
		JLabel lblNewLabel_1 = new JLabel("QUIZ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBounds(0, 0, 165, 95);
		
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/back10.jpg")));
		lblNewLabel.setBounds(0, 0, 164, 465);
		getContentPane().add(lblNewLabel);
		 lblNewLabel.setBorder(b3);
	
	
		final JTextPane txtpnNote = new JTextPane();
		txtpnNote.setEditable(false);
		txtpnNote.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		txtpnNote.setBackground(SystemColor.textHighlight);
		txtpnNote.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		txtpnNote.setForeground(Color.WHITE);
		txtpnNote.setText("\n IMPORTANT NOTE :-\r\n\n\t1. CLICK ON START BUTTON TO START QUIZ\r\n\t2. CLICK ON RESUME BUTTON TO BEGIN \r\n\t   WHERE YOU LEFT.\r\n\t\t\t\t\t\r\n\t\t\t\t\t\r\n\t");
		txtpnNote.setBounds(164, 368, 329, 114);
		getContentPane().add(txtpnNote);
		
		final JLabel lblprofileback = new JLabel("");
		lblprofileback.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/backprofile.png")));
		lblprofileback.setBounds(165, 2, 324, 465);
		lblprofileback.setVisible(false);
		getContentPane().add(lblprofileback);
		
		btnProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				//disabling mocktest button
				lblmock.setVisible(false);
				lblmock_text.setVisible(false);
				
				scrollPane_download.setVisible(false);
				//lbldown.setVisible(false);
				lblDownload.setBorder(null);
				lblDownload.setForeground(Color.white);
				leaderscrollPane.setVisible(false);
				lbl_Update.setVisible(false);
				lblcombo.setVisible(false);
				lblLogout.setVisible(true);
				lblStartQuiz.setBorder(null);
				lblDiscussion.setBorder(null);
				lblLeaderboard.setBorder(null);
				leaderBoardflag = false;
				btnProfile.setBorder(b2); 
				label_quiz.setVisible(false);
				
				lblLetsPlay.setVisible(false);
			//	label_1.setVisible(false);
		//		label_2.setVisible(false);
				txtpnNote.setVisible(false);
		//		lblLetsPlay_1.setVisible(false);
				System.out.println("user id="+uid);
				//profile panel
				lblProgress.setVisible(true);
				lblUpdate.setVisible(true);
				label_13.setVisible(true);
				//lblQuizking_1.setVisible(true);
				lblQuizking.setVisible(true);
				label_12.setVisible(true);
				label_11.setVisible(true);
				label_9.setVisible(true);
				//label_8.setVisible(true);
				lblHacker.setVisible(true);
				lblNewLabel_3.setVisible(true);
				 lblDiscussionBox.setVisible(false);
				 txtpnNoThing.setVisible(false);
				 btnAddComment.setVisible(false);
				 scrollPane.setVisible(false);
				 txtpndiscuss1.setVisible(false);
				 txtpndiscuss2.setVisible(false);
				//end of profile panel
				
				//Dashboard1 panel
				label_1.setVisible(false);
				lblGetStarted.setVisible(false);
				label_2.setVisible(false);
				lblResume.setVisible(false);
				//end of Dashboard1 Panel
				
				lblprofileback.setVisible(true);
				label_3.setVisible(true);
				btnProfile.setForeground(Color.CYAN);
				lblLeaderboard.setForeground(Color.white);
				lblDiscussion.setForeground(Color.white);
				lblStartQuiz.setForeground(Color.white);
			}
		});
		
		lblLeaderboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				lblcombo.setVisible(true);
				scrollPane_download.setVisible(false);
				//lbldown.setVisible(false);
				
				//disabling mocktest button
				lblmock.setVisible(false);
				lblmock_text.setVisible(false);
				
				lblDownload.setBorder(null);
				lblDownload.setForeground(Color.white);
				//default language
				drawComboBox(260, 5, 148, 34);
				language = strlang;
				//lblNone.setText("CPP");
				leaderBoardflag = true;
				
				lblLogout.setVisible(false);
				lbl_Update.setVisible(false);
				//lblcombo.setVisible(false);
				lblprofileback.setVisible(false);
				lblStartQuiz.setBorder(null);
				lblDiscussion.setBorder(null);
				lblLeaderboard.setBorder(b2);
				btnProfile.setBorder(null); 
				label_quiz.setVisible(false);
				lblLetsPlay.setVisible(false);
				//label_1.setVisible(false);
			//	label_2.setVisible(false);
				txtpnNote.setVisible(false);
				//lblLetsPlay_1.setVisible(false);
				
				//profile panel
				lblProgress.setVisible(false);
				lblUpdate.setVisible(false);
				label_13.setVisible(false);
			//	lblQuizking_1.setVisible(false);
				lblQuizking.setVisible(false);
				label_12.setVisible(false);
				label_11.setVisible(false);
				label_9.setVisible(false);
				//label_8.setVisible(false);
				lblHacker.setVisible(false);
				lblNewLabel_3.setVisible(false);
				 label_3.setVisible(false);
				 lblDiscussionBox.setVisible(false);
				 txtpnNoThing.setVisible(false);
				 btnAddComment.setVisible(false);
				 scrollPane.setVisible(false);
				 txtpndiscuss1.setVisible(false);
				 txtpndiscuss2.setVisible(false);
				 
				 //end of profile panel
					//Dashboard1 panel
					label_1.setVisible(false);
					lblGetStarted.setVisible(false);
					label_2.setVisible(false);
					lblResume.setVisible(false);
					//end of Dashboard1 Panel
					
				lblLeaderboard.setForeground(Color.CYAN);
				btnProfile.setForeground(Color.white);
				//lblLetsPlay2.setText("This is a leaderBoard");
				lblDiscussion.setForeground(Color.white);
				lblStartQuiz.setForeground(Color.white);
								
				//Dynamic label
			
				int n=getQuestionCount(language);
				leaderscrollPane.setVisible(true);
				leaderscrollPane.setBounds(165, 46, 329, 462);
				getContentPane().add(leaderscrollPane);
				getLeaderBoard(n);
			}
		});
		lblDownload.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				x=0;
				txtpnNote.setVisible(false);
				//disabling mocktest button
				lblmock.setVisible(false);
				lblmock_text.setVisible(false);
				
				lblprofileback.setVisible(false);
				fname=new Vector<String>();
				lblLogout.setVisible(false);
				lblcombo.setVisible(false);
				lblDownload.setBorder(b2);
				btnProfile.setBorder(null);
				lblDiscussion.setBorder(null);
				lblLeaderboard.setBorder(null);
				lblStartQuiz.setBorder(null);
				lblDownload.setForeground(Color.CYAN);
				btnProfile.setForeground(Color.white);
				lblDiscussion.setForeground(Color.white);
				lblLeaderboard.setForeground(Color.white);
				lblStartQuiz.setForeground(Color.white);
				
				
				lblProgress.setVisible(false);
				lblUpdate.setVisible(false);
				label_13.setVisible(false);
			//	lblQuizking_1.setVisible(false);
				lblQuizking.setVisible(false);
				label_12.setVisible(false);
				label_11.setVisible(false);
				label_9.setVisible(false);
				//label_8.setVisible(false);
				lblHacker.setVisible(false);
				lblNewLabel_3.setVisible(false);
				 label_3.setVisible(false);
				 lblDiscussionBox.setVisible(false);
				 txtpnNoThing.setVisible(false);
				 btnAddComment.setVisible(false);
				 scrollPane.setVisible(false);
				 txtpndiscuss1.setVisible(false);
				 txtpndiscuss2.setVisible(false);
				 
				 //end of profile panel
					//Dashboard1 panel
					label_1.setVisible(false);
					lblGetStarted.setVisible(false);
					label_2.setVisible(false);
					lblResume.setVisible(false);
					//end of Dashboard1 Panel
			
				leaderscrollPane.setVisible(false);
			//	actual download code
				
				getFName();
				Border b=BorderFactory.createLineBorder(Color.lightGray);
				//scrollPane_download=new JScrollPane();
				
				//scrollPane.setBounds(165, 0, 319, 462);
				scrollPane_download.setBounds(165, 0, 319, 462);
				scrollPane_download.setVisible(true);
				getContentPane().add(scrollPane_download);
				lbldown = new JLabel("");
				lbldown.setVisible(true);
				scrollPane_download.setViewportView(lbldown);
				lbldown.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/wl.jpg")));
				JLabel lbldown_title = new JLabel("List of Notes");
				lbldown_title.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
				lbldown_title.setForeground(Color.WHITE);
				lbldown_title.setHorizontalAlignment(SwingConstants.CENTER);
				lbldown_title.setBounds(220-165, 11, 213, 38);
				lbldown.add(lbldown_title);
				//frame.getContentPane().add(lbldown_title);
				
				JLabel lbldown_menu = new JLabel("");
				lbldown_menu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
					}
				});
				lbldown_menu.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/back2.png")));
				lbldown_menu.setBounds(0, 0, 318, 53);
				lbldown.add(lbldown_menu);
				
				JLabel lbldownload[] = new JLabel[fname.size()];
				JLabel lbl_down_txt[] = new JLabel[fname.size()];
				JLabel lbl_down_opt[] = new JLabel[fname.size()];
				//frame.getContentPane().add(lbldown_menu);	
				for(int i=0;i<fname.size();i++)
				{	
				
					//frame.getContentPane().add(lbldownload);
					
					lbl_down_txt[i]=new JLabel(); 
					lbl_down_txt[i].setText(""+fname.get(i));
					lbl_down_txt[i].setHorizontalAlignment(SwingConstants.CENTER);
					lbl_down_txt[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
					lbl_down_txt[i].setBounds(0, 54+x, 165, 47);
					lbl_down_txt[i].setBorder(b);
					lbldown.add(lbl_down_txt[i]);
					//frame.getContentPane().add(lbl_down_txt);
					
					lbldownload[i]=new JLabel();
					lbldownload[i].setIcon(new ImageIcon(Dashborad1.class.getResource("/images/download1.JPG")));
					lbldownload[i].setHorizontalAlignment(SwingConstants.CENTER);
					lbldownload[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
					lbldownload[i].setBounds(330-165, 54+x, 153, 47);
					lbldownload[i]=lbl(lbl_down_txt[i].getText());
					lbldown.add(lbldownload[i]);
					
					
				    lbl_down_opt[i]= new JLabel();
					lbl_down_opt[i].setHorizontalAlignment(SwingConstants.CENTER);
					lbl_down_opt[i].setIcon(null);
					lbl_down_opt[i].setBounds(0, 54+x, 318, 47);
					lbl_down_opt[i].setBorder(b);
					lbldown.add(lbl_down_opt[i]);
					
					x+=46;	
					//frame.getContentPane().add(lbl_down_opt);
				}
				
			}
		});	
		
		lblDiscussion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				scrollPane_download.setVisible(false);
				
				//disabling mocktest button
				lblmock.setVisible(false);
				lblmock_text.setVisible(false);
				
				//lbldown.setVisible(false);
				lblDownload.setBorder(null);
				lblDownload.setForeground(Color.white);
				leaderscrollPane.setVisible(false);
				leaderBoardflag = false;
				lbl_Update.setVisible(false);
				lblcombo.setVisible(false);
				lblprofileback.setVisible(false);
				lblLogout.setVisible(true);
				lblStartQuiz.setBorder(null);
				lblLeaderboard.setBorder(null);
				lblDiscussion.setBorder(b2);
				btnProfile.setBorder(null); 
				label_quiz.setVisible(false);
				lblLetsPlay.setVisible(false);
		//		label_1.setVisible(false);
		//		label_2.setVisible(false);
				txtpnNote.setVisible(false);
		//		lblLetsPlay_1.setVisible(false);
				//profile panel
				lblProgress.setVisible(false);
				lblUpdate.setVisible(false);
				label_13.setVisible(false);
				//lblQuizking_1.setVisible(false);
				lblQuizking.setVisible(false);
				label_12.setVisible(false);
				label_11.setVisible(false);
				label_9.setVisible(false);
				//label_8.setVisible(false);
				lblHacker.setVisible(false);
				lblNewLabel_3.setVisible(false);
				 label_3.setVisible(false);	
				
				 //end of profile panel
					//Dashboard1 panel
					label_1.setVisible(false);
					lblGetStarted.setVisible(false);
					label_2.setVisible(false);
					lblResume.setVisible(false);
					//end of Dashboard1 Panel
				//Discussion panel
					lblDiscussionBox.setVisible(true);
					//lblDiscussionBox.setBackground(Color.white);
					txtpnNoThing.setVisible(true);
					 btnAddComment.setVisible(true);
					 scrollPane.setVisible(true);
					 txtpndiscuss1.setVisible(true);
					 txtpndiscuss2.setVisible(true);
					
				lblDiscussion.setForeground(Color.CYAN);
				lblLeaderboard.setForeground(Color.white);
				btnProfile.setForeground(Color.white);
				lblStartQuiz.setForeground(Color.white);
				//lblLetsPlay2.setText("This is a Discussion");
				
				getDiscussMsg();
			}
		});
		lblStartQuiz.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				//disabling mocktest button
				checkmockstatus();
				if(mockclick && lblmock.isVisible())
				{
					lblmock.setVisible(true);
					lblmock_text.setVisible(true);
				}
				scrollPane_download.setVisible(false);
				//lbldown.setVisible(false);
				lblDownload.setBorder(null);
				lblDownload.setForeground(Color.white);
				//default language
				drawComboBox(260, 74, 148, 34);
				language = strlang;
				//lblNone.setText("CPP #bhai");
				leaderBoardflag = false;
				leaderscrollPane.setVisible(false);
				lblDiscussionBox.setVisible(false);
				lblprofileback.setVisible(false);
				lbl_Update.setVisible(false);
				lblLogout.setVisible(true);
				lblStartQuiz.setBorder(b2);
				lblLeaderboard.setBorder(null);
				lblDiscussion.setBorder(null);
				btnProfile.setBorder(null); 
				label_quiz.setVisible(false);
				//lblLetsPlay2.setVisible(false);
				lblLetsPlay.setVisible(true);
				lblcombo.setVisible(true);
				
			//	label_1.setVisible(true);
			//	label_2.setVisible(true);
				txtpnNote.setVisible(true);
				//lblLetsPlay_1.setVisible(true);
				//profile panel
				lblProgress.setVisible(false);
				lblUpdate.setVisible(false);
				label_13.setVisible(false);
			//	lblQuizking_1.setVisible(false);
				lblQuizking.setVisible(false);
				label_12.setVisible(false);
				label_11.setVisible(false);
				label_9.setVisible(false);
			//	label_8.setVisible(false);
				lblHacker.setVisible(false);
				lblNewLabel_3.setVisible(false);
				 label_3.setVisible(false);
				 lblDiscussionBox.setVisible(false);
				 txtpnNoThing.setVisible(false);
				 btnAddComment.setVisible(false);
				 scrollPane.setVisible(false);
				 txtpndiscuss1.setVisible(false);
				 txtpndiscuss2.setVisible(false);
				 //end of profile panel
					//Dashboard1 panel
					label_1.setVisible(true);
					lblGetStarted.setVisible(true);
					label_2.setVisible(true);
					lblResume.setVisible(true);
					//end of Dashboard1 Panel
				lblDiscussion.setForeground(Color.white);
				lblStartQuiz.setForeground(Color.CYAN);
				lblLeaderboard.setForeground(Color.white);
				btnProfile.setForeground(Color.white);
			}
		});
		
		
	}
	
	
	public boolean progressBarEvent() {
		progressbar frame = new progressbar(Dashborad1.this);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		int val1 = getQuestionSolved("java");
		int val2 = getQuestionSolved("cpp");
		int val3 = getQuestionSolved("sql");
		System.out.println("Java: "+val1);
		System.out.println("cpp: "+val2);
		System.out.println("sql: "+val3);
		
		frame.progressBarFill(val1,val2,val3);
		setVisible(false);
		return true;
	}
	public void getDiscussMsg() {
		DBConnection dbc = new DBConnection();
		Connection con = dbc.conn();
		try {
			PreparedStatement stmt=con.prepareStatement("select msg,userid from discussionbox ORDER BY iddiscussionbox DESC limit 2");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{	
				txtpndiscuss1.setText(rs.getString(1));
				lblDiscussUser1.setText("User ID:"+(String.valueOf(rs.getInt(2))));
				if(!rs.isLast())
				{
				txtpndiscuss2.setText(rs.getString(1));
				lblDiscussUser2.setText("User ID:"+(String.valueOf(rs.getInt(2))));
				}	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	public void fetch()
	{
		 	lblUsername = new JLabel("USERNAME");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblUsername.setBounds(233-165, 0, 150, 46);
			//lblUsername.setBorder(b);
			//frame.getContentPane().add(lblUsername);
			 lblRank = new JLabel("RANK");
			lblRank.setForeground(Color.WHITE);
			//lblRank.setBorder(b);
			lblRank.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblRank.setHorizontalAlignment(SwingConstants.CENTER);
			lblRank.setBounds(165-165,0,69,46);
			//frame.getContentPane().add(lblRank);
			
			lblrow = new JLabel("");
			lblrow.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/back2.png")));
		    lblrow.setBounds(165-165, 0, 319, 46);
			lblPoints = new JLabel("POINTS");
			lblPoints.setBounds(218, 0, 100, 46);
			//lblPoints.setBorder(b);
			lblPoints.setForeground(Color.WHITE);
			lblPoints.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
			//getContentPane().add(lblPoints);
	}
	public boolean getLeaderBoard(int n)
	{
		JLabel lblleader1=new JLabel("");
		JLabel  arr[]=new JLabel[n];
		JLabel  arr1[]=new JLabel[n];
		JLabel  arr2[]=new JLabel[n];
		JLabel  arr3[]=new JLabel[n];
		if(getRanks())
		{
		lblleader = new JLabel("");
		leaderscrollPane.setViewportView(lblleader);
		lblleader.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/wl.jpg")));
		lblleader.setVisible(true);
		subx=46;
		int scorevar=-1,prev=-1,rank=1;
				for(int i=0;i<username.size();i++)
				{
					scorevar=score.get(i);
					if(prev!=-1)
					{
						if(prev!=scorevar)
						{
							rank++;
						}	
					}	
					prev=scorevar;
					arr[i]=new JLabel("");
					if(uname.equals(username.get(i)))
					{
						arr[i].setBorder(new LineBorder(new Color(255, 255, 0), 3));
					}
					arr[i].setForeground(Color.black);
					arr[i].setBounds(0,subx,329,46);
					//arr[i].setBorder(b);
					arr[i].setVisible(true);
					arr[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr[i]);
					
					arr1[i]=new JLabel(""+rank);
					arr1[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
					arr1[i].setForeground(Color.black);
					arr1[i].setBounds(0,subx,69,46);
				//	arr1[i].setBorder(b);
					arr1[i].setVisible(true);
					arr1[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr1[i]);
					
					arr2[i]=new JLabel(username.get(i));
					arr2[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
					arr2[i].setForeground(Color.black);
					arr2[i].setBounds(233-165,subx,150,46);
					//arr2[i].setBorder(b);
					arr2[i].setVisible(true);
					arr2[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr2[i]);
					
					arr3[i]=new JLabel(""+score.get(i));
					arr3[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
					arr3[i].setForeground(Color.black);
					arr3[i].setBounds(218,subx,100,46);
					arr3[i].setVisible(true);
					arr3[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr3[i]);
					
					subx=subx+46;
				}
				lblleader.validate();
				lblleader.repaint();
				
		fetch();
		lblleader1.setVisible(false);
		lblleader.add(lblPoints);
		//lblrow.setBorder(b);
		lblleader.add(lblRank);
		lblleader.add(lblUsername);
		lblleader.add(lblrow);
		}
		else
		{
			lblleader.setVisible(false);
			lblleader1 = new JLabel("");
			leaderscrollPane.setViewportView(lblleader1);
			lblleader1.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/wl.jpg")));
			lblleader1.setVisible(true);
			subx=46;
					for(int i=0;i<n;i++)
					{
					    arr[i]=new JLabel("");
						arr[i].setForeground(Color.black);
						arr[i].setBounds(0,subx,329,46);
						//arr[i].setBorder(b);
						arr[i].setVisible(true);
						arr[i].setHorizontalAlignment(SwingConstants.CENTER);
						lblleader1.add(arr[i]);
						
						arr1[i]=new JLabel("");
						arr1[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						arr1[i].setForeground(Color.black);
						arr1[i].setBounds(0,subx,69,46);
					//	arr1[i].setBorder(b);
						arr1[i].setVisible(true);
						arr1[i].setHorizontalAlignment(SwingConstants.CENTER);
						lblleader1.add(arr1[i]);
						
						arr2[i]=new JLabel();
						arr2[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						arr2[i].setForeground(Color.black);
						arr2[i].setBounds(233-165,subx,150,46);
						//arr2[i].setBorder(b);
						arr2[i].setVisible(true);
						arr2[i].setHorizontalAlignment(SwingConstants.CENTER);
						lblleader1.add(arr2[i]);
						
						arr3[i]=new JLabel("");
						arr3[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						arr3[i].setForeground(Color.black);
						arr3[i].setBounds(218,subx,100,46);
						arr3[i].setVisible(true);
						arr3[i].setHorizontalAlignment(SwingConstants.CENTER);
						lblleader1.add(arr3[i]);
						
						subx=subx+46;
					}
					lblleader1.validate();
					lblleader1.repaint();
					fetch();
					lblleader1.add(lblPoints);
					//lblrow.setBorder(b);
					lblleader1.add(lblRank);
					lblleader1.add(lblUsername);
					lblleader1.add(lblrow);
		}
		return true;
		}
	public void setComment() {
		DBConnection dbc = new DBConnection();
		Connection con = dbc.conn();
		try {
			PreparedStatement stmt=con.prepareStatement("insert into discussionbox(userid,msg) values(?,?)");
			stmt.setInt(1, uid);
			stmt.setString(2, txtpnNoThing.getText());
			int i = stmt.executeUpdate();
			System.out.println(i+"Msg Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	public boolean getRanks() {
		//select cppans.score, login.username from cppans inner join login on cppans.id = login.id order by cppans.score desc;
		username = new Vector<String>();
		score  = new Vector<Integer>();
		DBConnection dbc = new DBConnection();
		Connection con = dbc.conn();
		try {
			String query = "select quiz."+language+"ans.score, login.username from quiz."+language+"ans inner join login on quiz."+language+"ans.id = login.id order by quiz."+language+"ans.score desc";
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{		
					score.add(rs.getInt(1));
					username.add(rs.getString(2));
			}
			
			int scorevar=-1,prev=-1,count=1;
			for (int i=0; i < username.size(); i++) 
			{
				scorevar=score.get(i);
				if(prev!=-1)
				{
					if(prev!=scorevar)
					{
						count++;
					}
					
				}	
				prev=scorevar;
				System.out.print(count+ "  ");
				System.out.print(username.get(i)+ "  ");
				System.out.println(score.get(i));
			}
			if(username.isEmpty() || score.isEmpty()) {
				return false;
			}
			else {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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
	public boolean updateData() {
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		String mobile_no = txtEnterNewMobile.getText();
		String password = new String(txtEnterNewPassword.getPassword());
		String pass = generate(password);
		 PreparedStatement st1;
		 JOptionPane jop = new JOptionPane();
			try {
			   if(isValidData() && lblvalidateMobileNo.isVisible())
				{
					st1 = con.prepareStatement("update login set password=? where id=?");
					st1.setString(1, pass);
					st1.setInt(2, uid);
					st1.executeUpdate();
					jop.showMessageDialog(jop,"Password Successfully Changed");
					return true;
				}
				else if(!isValidData() && !lblvalidateMobileNo.isVisible()){
					st1 = con.prepareStatement("update login set mobile=? where id=?");
					st1.setString(1,mobile_no);
					st1.setInt(2, uid);
					st1.executeUpdate();
					label_13.setText(mobile_no);
					jop.showMessageDialog(jop,"Mobile No Successfully Changed", "Error", jop.ERROR_MESSAGE);
					return true;
				}
				else if(isValidData() && !lblvalidateMobileNo.isVisible())
				{
					st1 = con.prepareStatement("update login set password=?, mobile=? where id=?");
					st1.setString(1,pass);
					st1.setString(2, mobile_no);
					st1.setInt(3, uid);
					st1.executeUpdate();
					jop.showMessageDialog(jop,"Mobile No & Password Successfully Changed", "Error", jop.ERROR_MESSAGE);
					return true;
				}
				else if(lblvalidateMobileNo.isVisible() || lblvalidateConfPassword.isVisible()) {
					jop.showMessageDialog(jop,"Mobile No OR Password is empty", "Error", jop.ERROR_MESSAGE);
					return false;
				}
				else {
					jop.showMessageDialog(jop, "Mobile No or Password not updated successfully");
					return false;
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
	
	}
	public boolean isValidData() { 
		System.out.println();
		if(!(txtEnterNewPassword.getText().equals(txtResetConfPassword.getText()))) {
			lblvalidateConfPassword.setVisible(true);
			return false;
		}
		else {
			lblvalidateConfPassword.setVisible(false);
		return true;
		}
	}

	public void drawComboBox(int x,int y,int width,int height){	
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/icons8-color-48.png")));
		label_15.setBounds(115, 0, 38, 34);
		lblcombo.add(label_15);
	
		
	    final JLabel  lblNone = new JLabel("CPP");
		lblNone.setBackground(new Color(102, 204, 204));
		lblNone.setForeground(Color.RED);
		lblNone.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNone.setHorizontalAlignment(SwingConstants.CENTER);
		lblNone.setBounds(0,0,115, 34);
		lblcombo.add(lblNone);
				
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/back.jpg")));
		label_14.setBounds(0, 0, 122, 34);
		lblcombo.add(label_14);
		
		String arr[]=new String[3];
		arr[0]="           CPP";arr[1]="           JAVA";arr[2]="           SQL";
		
//		if(leaderBoardflag)
//		{
//			lblNone.setText("CPP");
//		}
		final JComboBox comboBox = new JComboBox(arr);
		comboBox.setBackground(new Color(175, 238, 238));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox.setForeground(Color.RED);
		comboBox.setBounds(0,0, 148, 34);
		comboBox.setVisible(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals(comboBox.getItemAt(0)))
				{
					//System.out.println("cpp");
					lblNone.setText("CPP");
					language = "cpp";
					if(leaderBoardflag)
						getLeaderBoard(getQuestionCount("cpp"));
				}
				else if(comboBox.getSelectedItem().equals(comboBox.getItemAt(1)))
				{
					lblNone.setText("JAVA");
					language = "java";
					if(leaderBoardflag)
						getLeaderBoard(getQuestionCount("java"));
				}
				else if(comboBox.getSelectedItem().equals(comboBox.getItemAt(2)))
				{
					lblNone.setText("SQL");
					language = "sql";
					if(leaderBoardflag)
						getLeaderBoard(getQuestionCount("sql"));
				}
			 strlang = lblNone.getText();
			}
		});
		
		lblcombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.setVisible(true);
			}
		});	
		
		
		lblcombo.setBounds(x,y,width,height);
		lblcombo.add(comboBox);
		getContentPane().add(lblcombo);
	}
	
	public JLabel lbl(final String filename)
	{
		JLabel l;
		l=new JLabel("");
		l.setIcon(new ImageIcon(Dashborad1.class.getResource("/images/download1.JPG")));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l.setBounds(330-165, 54+x, 153, 47);
		
		l.addMouseListener( new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				System.out.println(filename);
				DownLoadsNotes d1=new DownLoadsNotes(filename);
			}
		});
		return l;
	}
	public void getFName()
	{
		DBConnection dbc = new DBConnection();
		Connection con = dbc.conn();
		try {
			PreparedStatement stmt=con.prepareStatement("select filename from savefile");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				fname.add(rs.getString(1));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public int getQuestionSolved(String lang){
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		PreparedStatement st2;
		int val=0;
		try {
			st2 = con.prepareStatement("select score from quiz.cpprecentlog where language = ? and id = ?");
			st2.setString(1, lang);
			st2.setInt(2, uid);
			ResultSet rs = st2.executeQuery();
			if(rs.next()) {
				//System.out.println("if1");
				while(rs.next()) {
					//System.out.println("while1");
					val =  rs.getInt(1);
					}
			}
			else {
				//System.out.println(lang);
				//System.out.println(uid);
				PreparedStatement st3 = con.prepareStatement("select score from quiz."+lang+"ans where id =?");
				st3.setInt(1, uid);
				ResultSet rs1 = st3.executeQuery();
				while(rs1.next())
					val = rs1.getInt(1);
				//System.out.println(val+" F");
			}
				 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	
	public int getQuestionCount(String lang){
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		PreparedStatement st2;
		int val=0;
		try {
			st2 = con.prepareStatement("select count(id) from quiz."+lang+"ans");
			ResultSet rs = st2.executeQuery();
				while(rs.next()) {
					val =  rs.getInt(1);
				}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	
	public boolean getStatus() {
		int stat=0;
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		PreparedStatement st2;
		try {
			st2 = con.prepareStatement("select status from quiz."+language+"ans where id = ?");
			st2.setInt(1, uid);
			ResultSet rs = st2.executeQuery();
			while(rs.next())
			{
				stat = rs.getInt(1);
			}
			if(stat==0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isRecentLog() {
		System.out.println("Function called");
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select cppqid from cpprecentlog where id=? and language=?");
			stmt.setInt(1,uid);
			stmt.setString(2,language);
			ResultSet rs=stmt.executeQuery();
			System.out.println("outWhile");
				System.out.println("Inif");
				JOptionPane jop = new JOptionPane();
				while(rs.next()) {
					System.out.println("Inwhile"+rs.getInt(1));
					if(jop.showConfirmDialog(jop,"Recent Acitivity Found. Do you Want to 'Restart'?","Warning",jop.YES_NO_OPTION)== jop.YES_OPTION)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	
	public void setTxtNewMobNo(String s) {
		txtEnterNewMobile.setText(s);
	}
	
	public void setTxtNewPassword(String s) {
		txtEnterNewPassword.setText(s);
	}
	
	public void setTxtNewConfPassword(String s) {
		txtResetConfPassword.setText(s);
	}

	public int getNoQuestion() {
			return this.no_of_quest;
	}
}

	
