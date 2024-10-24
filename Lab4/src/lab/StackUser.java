package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import other.stacks.*;
import other.TVShow;

public class StackUser {
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

		BoundedStackInterface<TVShow> stack = new ArrayStack<TVShow>(5);

		for (int i = 0; i < 5; i++) {
			stack.push(new TVShow(inputFile.nextLine()));
		}

		inputFile.close();

		//before copying the stack, we print the top to compare with the copy
		System.out.println(stack.top().getVerboseID());
		
		BoundedStackInterface<TVShow> stack2 = new ArrayStack<TVShow>(5);

		// I use the stack size since it is readily available in this lab
		int stackSize = 5;

		TVShow[] tempList = new TVShow[stackSize];

		// build the temporary list of all of the elements in the stack
		for (int i = 0; i < stackSize; i++) {
			tempList[i] = stack.top();
			stack.pop();
		}

		for (int i = stackSize - 1; i >= 0; i--) {
			stack.push(tempList[i]);
			stack2.push(tempList[i]);
		}

		// test the swapping by printing the top of both. We only print the id becuase the lines are long and ids are unique
		System.out.println(stack.top().getVerboseID());
		System.out.println(stack2.top().getVerboseID());
		
		//All three lines printed should be identical
	}
}
