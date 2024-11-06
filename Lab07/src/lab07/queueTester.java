package lab07;

import static org.junit.Assert.*;

import org.junit.Test;

import tvShow.TVShow;

public class queueTester {
	@Test
	public void testSizeAndFromFile() {
		TVShowLLQ testQ = new TVShowLLQ();

		// test the case where the queue is empty
		assertEquals(0, testQ.size());

		testQ.fromFile("testfile.csv");

		// this test file has 5 shows
		assertEquals(5, testQ.size());

		testQ.enqueue(new TVShow(
				"6457d26c7b901e08b141869f,14,Shuriken School,Shuriken School,\"Shuriken School is a British animated series that first aired on August 20, 2006 on Nickelodeon and then on YTV a few weeks later. It has also been airing on Jetix in the UK since February 2006, as well as on CITV. In the United States, the show aired on Nicktoons Network and Nickelodeon. In Latin America is aired on Jetix.\",,false,Ended,en,FR,ES,,,,,,,2006-08-20,2006-11-11,26,1,/khXHvYKAvGqjtnKoLVYZr8r5yKD.jpg,35,16,10759,,,,,,Comedy,Animation,Action & Adventure,,,,,,6457d26c7b901e08b14186a2,6457d26c7b901e08b14186a3,6457d26c7b901e08b14186a4,,,,,,5.5,6,3.034,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,75257,17065,,,,,,,,,,,,,,,,,Zinkia Entertainment,Studio Xilam,,,,,,,,,,,,,,,,,,/mqoS56YswPVBO3nriH2Qj6pWWbY.png,,,,,,,,,,,,,,,,,,FR,,,,,,,,,,,,,,,,,6457d26c7b901e08b14186a0,6457d26c7b901e08b14186a1,,,,,,,,,,,,,,,,,"));

		// make sure the size goes up by one when we add one more tv show
		assertEquals(6, testQ.size());
	}

	@Test
	public void testEpisodeFilters() {
		TVShowLLQ testQ = new TVShowLLQ();
		TVShowLLQ referenceQ = new TVShowLLQ();
		
		//test on an empty queue
		assertEquals(0, testQ.findMaxEpisodes(0).findMinEpisodes(0).size());

		testQ.fromFile("testfile.csv");
		referenceQ.fromFile("testfile.csv");
		
		TVShowLLQ q1 = testQ.findMinEpisodes(100);
		TVShowLLQ q2 = testQ.findMaxEpisodes(100);

		//there are 3 shows with more than 100 episodes
		assertEquals(3, q1.size());
		
		//this leaves 2 shows with less than 100 episods
		assertEquals(2, q2.size());

		//check that the original q is unaffected
		while(!testQ.isEmpty()){
			assertEquals(testQ.dequeue().getId(), referenceQ.dequeue().getId());
		}
	}

	@Test
	public void testToString() {
		TVShowLLQ testQ = new TVShowLLQ();
		
		//should be empty with an empty q
		assertEquals(0, testQ.toString().length());
		
		testQ.fromFile("testfile.csv");

		int numberOfLines = testQ.toString().split("\n").length;

		// there sould be five lines after reading a file with 5 tvshows
		assertEquals(5, numberOfLines);
	}
}
