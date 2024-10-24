package lab07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ch05.queues.*;
import support.LLNode;
import tvShow.TVShow;

public class TVShowLLQ extends LinkedUnbndQueue<TVShow> {
	public TVShowLLQ() {
		super();
	}

	public void fromFile(String fileName) {
		File file = new File(fileName);
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}

		// eat the first header line
		inputFile.nextLine();

		while (inputFile.hasNext()) {
			this.enqueue(new TVShow(inputFile.nextLine()));
		}

		inputFile.close();
	}

	public String toString() {
		String returnString = "";

		LLNode<TVShow> currentShow = this.front;

		while (currentShow != null) {
			returnString += currentShow.getInfo().getName() + "\n";
			currentShow = currentShow.getLink();
		}

		return returnString;
	}

	public TVShowLLQ findInName(String input) {
		TVShowLLQ newQueue = new TVShowLLQ();
		TVShowLLQ tempQueue = new TVShowLLQ();

		while (!this.isEmpty()) {
			TVShow currentShow = this.dequeue();
			tempQueue.enqueue(currentShow);
			if (currentShow.getName().contains(input)) {
				newQueue.enqueue(currentShow);
			}
		}

		// go back and push all of the elements back onto the original queue
		while (!tempQueue.isEmpty()) {
			this.enqueue(tempQueue.dequeue());
		}

		return newQueue;
	}

	public TVShowLLQ findMinEpisodes(int minEpisodes) {
		TVShowLLQ newQueue = new TVShowLLQ();
		TVShowLLQ tempQueue = new TVShowLLQ();

		while (!this.isEmpty()) {
			TVShow currentShow = this.dequeue();
			tempQueue.enqueue(currentShow);
			if (currentShow.getnEpisodes() >= minEpisodes) {
				newQueue.enqueue(currentShow);
			}
		}

		// go back and push all of the elements back onto the original queue
		while (!tempQueue.isEmpty()) {
			this.enqueue(tempQueue.dequeue());
		}

		return newQueue;
	}

	public TVShowLLQ findMaxEpisodes(int maxEpisodes) {
		TVShowLLQ newQueue = new TVShowLLQ();
		TVShowLLQ tempQueue = new TVShowLLQ();

		while (!this.isEmpty()) {
			TVShow currentShow = this.dequeue();
			tempQueue.enqueue(currentShow);
			if (currentShow.getnEpisodes() <= maxEpisodes) {
				newQueue.enqueue(currentShow);
			}
		}

		// go back and push all of the elements back onto the original queue
		while (!tempQueue.isEmpty()) {
			this.enqueue(tempQueue.dequeue());
		}

		return newQueue;
	}

	public int size() {
		int count = 0;
		LLNode<TVShow> currentNode = this.front;
		while (currentNode != null) {
			currentNode = currentNode.getLink();
			count++;
		}
		
		return count;
	}
}
