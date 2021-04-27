package QuizTest;

import static org.junit.Assert.*;

import org.junit.Test;
import Quiz.*;

public class LeaderboardTest {
    Dashborad1 dash = new Dashborad1(26, "Chaitanya123", "5544668899");
    
	
	@Test
	public void testLeaderboardCpp() {
	 dash.setVisible(true);
	 dash.setLanguage("cpp");	
	 boolean check = dash.getLeaderBoard(dash.getQuestionCount("cpp"));
	 assertEquals(true, check);
	}
	
	@Test
	public void testLeaderboardJava() {
	 dash.setLanguage("java");	
	 boolean check = dash.getLeaderBoard(dash.getQuestionCount("java"));
	 assertEquals(true, check);
	}
	
	@Test
	public void testLeaderboardSql() {
	 dash.setLanguage("sql");	
	 boolean check = dash.getLeaderBoard(dash.getQuestionCount("sql"));
	 assertEquals(true, check);
	}

}
