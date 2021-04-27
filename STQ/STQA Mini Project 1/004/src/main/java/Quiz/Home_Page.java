package Quiz;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Home_Page {

	private JFrame frame; //private JFrame frame; 

	//Event dispath thread manages the starting of the program
	public static boolean main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Page window = new Home_Page();
					window.frame.setVisible(true);
					window.frame.setTitle("It's Quiz Time");
					window.frame.setResizable(false);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return true;
	}

	public Home_Page() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp signup = new SignUp("user");
				signup.setVisible(true);
				signup.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		lblUser.setForeground(Color.WHITE);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblUser.setBounds(108, 331, 91, 33);
		frame.getContentPane().add(lblUser);
		
		JLabel lbl_user_img = new JLabel("");
		lbl_user_img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp signup = new SignUp("user");
				signup.setVisible(true);
				signup.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		lbl_user_img.setIcon(new ImageIcon(Home_Page.class.getResource("/images/u4.png")));
		lbl_user_img.setBounds(119, 248, 65, 72);
		frame.getContentPane().add(lbl_user_img);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.out.print("hello");
				SignUp signup = new SignUp("admin");
				signup.setVisible(true);
				signup.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(108, 158, 91, 33);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lbl_admin_img = new JLabel("");
		lbl_admin_img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp signup = new SignUp("admin");
				signup.setVisible(true);
				signup.setLocationRelativeTo(null);
				frame.dispose();
				//Admin admin = new Admin();
				//admin.setVisible(true);
				//frame.dispose();
			}
		});
		lbl_admin_img.setIcon(new ImageIcon(Home_Page.class.getResource("/images/pic.png")));
		lbl_admin_img.setBounds(119, 67, 65, 95);
		frame.getContentPane().add(lbl_admin_img);
		
		JLabel lblHome = new JLabel("");
		lblHome.setForeground(Color.WHITE);
		lblHome.setBackground(Color.WHITE);
		lblHome.setIcon(new ImageIcon(Home_Page.class.getResource("/images/qimg.png")));
		lblHome.setBounds(0, 0, 484, 462);
		frame.getContentPane().add(lblHome);
	}
}
