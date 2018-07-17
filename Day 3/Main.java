import java.util.Scanner;

public class Main {
	
	//Advent of Code 2017 Day 3
	
	public static void main(String[] args) {
		
		int squareNumber;
		
		Scanner scanner = new Scanner(System.in);
		
		do {														//parse input. If input is bad (unable to parse or less than 1) try again
			squareNumber = getSquareNumber(scanner.nextLine());
		} while (squareNumber < 1);
		
		scanner.close();
		
	}
	
	public static int getSquareNumber(String input) {				//attempt to parse string input. Return -1 if error parsing
		int number;
		
		try {
			number = Integer.parseInt(input);
			if(number < 1)
				System.out.println("Invalid input.");
		} catch(NumberFormatException e) {
			System.out.println("Invalid input.");
			number = -1;
		}
		
		return number;
	}
}
