package lab;

import ch02.stringLogs.*;

public interface StringLogInterface2 extends StringLogInterface {
	public int howManyContains(String element);
	// returns the number of strings in the log which contain element
}
