package QuizTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import Quiz.Admin;

public class ActiveMockTest {
	Admin admin = new Admin(1);
	
	@Test
	public void testActivateMock() throws SQLException {

		//admin.setVisible(true);
		admin.setTxtMin("1");
		admin.setTxtSec("30");
		admin.setQuestionNo("2");

		boolean check = admin.activateMock();
		assertEquals("Mock Activated ",true,check);

	}


}
