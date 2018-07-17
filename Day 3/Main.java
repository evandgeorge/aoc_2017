import java.util.Scanner;

public class Main {
	
	//Advent of Code 2017 Day 3
	
	static int RIGHT = 0;											//direction keys
	static int UP = 1;
	static int LEFT = 2;
	static int DOWN = 3;
	
	public static void main(String[] args) {
		
		int squareNumber;
		
		Scanner scanner = new Scanner(System.in);
		
		do {														//parse input. If input is bad (unable to parse or less than 1) try again
			System.out.println("Enter square number");
			squareNumber = getSquareNumber(scanner.nextLine());
		} while (squareNumber < 1);
		
		scanner.close();
		
		System.out.println("Distance: " + getManhattanDistance(getCoordsOfSquare(squareNumber)));
		
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
		int direction = RIGHT;	//direction starts as right
		int highestX = 0;		//the farthest the squares have gone right. If x exceeds this its time to change direction
		int highestY = 0;		//the farthest the squares have gone up. If y exceeds this its time to change direction
		int lowestX = 0;		//the farthest the squares have gone left. If x is beneath this its time to change direction
		int lowestY = 0;		//the farthest the squares have gone down. If y is beneath this its time to change direction
		int x = 0;				//current x coordinate of last added square
		int y = 0;				//current y coordinate of last added square
		
		//for loop starts at square 1, and starts moving right. It wraps around the previously added squares until the given squareNumber is reached.
		
		for(int currentSquare = 1; currentSquare < squareNumber; currentSquare++) {
			if(direction == RIGHT) {
				x++;					//increment x if moving right
				if(x > highestX) {		//If x exceeds the highestX update it and change direction
					highestX = x;
					direction = UP;
				}
				
				continue;
			}
			
			if(direction == UP) {
				y++;					//increment y if moving up
				if(y > highestY) {		//If y exceeds the highestY update it and change direction
					highestY = y;
					direction = LEFT;
				}
				
				continue;
			}
			
			if(direction == LEFT) {
				x--;					//decrement x if moving left
				if(x < lowestX) {		//If x is beneath the lowestX update it and change direction
					lowestX = x;
					direction = DOWN;
				}
				
				continue;
			}
			
			if(direction == DOWN) {
				y--;					//decrement y if moving down
				if(y < lowestY) {		//If y is beneath the lowestY update it and change direction
					lowestY = y;
					direction = RIGHT;
				}
				
				continue;
			}
		}
		
		return new int[] {x, y};
	}

	public static int getManhattanDistance(int[] coords) {	//computes the Manhattan distance between the given coordinates and (0, 0)
		return Math.abs(coords[0]) + Math.abs(coords[1]);
	}
}
