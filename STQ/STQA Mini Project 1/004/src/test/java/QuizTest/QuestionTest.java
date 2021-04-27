package QuizTest;
import Quiz.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuestionTest {

	Admin admin = new Admin(1);
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
	public void AddQuestiontest() {
		admin.setQuestion("CPP language is ?");
		admin.setOption1("Object Oriented Programming");
		admin.setOption2("Functinal Programming");
		admin.setOption3("Procedural Programming");
		admin.setOption4("Structured Programming");
		admin.setAnswer("Object Oriented Programming");
	
		boolean check = admin.submitted();
		assertEquals(true,check);
		
	}
	
	@Test
	public void DeleteAllQuestiontest() {
		//boolean check = admin.deleted();
		//assertEquals(true,check);
	}

}
