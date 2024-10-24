package lab;

import static org.junit.Assert.*;

import org.junit.Test;

import other.TVShow;

public class LinkedShowStackTest {

	@Test
	public void mostEpisodeTest() {
		LinkedShowStack testStack = new LinkedShowStack();

		// we haven't added any new shows, ensure that it outputs null for this edge
		// case
		assertEquals(null, testStack.mostEpisodeShow());

		// get the first 10 shows
		testStack.fromFile("tvs.csv", 10);

		TVShow originalTop = testStack.top();

		// in the first 10 shows, the most episodes of any is 850
		assertEquals(850, testStack.mostEpisodeShow().getnEpisodes());

		// try it again to make sure the stack was unaffected, also make sure the top is
		// the same
		assertEquals(850, testStack.mostEpisodeShow().getnEpisodes());
		assertEquals(testStack.top(), originalTop);
	}

	@Test
	public void totalEpisodeTest() {
		LinkedShowStack testStack = new LinkedShowStack();

		// we haven't added any new shows, ensure that it 0 for no episodes
		assertEquals(0, testStack.totalEpisodes());

		// get the first 10 shows
		testStack.fromFile("tvs.csv", 10);
		
		TVShow originalTop = testStack.top();

		// in the first 10 shows, the total episodes of any is 2187
		assertEquals(2187, testStack.totalEpisodes());

		// try it again to make sure the stack was unaffected, also make sure the top is
		// the same
		assertEquals(2187, testStack.totalEpisodes());
		assertEquals(testStack.top(), originalTop);
	}

	@Test
	public void longFile() {
		LinkedShowStack stack = new LinkedShowStack();
		//read all of the shows from the
		stack.fromFile("tvs.csv");

		System.out.println(stack.mostEpisodeShow());
		
		System.out.println(stack.totalEpisodes());

	}
}
