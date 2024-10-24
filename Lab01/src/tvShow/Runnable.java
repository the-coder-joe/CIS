package tvShow;

public class Runnable {
	public static void main(String[] args) {
		
		TVShowCalculator small = new TVShowCalculator("tvsShort.csv");
		TVShowCalculator medium = new TVShowCalculator("tvsMedium.csv");
		TVShowCalculator large = new TVShowCalculator("tvs.csv");
		
		small.printAllShows();
		System.out.print(small.toString());
		System.out.print(medium.toString());
		System.out.print(large.toString());
		
	}
}
