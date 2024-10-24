package lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class stackTester {

	@Test
	public void fromFileTest() {
		System.out.println("fromFileTest:");
		TVShowStack stack = new TVShowStack();
		
		//read the first 5 lines of the file to test
		stack.fromFile("tvs.csv", 5);
		
		//print the 5 lines from the file to test that it was able to read from the file
		while(!stack.isEmpty()) {
			System.out.println(stack.top());
			stack.pop();
		}
	}

	
	@Test
	public void countLongShowsTest() {
		System.out.println("countLongShowsTest:");
		TVShowStack stack = new TVShowStack();
		
		//read the first 20 lines of the file to test
		int num = stack.fromFile("tvs.csv", 10);
		
		int numberOfShows = stack.countLongShows(20);
		
		//of the first 10 shows, 5 should have more than 20 episodes
		assertEquals(numberOfShows, 5);
		
		stack = new TVShowStack();
		stack.fromFile("tvs.csv", 0);
		
		//no lines read should result in no long shows
		assertEquals(stack.countLongShows(10), 0);
	}

	@Test
	public void keepOnlyLongShowsTest() {
		System.out.println("keepOnlyLongShowsTest:");
		TVShowStack stack = new TVShowStack();
		
		stack.fromFile("tvs.csv", 10);
		
		//only keep over 100 episodes
		stack.keepOnlyLongShows(100);
		
		//should only print numbers over 100
		while(!stack.isEmpty()) {
			System.out.println(stack.top().getnEpisodes());
			stack.pop();
		}
		
		//test the edge case with 0 tvshows
		stack.fromFile("tvs.csv", 0);
		
		stack.keepOnlyLongShows(100);
		
		//nothing should print
		while(!stack.isEmpty()) {
			System.out.println(stack.top().getnEpisodes());
			stack.pop();
		}
	}
	
	@Test
	public void fullFileTest() {
		System.out.println("fullFileTest:");
		TVShowStack stack = new TVShowStack();
		
		stack.fromFile("tvs.csv");
		
		//print top
		System.out.println(stack.top());

		//print how many have more than 20 episodes
		System.out.println(stack.countLongShows(20));
		
		//remove shows with less than 100 episodes
		System.out.println(stack.keepOnlyLongShows(100));
		
		//print top again
		System.out.println(stack.top());
		}
	
	
}
