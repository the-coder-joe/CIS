import static org.junit.Assert.*;
import lab.*;

import org.junit.Test;

public class logTester {

	@Test
	public void test() {
		StringLogInterface2 testLog = new LinkedStringLog2("Test");
		
		testLog.insert("This is a test.");
		testLog.insert("This is not a test.");
		testLog.insert("element");
		testLog.insert("  not an element  ");
		testLog.insert("crazy");
		
		assertEquals(testLog.howManyContains("zzzz"), 0);
		assertEquals(testLog.howManyContains("This"), 2);
		assertEquals(testLog.howManyContains("crazy"), 1);
		assertEquals(testLog.howManyContains("e"), 4);
	}
}
