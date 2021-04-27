package QuizTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Quiz.Dashborad1;

public class QuizTest {

	@Test
	public void testStartQuiz() {
		//Check Status of the Quiz Solved or Not
		//Notsolved= true;
		//solved=False
		Dashborad1  dash = new Dashborad1(88, "testuser1234", "7788994455") ;
		boolean check = dash.getStatus();
		assertEquals(false,check); 
	}

}
