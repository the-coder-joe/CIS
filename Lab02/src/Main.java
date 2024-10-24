
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tvShow.TVShow;

public class Main {
	public static void main(String[] args) {
		TVShow[] shows1 = new TVShow[200];
		
		File file = new File("tvs.csv");
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		//eat the first header line
		inputFile.nextLine(); 
		
		for(int i = 0; i < 200 && inputFile.hasNext(); i++) {
			String line = inputFile.nextLine();
			TVShow show = new TVShow(line);
			shows1[i] = show;
		}
		
		TVShow[] shows2 = new TVShow[201];
		
		for(int i = 0; i < shows1.length; i++)
			shows2[i] = shows1[i];
		
		String line = inputFile.nextLine();
		TVShow show = new TVShow(line);
		
		shows2[200] = show;
		
		inputFile.close();
	
		int showsContainingIs = 0;
		
		for(TVShow singleShow : shows2) {
			if(singleShow.toString().contains(" is "))
				showsContainingIs++;
		}
		
		System.out.println(Integer.toString(showsContainingIs) + " shows contain \" is \" in the 201 show list. ");
		
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		int totalTVShows = 0;
		while(inputFile.hasNext()) {
			inputFile.nextLine();
			totalTVShows++;
		}
		
		//get rid of one because it was the first line
		totalTVShows--;
		
		inputFile.close();
		
		System.out.println("In the large file, there were " + Integer.toString(totalTVShows) + " TVShows found");
		
		TVShow[] allTVShows = new TVShow[totalTVShows];
		
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		int index = 0;
		inputFile.nextLine();
		while (inputFile.hasNext()) {
			allTVShows[index++] = new TVShow(inputFile.nextLine());
		}
		
		int allShowsContainingIs = 0;
		
		for(TVShow singleShow : allTVShows) {
			if(singleShow.toString().contains(" is "))
				allShowsContainingIs++;
		}
		
		System.out.println("Of these shows, " + Integer.toString(allShowsContainingIs) + " contain \" is \".");
	
		//swap 100000 and 5 
		TVShow temp = allTVShows[4];
		allTVShows[4] = allTVShows[100001];
		allTVShows[100001] = temp;
		
		//print the first 10 tv shows
		System.out.println("The first 10 tv shows after swapping 5 and 100000 are:");
		for(int i = 0; i < 10; i++)
			System.out.println("\t" + allTVShows[i].getName());
	}
}
