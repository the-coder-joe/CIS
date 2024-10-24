package lab;

import ch02.stringLogs.*;

public class LinkedStringLog2 extends LinkedStringLog implements StringLogInterface2 {
	public LinkedStringLog2(String name) {
		super(name);
	}
	
	public int howManyContains (String element) {
		int count = 0;
		LLStringNode head = super.log;
		
		while(head != null) {
			if(head.getInfo().contains(element))
				count++;
			head = head.getLink();
		}
		
		return count;
	}
}
