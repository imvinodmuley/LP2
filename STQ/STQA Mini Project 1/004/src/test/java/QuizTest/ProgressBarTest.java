package QuizTest;
import Quiz.*;

import static org.junit.Assert.*;
import org.junit.Test;


public class ProgressBarTest {


	@Test
	public void testProgressBar() {
		Dashborad1 dash = new Dashborad1(19, "nagesh111", "0099776655");
		boolean check = dash.progressBarEvent();
		assertEquals(true,check);
		
	}

}
