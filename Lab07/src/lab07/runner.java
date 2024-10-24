package lab07;

public class runner {
	public static void main(String[] args) {
		TVShowLLQ queue = new TVShowLLQ();
		queue.fromFile("tvs.csv");
		
		queue = queue.findInName("arty");
		queue = queue.findMinEpisodes(100);
		queue = queue.findMaxEpisodes(500);
		
		System.out.print("Number of shows with 100-500 episodes containing \"arty\":");
		System.out.println(queue.size());
		
		System.out.println("\n" + queue.toString());
	}
}
