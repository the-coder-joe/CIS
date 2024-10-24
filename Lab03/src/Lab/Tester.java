package Lab;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import ch02.stringLogs.*;
import tvShow.TVShow;

public class Tester {

	@Test
	public void test() {
		//start at -1 to ignore the header line
		int numTVShows = -1;
		
		File file = new File("tvs.csv");
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		while(inputFile.hasNextLine()) {
			inputFile.nextLine();
			//count the number of tv shows that are in the file
			numTVShows++;
		}
		
		inputFile.close();

		TVShow[] shows = new TVShow[numTVShows];
		
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		// eat the first header line
		inputFile.nextLine();

		for (int i = 0; i < shows.length && inputFile.hasNext(); i++) {
			String line = inputFile.nextLine();
			TVShow show = new TVShow(line);
			shows[i] = show;
		}

		inputFile.close();
		
		
		StringLogInterface nameLog = new ArrayStringLog("Name Log", numTVShows);
		StringLogInterface originalLangLog = new ArrayStringLog("Original Language Log", numTVShows);
		StringLogInterface firstAirLog = new ArrayStringLog("First Air Log", numTVShows);

		for (TVShow show : shows) {
			nameLog.insert(show.getName());
			originalLangLog.insert(show.getOriginalLanguage());
			firstAirLog.insert(show.getFirstAirDate() != null ? show.getFirstAirDate().toString() : "");
		}

		System.out.println(nameLog.howManyContains("College"));
		System.out.println(originalLangLog.howManyContains("ja"));
		System.out.println(firstAirLog.howManyContains("2020"));
	}
}
