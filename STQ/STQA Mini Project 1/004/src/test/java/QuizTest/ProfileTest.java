package QuizTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Quiz.Dashborad1;

public class ProfileTest {

	Dashborad1 dash = new Dashborad1(60, "testuser1234", "7788994455");
	
	@Test
	public void UpdateMobileNotest() {
		//dash.setVisible(true);
		dash.setTxtNewMobNo("7788994455");
		boolean check = dash.updateData();
		assertEquals(true,check);
	}
	
	@Test
	public void UpdatePasswordtest() {
		//dash.setTxtNewMobNo("7788994455");
		dash.setTxtNewPassword("testuser1234");
		dash.setTxtNewConfPassword("testuser1234");
		boolean check = dash.updateData();
		assertEquals(true,check);
	}
	
	@Test
	public void UpdateMobileAndPasswordtest() {
		dash.setTxtNewMobNo("7788994455");
		dash.setTxtNewPassword("testuser1234");
		dash.setTxtNewConfPassword("testuser1234");
		boolean check = dash.updateData();
		assertEquals(true,check);
	}
}
