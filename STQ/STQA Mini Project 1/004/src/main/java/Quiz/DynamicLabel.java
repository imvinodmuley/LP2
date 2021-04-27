package Quiz;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class DynamicLabel 
{
	int subx,suby;
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DynamicLabel window = new DynamicLabel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public DynamicLabel() 
	{
		initialize();
	}
	private void initialize() 
	{
		final Border b=BorderFactory.createLineBorder(Color.DARK_GRAY);
		Scanner sc =new Scanner(System.in);
		final int n=sc.nextInt();
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//frame.getContentPane().add(lblPoints);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 0, 329, 462);
		frame.getContentPane().add(scrollPane);
		final JLabel lblleader = new JLabel("");
		scrollPane.setViewportView(lblleader);
		lblleader.setIcon(new ImageIcon(DynamicLabel.class.getResource("/images/wl.jpg")));
		//JLabel label = new JLabel("");
	    final JLabel  arr[]=new JLabel[n];
		final JLabel  arr1[]=new JLabel[n];
		final JLabel  arr2[]=new JLabel[n];
		final JLabel  arr3[]=new JLabel[n];
		//frame.getContentPane().add(lblLeaderboard);
		lblleader.setVisible(false);
		subx=46;
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 224, 101, 46);
		frame.getContentPane().add(scrollPane_1);
		JButton btnSubmit = new JButton("SUBMIT");
		scrollPane_1.setViewportView(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblleader.setVisible(true);
				
				for(int i=0;i<n;i++)
				{
					//arr[i].setText("label");
					arr[i]=new JLabel("");
					arr[i].setForeground(Color.black);
					arr[i].setBounds(0,subx,329,46);
					arr[i].setBorder(b);
					arr[i].setVisible(true);
					arr[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr[i]);
					
					arr1[i]=new JLabel("label"+i);
					arr1[i].setForeground(Color.black);
					arr1[i].setBounds(0,subx,69,46);
					arr1[i].setBorder(b);
					arr1[i].setVisible(true);
					arr1[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr1[i]);
					
					arr2[i]=new JLabel("label"+i);
					arr2[i].setForeground(Color.black);
					arr2[i].setBounds(233-165,subx,150,46);
					arr2[i].setBorder(b);
					arr2[i].setVisible(true);
					arr2[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr2[i]);
					
					//add
					arr3[i]=new JLabel("label"+i);
					arr3[i].setForeground(Color.black);
					arr3[i].setBounds(218,subx,100,46);
					arr3[i].setBorder(b);
					arr3[i].setVisible(true);
					arr3[i].setHorizontalAlignment(SwingConstants.CENTER);
					lblleader.add(arr3[i]);
					
				
					subx=subx+46;
				}
				lblleader.validate();
				lblleader.repaint();
			
			}
		});
		//frame.getContentPane().add(label_2);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsername.setBounds(233-165, 0, 150, 46);
		lblUsername.setBorder(b);
		//frame.getContentPane().add(lblUsername);
		
		JLabel lblRank = new JLabel("RANK");
		lblRank.setForeground(Color.WHITE);
		lblRank.setBorder(new LineBorder(new Color(255, 255, 0), 3));
		lblRank.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		lblRank.setBounds(165-165,0,69,46);
		//frame.getContentPane().add(lblRank);
		
		JLabel lblrow = new JLabel("");
		lblrow.setIcon(new ImageIcon(DynamicLabel.class.getResource("/images/back2.png")));
		lblrow.setBounds(165-165, 0, 319, 46);
		lblrow.setBorder(b);
		
		
		//add
		JLabel lblPoints = new JLabel("POINTS");
		lblPoints.setBounds(218, 0, 100, 46);
		lblPoints.setBorder(b);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblleader.add(lblPoints);
		lblleader.add(lblRank);
		lblleader.add(lblUsername);
		lblleader.add(lblrow);
		
		JLabel lblNewLabel = new JLabel("YELLOW");
		lblNewLabel.setForeground(new Color(153, 255, 0));
		lblNewLabel.setIcon(new ImageIcon(DynamicLabel.class.getResource("/images/back13.JPG")));
		lblNewLabel.setBounds(40, 302, -357, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHello = new JLabel("hello");
		lblHello.setBounds(7, 356, 148, 34);
		frame.getContentPane().add(lblHello);
		
		JLabel lblArrow = new JLabel("arrow");
		lblArrow.setIcon(new ImageIcon(DynamicLabel.class.getResource("/images/icons8-color-48.png")));
		lblArrow.setBounds(148-32,0, 32, 34);
		lblHello.add(lblArrow);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(25, 57, 114, 61);
		frame.getContentPane().add(scrollPane_2);
		
		JList list = new JList();
		scrollPane_2.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"hello", "asdg", "jhhasgdj", "masd"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new LineBorder(Color.RED, 3));
		
		list.setFont(new Font("Tahoma", Font.BOLD, 14));
	}
}
