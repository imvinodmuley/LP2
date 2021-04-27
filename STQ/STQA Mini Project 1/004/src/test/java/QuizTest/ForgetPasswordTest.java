package QuizTest;
import Quiz.*;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ForgetPasswordTest {
	LogIn login = new LogIn("user");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testIsValidData() {
		boolean guess = login.isValidData();
		assertEquals(true, guess);
	}
	
	@Test
	public void testForgetPassword() {
		login.setVisible(true);
		//login.getForgetPanel().setVisible(true);
		login.setMobileNo("7788994455");
		boolean check =  login.validateMobile();
		assertEquals(true, check);
		login.setResetPassword("testuser1234");
		login.setResetConfPassword("testuser1234");
		boolean check1 = login.validatePass();
		assertEquals(true, check1);
	}
	
	@Test
	public void ForgetPasswordFailTest() {
		//login.getForgetPanel().setVisible(true);
		login.setMobileNo("7777994455");
		boolean check =  login.validateMobile();
		assertEquals(false, check);
		login.setResetPassword("testuser1234");
		login.setResetConfPassword("test1234");
		boolean check1 = login.validatePass();
		assertEquals(false, check1);
	}

}
