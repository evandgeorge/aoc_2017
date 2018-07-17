import java.util.Scanner;

public class Main {
	
	//Advent of Code 2017 Day 3
	
	static int RIGHT = 0;
	static int UP = 1;
	static int LEFT = 2;
	static int DOWN = 3;
	
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
	
	public static int[] getCoordsOfSquare(int squareNumber) {
		int direction = RIGHT;
		int highestX = 0;
		int highestY = 0;
		int lowestX = 0;
		int lowestY = 0;
		int x = 0;
		int y = 0;
		
		for(int currentSquare = 1; currentSquare < squareNumber; currentSquare++) {
			if(direction == RIGHT) {
				x++;
				if(x > highestX) {
					highestX = x;
					direction = UP;
				}
				
				continue;
			}
			
			if(direction == UP) {
				y++;
				if(y > highestY) {
					highestY = y;
					direction = LEFT;
				}
				
				continue;
			}
			
			if(direction == LEFT) {
				x--;
				if(x < lowestX) {
					lowestX = x;
					direction = DOWN;
				}
				
				continue;
			}
			
			if(direction == DOWN) {
				y--;
				if(y < lowestY) {
					lowestY = y;
					direction = RIGHT;
				}
				
				continue;
			}
		}
		
		return new int[] {x, y};
	}

}
