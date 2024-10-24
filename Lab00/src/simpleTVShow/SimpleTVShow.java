package simpleTVShow;

public class SimpleTVShow {
	private String showName;
	private int nSeasons;
	private double rating;
	private String colors;
	
	public SimpleTVShow(String inputLine) {
		//-1 creates empty strings in places where we want them
		//The regex is off of stackoverflow https://stackoverflow.com/questions/15738918/
		//It matches for commas with an even number of quotes after it
		String[] tokens = inputLine.split(",(?=([^\"]|\"[^\"]*\")*$)", -1);
		
		//I just set the default value to 0 or a descriptive string
		if(!tokens[0].isEmpty())
			//get rid of quotes
			this.showName = tokens[0].replace("\"", "");
		else 
			this.showName = "[No Name]";
		
		if(!tokens[1].isEmpty())
			this.nSeasons = Integer.parseInt(tokens[1]);
		else 
			this.nSeasons = 0;
		
		if(!tokens[2].isEmpty())
			this.rating = Double.parseDouble(tokens[2]);
		else 
			this.rating = 0;
		
		if(!tokens[3].isEmpty())
			//get rid of quotes
			this.colors = tokens[3].replace("\"", "");
		else 
			this.colors = "[No Colors Given]";
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public int getnSeasons() {
		return nSeasons;
	}

	public void setnSeasons(int nSeasons) {
		this.nSeasons = nSeasons;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "The TV Show " + showName + " has " + nSeasons + " seasons, is rated " + rating + ", and has the color(s) "
				+ colors;
	}
}
