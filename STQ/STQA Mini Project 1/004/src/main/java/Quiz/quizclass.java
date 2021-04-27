package Quiz;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Scrollbar;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.ScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class quizclass extends JFrame
{
	int second;
	int mins;
	boolean updateLog=false;
	int count=0,uid;
	int anscount=0;
	String language;
	boolean flag = true;
	int questionCount=0;
	String ans="";
	JLabel Jop,lblquizback;
	JButton btnNewButton;
	JTextPane textPane;
	Label label,label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8;
	Label label_10;
	protected JLabel lblcolon;
	protected JLabel lblmin;
	protected JLabel lblsec;
	protected JLabel lbltimer;
	private JLabel lblsubtext;
	Timer mytimer=new Timer();
	private TimerTask tt;
	
	private JScrollPane scrollPane;
	private JButton btnSubmit;
	private JLabel lblsubback;
	private JLabel lblsubtxtback;
	private JButton btnsubmitq;	
	public void submitQuestion(Dashborad1 th)
	{
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		try
		{
			int id=0;
			PreparedStatement st2=con.prepareStatement("select id from quiz."+language+"ans where id = ?");
    		st2.setInt(1, uid);
    		ResultSet rs = st2.executeQuery();
    		while(rs.next())
    		{
    			id = rs.getInt(1);
    		}
    		if(id != uid)
    		{
    			PreparedStatement st=con.prepareStatement("insert into quiz."+language+"ans(id,score,qid,status) values(?,?,?,?)");
    			st.setInt(1, uid);
    			st.setInt(2, anscount);
    			st.setInt(3, count-1);
    			st.setInt(4, 1);
    			st.executeUpdate();
    		}
    		else
    		{
    			if(lbltimer.isVisible())
    			{
    				timerend(th);
    			}
    			else
    			{
    				System.out.println("hello2");
    				PreparedStatement st3=con.prepareStatement("update quiz."+language+"ans set score=?,status=?,qid=? where id=?");
	    			st3.setInt(1, anscount);
	    			st3.setInt(2, 1);
	    			st3.setInt(3, count-1);
	    			st3.setInt(4, uid);
	    			st3.executeUpdate();
    			}
    			
    		}
		PreparedStatement st1=con.prepareStatement("Delete from cpprecentlog where id=? and language=?");
		st1.setInt(1, uid);
		st1.setString(2, language);
		st1.executeUpdate();
		//Redirect to Dashboard page Along with popup
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		setVisible(false);
		if(!lbltimer.isVisible())
		{
		dynammicscroll sc=new dynammicscroll(th,language);
		sc.setVisible(true);
		}
		else 
			{
				th.setVisible(true);
			}
		//sc.getSubmittedAns();
	}
	public void submittedquestion(int uid,String selected )
	{
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		try 
		{
			 PreparedStatement st=con.prepareStatement("insert into quiz.submittedquest(id,ans) values(?,?)");
			 st.setInt(1, uid);
			 st.setString(2, selected);
			 st.executeUpdate();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printquestion(int questionCount )
	{
		String p;
		if(count<=questionCount) 
		{
			//System.out.println("inside if "+count);	
			if(label.getForeground()==Color.red)
			{
				if(ans.equals(label.getText()))
				{
					anscount++;
				}
				submittedquestion(uid,label.getText());
				getquiz(count+1);
				if(count<=questionCount) 
	    		{
					
					if(!lbltimer.isVisible())
					{
					  updateLog();
					}  
    				p=String.valueOf(count);
    				System.out.println(count);
    				label.setForeground(Color.BLACK);
    				label.setBackground(Color.LIGHT_GRAY);
    				//if(count!=questionCount)
    				label_10.setText(p);
		    	}
				else
				{
					if(lbltimer.isVisible())
					{
						lblsubtext.setVisible(true);
						lblsubback.setVisible(true);
						lblsubtxtback.setVisible(true);
						scrollPane.setVisible(false);
						btnSubmit.setVisible(true);
					}
					else
					{
						btnsubmitq.setVisible(true);
					}
					JOptionPane.showMessageDialog(Jop, "Quiz Completed,please submit");
					 btnNewButton.setVisible(false);
					
					 
				}
			}
			else if(label_1.getForeground()==Color.red)
			{
				if(ans.equals(label_1.getText()))
				{
					anscount++;
				}
				submittedquestion(uid,label_1.getText());
				getquiz(count+1);
				if(count<=questionCount) 
	    		{
					if(!lbltimer.isVisible())
					{
					  updateLog();
					}
    				p=String.valueOf(count);
    				System.out.println(count);
    				label_1.setForeground(Color.BLACK);
    				label_1.setBackground(Color.LIGHT_GRAY);
    				//if(count!=questionCount)
    				label_10.setText(p);
		    	}
				else
				{
					if(lbltimer.isVisible())
					{
						scrollPane.setVisible(false);
						lblsubtext.setVisible(true);
						lblsubback.setVisible(true);
						lblsubtxtback.setVisible(true);
						 btnSubmit.setVisible(true);
							
					}
					else
					{
						btnsubmitq.setVisible(true);
					}
					JOptionPane.showMessageDialog(Jop, "Quiz Completed,please submit");
							 btnNewButton.setVisible(false);
				}
			}
			else if(label_2.getForeground()==Color.red)
			{
				if(ans.equals(label_2.getText()))
				{
					anscount++;
				}
				submittedquestion(uid,label_2.getText());
				getquiz(count+1);
				if(count<=questionCount) 
	    		{
					if(!lbltimer.isVisible())
					{
					  updateLog();
					}
    				p=String.valueOf(count);
    				System.out.println(count);
    				label_2.setForeground(Color.BLACK);
    				label_2.setBackground(Color.LIGHT_GRAY);
    				//if(count!=questionCount)
    				label_10.setText(p);
		    	}
				else
				{
					if(lbltimer.isVisible())
					{
						scrollPane.setVisible(false);
						lblsubtext.setVisible(true);
						lblsubtxtback.setVisible(true);
						lblsubback.setVisible(true);
						 btnSubmit.setVisible(true);			
					}
					else
					{
						btnsubmitq.setVisible(true);
					}
					JOptionPane.showMessageDialog(Jop, "Quiz Completed,please submit");
					 btnNewButton.setVisible(false);
				}
			}
			else if(label_4.getForeground()==Color.red)
			{
				if(ans.equals(label_4.getText()))
				{
					anscount++;
				}
				submittedquestion(uid,label_4.getText());
				getquiz(count+1);
				if(count<=questionCount) 
	    		{
					if(!lbltimer.isVisible())
					{
					  updateLog();
					}
    				p=String.valueOf(count);
    				System.out.println(count);
    				label_4.setForeground(Color.BLACK);
    				label_4.setBackground(Color.LIGHT_GRAY);
    				//if(count!=questionCount)
    				label_10.setText(p);
		    	}
				else
				{
					if(lbltimer.isVisible())
					{
						scrollPane.setVisible(false);
						lblsubtext.setVisible(true);
						lblsubtxtback.setVisible(true);
						lblsubback.setVisible(true);
						btnSubmit.setVisible(true);			
					}
					else
					{
						btnsubmitq.setVisible(true);
					}
				
					JOptionPane.showMessageDialog(Jop, "Quiz Completed,please submit");
					 btnNewButton.setVisible(false);
				}
			}
			else
			{		    				
				JLabel Jop=new JLabel();
				JOptionPane.showMessageDialog(Jop, "Please select One of the Option");
			}
		}
		System.out.println("Next"+anscount);
	}
	public void updateLog()
	{
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		 PreparedStatement st1;
			try {
				st1 = con.prepareStatement("update cpprecentlog set cppqid=?,score=? where id=? and language=?");
				st1.setInt(1, count);
				st1.setInt(2,anscount);
				st1.setInt(3, uid);
				st1.setString(4, language);
				st1.executeUpdate();
			} catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	private boolean isQuizStarted = false;
	public boolean isQuizStarted(){
		return isQuizStarted;
	}
	
	public void getquiz(int qid)
	{
	
		count = (qid-1);
		System.out.println(count);
		ans = "";
		if(flag == true && !lbltimer.isVisible() )
		{
			getQuestionCount();
			flag = false;
		}
		try
		{
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
			PreparedStatement stmt=con.prepareStatement("select question,op1,op2,op3,op4,ans from quiz."+ language +" where no=?");
			stmt.setInt(1,count+1);
			ResultSet rs=stmt.executeQuery();
			//optional if
			//if(count<questionCount)
			
			while(rs.next())
			{
				textPane.setText(rs.getString(1));
				label.setText(rs.getString(2));
				label_1.setText(rs.getString(3));
				label_2.setText(rs.getString(4));
				label_4.setText(rs.getString(5));
				ans=rs.getString(6);
				//System.out.println(ans);		
			}
			count++;
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
		isQuizStarted = true;

	}
	public void timerend(Dashborad1 th)
	{
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		
			PreparedStatement st;
			try 
			{
				st=con.prepareStatement("insert into quiz.cppmockans(id,score) values(?,?)");
				st.setInt(1, uid);
				st.setInt(2, anscount);
				st.executeUpdate();
				PreparedStatement st4=con.prepareStatement("update quiz.login set status=? where id=?");
				st4.setInt(1, 0);
				st4.setInt(2, uid);
				st4.executeUpdate();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tt.cancel(); //Timer Thread Stopped
		setVisible(false);
		th.setVisible(true);
	}
	public void getQuestionCount()
	{
		try
		{
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
			PreparedStatement stmt=con.prepareStatement("select count(question) from quiz."+language);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				questionCount=rs.getInt(1);
				//System.out.println(ans);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void setCount(int qid,int Anscount)
	{
		label_10.setText(String.valueOf(qid));
		anscount=Anscount;
		getquiz(qid);
	}
	public quizclass(boolean flag2,int uid,final Dashborad1 th,String language,boolean mockstatus,int duration, final int no_of_quest,int duration_sec) 
	{
		Border b=BorderFactory.createLineBorder(Color.cyan);
		setTitle("It's Quiz Time - Quiz");
		setResizable(false);
		this.uid=uid;
		this.language = language;
		// TODO Auto-generated constructor stub
		DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		setResizable(false);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	    
	    lblsubback = new JLabel("");
	    lblsubback.setIcon(new ImageIcon(quizclass.class.getResource("/images/back6.jpg")));
	    lblsubback.setBounds(9, 0, 494, 461);
	    lblsubback.setVisible(false);
	    
	    btnSubmit = new JButton("SUBMIT");
	    btnSubmit.setForeground(Color.DARK_GRAY);
	    btnSubmit.setIcon(null);
	    btnSubmit.setVisible(false);
	    
	    btnSubmit.setBackground(Color.WHITE);
	    btnSubmit.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) 
	    	{
	    			submitQuestion(th);
	    			System.out.println(anscount);
	    	}
	    });
	    lblsubtext = new JLabel("Click on below to Submit");
	    lblsubtext.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    lblsubtext.setForeground(Color.RED);
	    lblsubtext.setHorizontalAlignment(SwingConstants.CENTER);
	    lblsubtext.setBounds(116, 189, 287, 41);
	    lblsubtext.setVisible(false);
	    
	    btnsubmitq = new JButton("SUBMIT");
	    btnsubmitq.setBackground(Color.WHITE);
	    btnsubmitq.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) 
	    	{
	    		submitQuestion(th);
	    	}
	    });
	    btnsubmitq.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    btnsubmitq.setForeground(Color.BLACK);
	    btnsubmitq.setBounds(373, 428, 97, 23);
	    btnsubmitq.setVisible(false);
	    getContentPane().add(btnsubmitq);
	    getContentPane().add(lblsubtext);
	    
	    lblsubtxtback = new JLabel("");
	    lblsubtxtback.setIcon(new ImageIcon(quizclass.class.getResource("/images/SignupBackground.jpg")));
	    lblsubtxtback.setBounds(116, 189, 287, 41);
	    lblsubtxtback.setVisible(false);
	    getContentPane().add(lblsubtxtback);
	    
	    btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    btnSubmit.setBounds(196, 271, 121, 41);
	    getContentPane().add(btnSubmit);
	    getContentPane().add(lblsubback);
	    
	    lbltimer = new JLabel("");
		lbltimer.setIcon(new ImageIcon(quizclass.class.getResource("/images/timer.JPG")));
		lbltimer.setBackground(Color.BLACK);
		lbltimer.setBorder(b);
		lbltimer.setBounds(386, 0, 108, 46);
		getContentPane().add(lbltimer);
		
		lblcolon = new JLabel(":");
		lblcolon.setHorizontalAlignment(SwingConstants.CENTER);
		lblcolon.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblcolon.setForeground(Color.WHITE);
		lblcolon.setBounds(421-376, 14-11, 19, 40);
		lbltimer.add(lblcolon);
		//frame.getContentPane().add(lblcolon);
		
	    lblmin = new JLabel("00");
		lblmin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblmin.setForeground(Color.WHITE);
		lblmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblmin.setBounds(377-376, 0, 45, 53);
		lbltimer.add(lblmin);
		//frame.getContentPane().add(lblmin);
		
		lblsec = new JLabel("00");
		lblsec.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblsec.setHorizontalAlignment(SwingConstants.CENTER);
		lblsec.setForeground(Color.WHITE);
		lblsec.setBounds(440-376, 0, 45, 53);
		lbltimer.add(lblsec);
		
		if(!mockstatus)
		{
			lbltimer.setVisible(false);
		}
		else
		{	
			mins=duration;
			second=duration_sec;
			lblmin.setText("0"+mins);
			//mins--;
			lblsec.setText("00");
			 tt=new TimerTask()
				{
					@Override
					public void run() 
					{
						lblmin.setText("0"+mins);
						// TODO Auto-generated method stub
						if(second<10)
						{	
						  lblsec.setText("0"+second);
						}
						else
						{
						 lblsec.setText(""+second);	
						}
						System.out.println(second--);
						if(second==0)
						{
							mins--;
							lblmin.setText("0"+mins);
							second=59;
							if(mins==-1)
							{
								lblmin.setForeground(Color.RED);
								lblsec.setForeground(Color.RED);
								lblsec.setText("00");
								lblmin.setText("00");
								timerend(th);
								tt.cancel();
							}	
						}
						if(mins==0)
						{
							lblsec.setForeground(Color.RED);
						}
					}
			
				};
				mytimer.schedule(tt, 1000,1000);
		}
	    label_10 = new Label();
	    label_10.setForeground(Color.RED);
	    label_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    label_10.setBackground(Color.DARK_GRAY);
	    label_10.setBounds(26, 58, 24, 32);
	    getContentPane().add(label_10);
	    
	    Label label_9 = new Label("Q.");
	    label_9.setForeground(Color.RED);
	    label_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    label_9.setBackground(Color.DARK_GRAY);
	    label_9.setBounds(9, 58, 40, 32);
	    getContentPane().add(label_9);
		
	    btnNewButton = new JButton("NEXT");
	    btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(9, 438, 88, 23);
		getContentPane().add(btnNewButton);
	    
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(54, 57, 416, 148);
	    getContentPane().add(scrollPane);
		
	    textPane = new JTextPane();
	    scrollPane.setViewportView(textPane);
		textPane.setBackground(Color.WHITE);
		textPane.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textPane.setEditable(false);
		
		 label = new Label("");
		 label.setBackground(Color.LIGHT_GRAY);
		 label.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) 
		 	{
		 			label.setBackground(Color.green);
		 			label.setForeground(Color.red);
		 			label_1.setForeground(Color.BLACK);
    				label_1.setBackground(Color.LIGHT_GRAY);
    				label_2.setForeground(Color.BLACK);
    				label_2.setBackground(Color.LIGHT_GRAY);
    				label_4.setForeground(Color.BLACK);
    				label_4.setBackground(Color.LIGHT_GRAY);
		 	}
		 });
		label.setBounds(54, 227, 416, 35);
		getContentPane().add(label);
		
		 label_1 = new Label("");
		 label_1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) 
		 	{
		 		label_1.setBackground(Color.green);
	 			label_1.setForeground(Color.red);
	 			label_2.setForeground(Color.BLACK);
				label_2.setBackground(Color.LIGHT_GRAY);
				label_4.setForeground(Color.BLACK);
				label_4.setBackground(Color.LIGHT_GRAY);
				label.setForeground(Color.BLACK);
				label.setBackground(Color.LIGHT_GRAY);
		 	}
		 });
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(54, 277, 416, 35);
		getContentPane().add(label_1);
		
		 label_2 = new Label("");
		 label_2.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) 
		 	{
		 		label_2.setBackground(Color.green);
	 			label_2.setForeground(Color.red);
	 			label_4.setForeground(Color.BLACK);
				label_4.setBackground(Color.LIGHT_GRAY);
				label.setForeground(Color.BLACK);
				label.setBackground(Color.LIGHT_GRAY);
				label_1.setForeground(Color.BLACK);
				label_1.setBackground(Color.LIGHT_GRAY);	
		 	}
		 });
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(54, 327, 416, 35);
		getContentPane().add(label_2);
		
		 label_4 = new Label("");
		 label_4.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) 
		 	{
		 		label_4.setBackground(Color.green);
	 			label_4.setForeground(Color.red);
	 			label.setForeground(Color.BLACK);
				label.setBackground(Color.LIGHT_GRAY);
				label_1.setForeground(Color.BLACK);
				label_1.setBackground(Color.LIGHT_GRAY);
				label_2.setForeground(Color.BLACK);
				label_2.setBackground(Color.LIGHT_GRAY);
		 	}
		 });
		 label_4.setBackground(Color.LIGHT_GRAY);
		label_4.setBounds(54, 378, 416, 35);
		getContentPane().add(label_4);
		
		 label_5 = new Label("A");
		label_5.setBackground(Color.GRAY);
		label_5.setAlignment(Label.CENTER);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_5.setBounds(9, 227, 29, 35);
		getContentPane().add(label_5);
		
		 label_6 = new Label("B");
		label_6.setBackground(Color.GRAY);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_6.setAlignment(Label.CENTER);
		label_6.setBounds(9, 277, 29, 35);
		getContentPane().add(label_6);
		
	    label_7 = new Label("C");
		label_7.setBackground(Color.GRAY);
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_7.setAlignment(Label.CENTER);
		label_7.setBounds(9, 327, 29, 35);
		getContentPane().add(label_7);
		
	    label_8 = new Label("D");
		label_8.setBackground(Color.GRAY);
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_8.setAlignment(Label.CENTER);
		label_8.setBounds(9, 378, 29, 35);
		getContentPane().add(label_8);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
		    	public void actionPerformed(ActionEvent arg0) 
		    	{		
		    		//System.out.println("ouside if "+count);
		    		//System.out.println(questionCount);
		    		if(!lbltimer.isVisible())
		    		{	
		    			printquestion(questionCount);
		    		}
		    		else 
		    		{
		    			printquestion(no_of_quest);
		    		}
		    	}
		    });
		updateLog=true;
		label_10.setText(String.valueOf(count+1));
		

		 lblquizback = new JLabel("");
		 lblquizback.setIcon(new ImageIcon(quizclass.class.getResource("/images/back_image.jpg")));
		 lblquizback.setLabelFor(this);
		 lblquizback.setBounds(0, 0, 494, 472);
		 getContentPane().add(lblquizback);
		 getquiz(count+1);
		  if(flag2==true && !lbltimer.isVisible())
		  {
		  PreparedStatement st1;
			try {
				System.out.println("again");
				st1 = con.prepareStatement("insert into cpprecentlog(id,cppqid,score,language) values(?,?,?,?)");
				st1.setInt(1, uid);
				st1.setInt(2, count);
				st1.setInt(3,anscount);
				st1.setString(4,language);
				st1.executeUpdate();
				
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
	}
	
	
	}
