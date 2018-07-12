package aoc_2017;

import java.util.Scanner;

public class Main {

	//Advent of Code 2017 Day 1	
	
	public static String puzzleInput;
	
	public static void main(String[] args) {
		System.out.print("Puzzle Input: ");
		
		Scanner s = new Scanner(System.in);
		puzzleInput = s.nextLine();											//input puzzle string through console
		
		System.out.println("Solution: " + getSolution());					//print solution to puzzle
		s.close();
	}

	static int getSolution() {
		int sum = 0;
		
		for(int i = 0; i < puzzleInput.length(); i++)
			if(puzzleInput.charAt(i) == puzzleInput.charAt(nextIndex(i)))	//find if character matches next character
				sum += puzzleInput.charAt(i) - 48;							//char '1' has ASCII value 49, subtracting 48 converts characters to integers
		
		return sum;
	}
	
	static int nextIndex(int i) {											//finds next index in loop
		if(i == puzzleInput.length() - 1)
			return 0;														//return i + 1 unless it's the last index in the puzzle input string, then return 0
		else
			return i + 1;
	}
}
