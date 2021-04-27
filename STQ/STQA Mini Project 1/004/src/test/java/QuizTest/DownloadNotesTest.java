package QuizTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Quiz.DownLoadsNotes;

public class DownloadNotesTest {
	@Test
	public void testDownloadNotes() {
		DownLoadsNotes notes = new DownLoadsNotes();
		boolean check = notes.downloadNotes("air.txt");
		assertEquals(true, check);
	}

}
