package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ch03.stacks.*;
import other.TVShow;
import support.LLNode;

public class TVShowStack extends LinkedStack<TVShow> {
	public TVShowStack() {
		super();
	}
	
	public int fromFile(String fileName) {
		File file = new File(fileName);
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return 0;
		}

		// eat the first header line
		inputFile.nextLine();

		int count = 0;

		while (inputFile.hasNext()) {
			super.push(new TVShow(inputFile.nextLine()));
			count++;
		}

		inputFile.close();

		return count;
	}

	public int fromFile(String fileName, int maxLines) {
		File file = new File(fileName);
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return 0;
		}

		// eat the first header line
		inputFile.nextLine();
		int count = 0;

		while (inputFile.hasNext() && count < maxLines) {
			super.push(new TVShow(inputFile.nextLine()));
			count++;
		}

		inputFile.close();

		return count;
	}

	public int countLongShows(int minEpisodes) {
		int count = 0;

		LLNode<TVShow> currentNode = super.top;

		while (currentNode != null) {
			if (currentNode.getInfo().getnEpisodes() >= minEpisodes)
				count++;
			currentNode = currentNode.getLink();
		}
		return count;
	}

	public int keepOnlyLongShows(int minEpisodes) {
		LinkedStack<TVShow> tempStack = new LinkedStack<TVShow>();
		int count = 0;
		
		while (!super.isEmpty()) {
			//only add the long shows to the temp stack and increment counter
			if (super.top().getnEpisodes() >= minEpisodes) {
				tempStack.push(super.top());
				count++;
			}
			
			super.pop();
		}

		while(!tempStack.isEmpty()) {
			super.push(tempStack.top());
			tempStack.pop();
		}
		
		return count;
	}
}
