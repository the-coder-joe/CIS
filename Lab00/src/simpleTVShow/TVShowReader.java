package simpleTVShow;
import simpleTVShow.SimpleTVShow;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TVShowReader {
	public static void main(String[] args) {
		String filename = "tvsShort.csv";
		File file = new File(filename);
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		ArrayList<SimpleTVShow> shows = new ArrayList<SimpleTVShow>();
		
		//eat the first header line
		inputFile.nextLine(); 
		
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			SimpleTVShow show = new SimpleTVShow(line);
			shows.add(show);
		}
		
		inputFile.close();
		
		int smallestNumSeasons = Integer.MAX_VALUE;
		int largestNumSeasons = Integer.MIN_VALUE;
		int totalSeasons = 0;
		
		for(SimpleTVShow show : shows) {
			System.out.println(show.toString());
			if(show.getnSeasons() < smallestNumSeasons) 
				smallestNumSeasons = show.getnSeasons();
			if(show.getnSeasons() > largestNumSeasons)
				largestNumSeasons = show.getnSeasons();
			totalSeasons += show.getnSeasons();
		}
		
		int numShows = shows.size();
		
	}
}
