package QuizTest;
import Quiz.*;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {

	static LogIn login = new LogIn("user");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//login.setVisible(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginUser() {
		login.setVisible(true);
		
		login.setUsername("testuser1234");
		login.setPass("testuser1234");
		
		boolean check =  login.loggedIn();
		assertEquals(true, check);
		Dashborad1 Dash = new Dashborad1(56,"testuser1234","7788994455");
		Dash.setVisible(true);
		
	}
	
	@Test
	public void LoginUserFailTest() {
	  
		login.setUsername("testuser1234");
		login.setPass("testuser");
		
		boolean check =  login.loggedIn();
		assertEquals(false, check);
		//Dashborad1 Dash = new Dashborad1(56,"testuser1234","7788994455");
		//Dash.setVisible(true);
		
	}

}
