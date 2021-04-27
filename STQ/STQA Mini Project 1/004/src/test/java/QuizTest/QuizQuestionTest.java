package QuizTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Quiz.*;

public class QuizQuestionTest {

	
	@Test
	public void testStartQuiz() {
		Dashborad1 dash = new Dashborad1(88,"testuser1234","7788994455");
		dash.checkmockstatus();
		quizclass  quizobj = new quizclass(false, 88, dash, "cpp", true, dash.getDuration(), dash.getNoQuestion(), dash.getDurationSec());
				   quizobj.getquiz(31);		   
		quizobj.setVisible(true);
		boolean check = quizobj.isQuizStarted();
		assertEquals(true, check);
		
	}

}
