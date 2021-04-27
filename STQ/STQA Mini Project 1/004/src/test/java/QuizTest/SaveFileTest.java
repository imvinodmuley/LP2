package QuizTest;
import Quiz.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SaveFileTest {
	savefile save = new savefile();
	

	@Test
	public void saveFiletest() {
		boolean check = save.saveFiles();
		assertEquals(true,check);
	}
	
	@Test
	public void getFileNametest() {
		String fileName = save.getFileName("C:\\Users\\ChaitanyaBuddy\\Desktop\\air.txt");
		assertEquals("txt.ria",fileName);
	}

}
