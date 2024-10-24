package other;

import java.text.ParseException;
import ch01.Date;

public class TVShow {
	String verboseID;
	int id;
	String name;
	String originalName;
	String overview;
	boolean inProduction;
	String originalLanguage;
	Date firstAirDate;
	Date lastAirDate;
	int nEpisodes;
	int nSeasons;

	public TVShow(String verboseID, int id, String name, String originalName, String overview, boolean inProduction,
			String originalLanguage, Date firstAirDate, Date lastAirDate, int nEpisodes, int nSeasons) {
		this.verboseID = verboseID;
		this.id = id;
		this.name = name;
		this.originalName = originalName;
		this.overview = overview;
		this.inProduction = inProduction;
		this.originalLanguage = originalLanguage;
		this.firstAirDate = firstAirDate;
		this.lastAirDate = lastAirDate;
		this.nEpisodes = nEpisodes;
		this.nSeasons = nSeasons;
	}

	public TVShow(String inputLine) {
		String[] tokens = inputLine.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);

		try {
			// If there is no provided string, set the id to the string null.
			// This is applied to all of the strings in the data
			this.verboseID = tokens[0].isEmpty() ? "null" : tokens[0].replace("\"", "");

			// If there is no string, set the default int value to 0. This is applied to all
			// ints
			this.id = tokens[1].isEmpty() ? 0 : Integer.parseInt(tokens[1]);
			this.name = tokens[2].isEmpty() ? "null" : tokens[2].replace("\"", "");
			this.originalName = tokens[3].isEmpty() ? "null" : tokens[3].replace("\"", "");
			this.overview = tokens[4].isEmpty() ? "null" : tokens[4].replace("\"", "");

			// I can use equalsIgnoreCase to convert the string to a boolean. Technically
			// this allows all strings other than
			// true to return false, but this is okay since we will default these values to
			// false
			this.inProduction = tokens[6].replace("\"", "").equalsIgnoreCase("true");
			this.originalLanguage = tokens[8].isEmpty() ? "null" : tokens[8].replace("\"", "");

			if (!tokens[17].isEmpty()) {
				//tokenize the date
				String[] firstTokens = tokens[17].split("-");
				//create the date obj 
				this.firstAirDate = new Date(Integer.parseInt(firstTokens[1]), Integer.parseInt(firstTokens[2]),
						Integer.parseInt(firstTokens[0]));
			} else {
				//set to null if no date
				this.lastAirDate = null;
			}

			if (!tokens[18].isEmpty()) {
				//tokenize the date
				String[] lastTokens = tokens[18].split("-");
				this.lastAirDate = new Date(Integer.parseInt(lastTokens[1]), Integer.parseInt(lastTokens[2]),
						Integer.parseInt(lastTokens[0]));
			} else {
				// set to null if no date
				this.lastAirDate = null;
			}

			this.nEpisodes = tokens[19].isEmpty() ? 0 : Integer.parseInt(tokens[19].replace("\"", ""));
			this.nSeasons = tokens[20].isEmpty() ? 0 : Integer.parseInt(tokens[20].replace("\"", ""));

			// When we catch any errors, we print the line that was being parsed so we can
			// find the error easily
		} catch (ArrayIndexOutOfBoundsException e) {
			// If there is not enough inputs in the array, this will catch it
			System.out.println("Not enough elements in the input: " + inputLine);
		} catch (Exception e) {
			// print the error and the line since we dont know what the error is
			System.out.println("Unexpected error occurred: " + e.getMessage() + " On the line: " + inputLine);
		}
	}

	@Override
	public String toString() {
		return "TVShow [verboseID=" + verboseID + ", id=" + id + ", name=" + name + ", originalName=" + originalName
				+ ", overview=" + overview + ", inProduction=" + inProduction + ", originalLanguage=" + originalLanguage
				+ ", firstAirDate=" + firstAirDate + ", lastAirDate=" + lastAirDate + ", nEpisodes=" + nEpisodes
				+ ", nSeasons=" + nSeasons + "]";
	}

	public String getVerboseID() {
		return verboseID;
	}

	public void setVerboseID(String verboseID) {
		this.verboseID = verboseID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public boolean isInProduction() {
		return inProduction;
	}

	public void setInProduction(boolean inProduction) {
		this.inProduction = inProduction;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public Date getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(Date firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public Date getLastAirDate() {
		return lastAirDate;
	}

	public void setLastAirDate(Date lastAirDate) {
		this.lastAirDate = lastAirDate;
	}

	public int getnEpisodes() {
		return nEpisodes;
	}

	public void setnEpisodes(int nEpisodes) {
		this.nEpisodes = nEpisodes;
	}

	public int getnSeasons() {
		return nSeasons;
	}

	public void setnSeasons(int nSeasons) {
		this.nSeasons = nSeasons;
	}
}
