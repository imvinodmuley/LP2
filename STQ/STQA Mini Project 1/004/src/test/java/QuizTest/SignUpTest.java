package QuizTest;
import Quiz.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignUpTest {

	SignUp sign = new SignUp("user");

	@Test
	public void testUserSignUp() {
	
		sign.setUserName("testuser1234");
		sign.setMobileNo("7788994455");
		sign.setPassword("testuser1234");
		sign.setConfPassword("testuser1234");
		sign.setVisible(true);
		boolean guess = sign.userSignUp("login");
		assertEquals(true, guess);

	}

	@Test
	public void testIsValidData() {
		boolean guess = sign.isValidData();
		assertEquals(true, guess);
	}

}
