package QuizTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SignUpTest.class, ActiveMockTest.class, DownloadNotesTest.class, ForgetPasswordTest.class, LeaderboardTest.class,
		LoginTest.class, ProfileTest.class, ProgressBarTest.class, QuestionTest.class, QuizQuestionTest.class,
		QuizTest.class, SaveFileTest.class })
public class AllTests {

}
