package lab;

import other.TVShow;
import support.LLNode;

public class LinkedShowStack extends TVShowStack {
	public TVShow mostEpisodeShow() {
		return recursiveMostEpisodeShow(super.top);
	}

	private TVShow recursiveMostEpisodeShow(LLNode<TVShow> link) {
		// if the link passed is null, return null
		if (link == null)
			return null;

		// get the largest in the rest of the chain
		TVShow largestInRemaining = recursiveMostEpisodeShow(link.getLink());

		// if the remaining largest is null, return this link's show
		if (largestInRemaining == null)
			return link.getInfo();

		// compare the current link to the largest in the remaining chain and return
		// what is bigger
		if (link.getInfo().getnEpisodes() > largestInRemaining.getnEpisodes())
			return link.getInfo();

		return largestInRemaining;
	}
	
	public int totalEpisodes() {
		return recursiveTotalEpisodes(super.top);
	}
	
	private int recursiveTotalEpisodes(LLNode<TVShow> link) {
		//if the link or info is null, return 0
		if(link == null || link.getInfo() == null) return 0;
		
		//add the current link's episode number to the rest of the episodes' total
		return link.getInfo().getnEpisodes() + recursiveTotalEpisodes(link.getLink());
	}
}
