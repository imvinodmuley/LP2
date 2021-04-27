package QuizTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Quiz.Home_Page;

public class AppTest {

	@Test
	public void test() {
		Home_Page home = new Home_Page();	
		boolean check = home.main(null);
		assertTrue(check);
	}

}
