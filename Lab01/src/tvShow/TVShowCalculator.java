package tvShow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import tvShow.TVShow;

public class TVShowCalculator {
 	private ArrayList<TVShow> shows = new ArrayList<TVShow>();
	private int totalSeasons = 0;
	private int minSeasons = Integer.MAX_VALUE;
	private int maxSeasons = Integer.MIN_VALUE;
	private double avgSeasons; 
	private int numShows;
	private String filename;
	
	//this will perform desired calculations on a given filename
	public TVShowCalculator(String filename) {
		this.filename = filename;
		File file = new File(filename);
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		//eat the first header line
		inputFile.nextLine(); 
		
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			TVShow show = new TVShow(line);
			this.shows.add(show);
		}
		
		inputFile.close();
	
		//champion code
		for(TVShow show : this.shows) {
			if(show.getnSeasons() < this.minSeasons) 
				this.minSeasons = show.getnSeasons();
			if(show.getnSeasons() > this.maxSeasons)
				this.maxSeasons = show.getnSeasons();
			this.totalSeasons += show.getnSeasons();
		}
		
		this.numShows = this.shows.size();
		this.avgSeasons = (double)this.totalSeasons / numShows;
	}
	
	public void printAllShows() {
		for (TVShow show : this.shows) 
			System.out.println(show.toString());
	}
	
	public String toString() {
		//this will return a nicely formatted display of all of the statistics gathered
		String str = "Stats for the shows in the file " + filename + ":";
		str += "\n\tTotal number of shows: " + String.valueOf(this.numShows);
		str += "\n\tLargest number of seasons: " + String.valueOf(this.maxSeasons);
		str += "\n\tSmallest number of seasons: " + String.valueOf(this.minSeasons);
		str += "\tAverage number of seasons: " + String.valueOf(this.avgSeasons);
		str += "\n";
		
		return str;
	}
	
	public String getFileName() {
		return this.filename;
	}

	public int getTotalSeasons() {
		return totalSeasons;
	}

	public void setTotalSeasons(int totalSeasons) {
		this.totalSeasons = totalSeasons;
	}

	public int getMinSeasons() {
		return minSeasons;
	}

	public void setMinSeasons(int minSeasons) {
		this.minSeasons = minSeasons;
	}

	public int getMaxSeasons() {
		return maxSeasons;
	}

	public void setMaxSeasons(int maxSeasons) {
		this.maxSeasons = maxSeasons;
	}

	public double getAvgSeasons() {
		return avgSeasons;
	}

	public void setAvgSeasons(double avgSeasons) {
		this.avgSeasons = avgSeasons;
	}

	public int getNumShows() {
		return numShows;
	}

	public void setNumShows(int numShows) {
		this.numShows = numShows;
	}
}
