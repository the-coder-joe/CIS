package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import other.TVShow;

public class fileProcessor {
	public static void main(String[] args) {
		File file = new File("tvs.csv");
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		// eat the first header line
		inputFile.nextLine();

		StringLogInterface2 nameLog = new LinkedStringLog2("Name Log");
		StringLogInterface2 originalLangLog = new LinkedStringLog2("Original Language Log");
		StringLogInterface2 firstAirLog = new LinkedStringLog2("First Air Log");
		
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			TVShow show = new TVShow(line);
			nameLog.insert(show.getName());
			originalLangLog.insert(show.getOriginalLanguage());
			
			//if there is no first air date, just insert empty string
			if(show.getFirstAirDate() != null)
				firstAirLog.insert(show.getFirstAirDate().toString());
			else 
				firstAirLog.insert("");
		}

		inputFile.close();

		System.out.println(nameLog.howManyContains("College"));
		System.out.println(originalLangLog.howManyContains("ja"));
		System.out.println(firstAirLog.howManyContains("2020"));
	}
}
