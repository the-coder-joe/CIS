package lab07;

import static org.junit.Assert.*;

import org.junit.Test;

public class queueTester {

	@Test
	public void test() {
		TVShowLLQ testQ = new TVShowLLQ();
		
		//test all methods on an empty Q first
		testQ.findInName("abc");
		testQ.
	}

	@Test
    public void testEmptyQueue() {
        TVShowLLQ emptyQueue = new TVShowLLQ();
        
        assertTrue(emptyQueue.toString().isEmpty());
        assertEquals(0, emptyQueue.findInName("abc").size());
        assertEquals(0, emptyQueue.findMinEpisodes(1).size());
        assertEquals(0, emptyQueue.findMaxEpisodes(1000).size());
    }
	
	@Test
	public void testSize() {
		TVShowLLQ testQ = new TVShowLLQ();
		
		testQ.fromFile("testfile.csv");
		
		assertEquals(5, testQ.size());
	}
}
