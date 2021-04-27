package Quiz;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class dynammicscroll extends JFrame
{
	Dashborad1 th;
	private JLabel lblQuestion;
	private JLabel lblheader;
	private JLabel lblansback;
	private JLabel lblsr;
	private JLabel lblsel;
	private JLabel lblAnswer;
	private JLabel lblmain;
	private JScrollPane scrollPane_main;
	private JLabel lblback;
	  Vector <String> quest=new Vector<String>();
	  Vector <String> ans=new Vector<String>();
	  Vector <String> submittedans=new Vector<String>();
	    DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		PreparedStatement stmt;
		ResultSet rs;
	  public void getSubmittedAns()
	  {
		
			int cnt=0;
			try 
			{
				 stmt=con.prepareStatement("select ans from quiz.submittedquest where id="+th.uid);
				 rs=stmt.executeQuery();
				while(rs.next())
				{
					submittedans.add(rs.getString(1));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}  
	  }
	  public void deletequestion()
	  {
		  try 
			{
				 stmt=con.prepareStatement("Delete  from quiz.submittedquest where id="+th.uid);
				 stmt.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			} 
	  }
	  
	public dynammicscroll(Dashborad1 th,String language) 
	{
		this.th = th; 
		getSubmittedAns();
		initialize(th,language);
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize(final Dashborad1 th,String language) 
	{
		setBounds(100, 100,500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setVisible(true);
		
		Border b=BorderFactory.createLineBorder(Color.white);
		Border b2=BorderFactory.createLineBorder(Color.gray);
		
		lblback = new JLabel("");
		lblback.setIcon(new ImageIcon(dynammicscroll.class.getResource("/images/left (3).png")));
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				deletequestion();
				th.setVisible(true);
				setVisible(false);
			}
		});
		lblback.setHorizontalAlignment(SwingConstants.CENTER);
		lblback.setBounds(48, 0, 50, 34);
		getContentPane().add(lblback);
		
		scrollPane_main = new JScrollPane();
		scrollPane_main.setBounds(0, 34, 484, 428);
		getContentPane().add(scrollPane_main);
		
		lblmain = new JLabel("");
		scrollPane_main.setViewportView(lblmain);
	    lblmain.setIcon(new ImageIcon(dynammicscroll.class.getResource("/images/newwl.jpg")));
	  
	    int n=0;
	    
	    DBConnection conn=new DBConnection();
		Connection con=conn.conn();
		int cnt=0;
		try 
		{
			PreparedStatement stmt=con.prepareStatement("select question,ans from quiz."+language);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				quest.add(rs.getString(1));
				ans.add(rs.getString(2));
				System.out.println(cnt);
				cnt++;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	   JScrollPane scrollPane_Answer[] = new JScrollPane[cnt];   
	   JTextPane txtpnAnswer[] = new JTextPane[cnt];
	    
	    JScrollPane scrollPane_Submitted[] = new JScrollPane[cnt];
	    JTextPane txtpnSubmitted[] = new JTextPane[cnt];
	    	    JScrollPane scrollPane_Question[] = new JScrollPane[cnt];
	      JTextPane txtpnQuestion[] = new JTextPane[cnt];
	   
	    
	    JLabel lblQno[] = new JLabel[cnt];
	     int x=0;
	    for(int i=0;i<cnt;i++)
	    {
	    	//1st textpane
	    	scrollPane_Answer[i] = new JScrollPane();
	    	scrollPane_Answer[i].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    scrollPane_Answer[i].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollPane_Answer[i].setBounds(413, x, 71, 49);
		    txtpnAnswer[i]=new JTextPane();
		    txtpnAnswer[i].setText(ans.elementAt(i));
		    txtpnAnswer[i].setFont(new Font("Arial", Font.BOLD, 12));
		    scrollPane_Answer[i].setViewportView(txtpnAnswer[i]);
		    lblmain.add(scrollPane_Answer[i]);
		    
		    
		    //2nd textpane
		    scrollPane_Submitted[i] = new JScrollPane();
		    scrollPane_Submitted[i].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollPane_Submitted[i].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    scrollPane_Submitted[i].setBounds(333, x, 81, 49);
		    txtpnSubmitted[i] = new JTextPane();
		    txtpnSubmitted[i].setText(submittedans.elementAt(i));
		    txtpnSubmitted[i].setFont(new Font("Arial", Font.BOLD, 12));
		    scrollPane_Submitted[i].setViewportView(txtpnSubmitted[i]);
		    lblmain.add(scrollPane_Submitted[i]);
		    
		    //3rd textpane
		    scrollPane_Question[i] = new JScrollPane();
		    scrollPane_Question[i].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollPane_Question[i].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    scrollPane_Question[i].setBounds(46, x, 288, 49);
		    txtpnQuestion[i] = new JTextPane();
		    txtpnQuestion[i].setText(quest.elementAt(i));
		    txtpnQuestion[i].setFont(new Font("Arial", Font.BOLD, 12));
		    scrollPane_Question[i].setViewportView(txtpnQuestion[i]);
		    lblmain.add(scrollPane_Question[i]);

		    
		    lblQno[i] = new JLabel();
		    //lblQno[i].setIcon(new ImageIcon(dynammicscroll.class.getResource("/images/SignupBackground.jpg")));
		    lblQno[i].setBounds(0,x, 46, 49);
		    lblQno[i].setFont(new Font("Arial", 1 , 16));
		    lblQno[i].setHorizontalAlignment(SwingConstants.CENTER);
		    lblQno[i].setText(""+(i+1));
		    lblQno[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    x+=50;
		    lblmain.add(lblQno[i]);
		    //break;
	    }
	    lblAnswer = new JLabel("Answer");
	    lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
	    lblAnswer.setForeground(Color.WHITE);
	    lblAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    lblAnswer.setBounds(413, 0, 71, 34);
	    lblAnswer.setBorder(b);
	    getContentPane().add(lblAnswer);
	    
	    lblsel = new JLabel("Submitted");
	    lblsel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblsel.setForeground(Color.WHITE);
	    lblsel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    lblsel.setBounds(333, 0, 81, 34);
	    lblsel.setBorder(b);
	    getContentPane().add(lblsel);
		
	    lblsr = new JLabel("Q.No");
	    lblsr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    lblsr.setForeground(Color.WHITE);
	    lblsr.setHorizontalAlignment(SwingConstants.CENTER);
	    lblsr.setBounds(0, 0, 46, 34);
	    lblsr.setBorder(b);
	    getContentPane().add(lblsr);
		
		lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(46, 0, 288, 34);
		lblQuestion.setBorder(b);
		getContentPane().add(lblQuestion);
		
	    lblheader = new JLabel("");
		lblheader.setIcon(new ImageIcon(dynammicscroll.class.getResource("/images/a1.jpg")));
		lblheader.setBounds(0, 0, 484, 34);
		getContentPane().add(lblheader);
		
		lblansback = new JLabel("");
		lblansback.setIcon(new ImageIcon(dynammicscroll.class.getResource("/images/SignupBackground.jpg")));
		lblansback.setBounds(0, 0, 484, 462);
		getContentPane().add(lblansback);
	}
}
