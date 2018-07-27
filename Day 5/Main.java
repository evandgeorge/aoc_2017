import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		//Terminate if no arguments are passed
		
		if(args.length == 0) {
			System.out.println("Error: Pass instructions file program as argument.");
			System.exit(-1);
		}
		
		String input = "";
		
		//Attempt to read file
		
		try {
			input = new String(Files.readAllBytes(Paths.get(args[0])));
		} catch (IOException e) {
			System.out.println("Error reading instructions file.");
			e.printStackTrace();
		}
		
		ArrayList<Integer> instructions = getInstructions(input);
		
	}
	
	public static ArrayList<Integer> getInstructions(String input) {
		ArrayList<Integer> instructions = new ArrayList<Integer>();
		
		return instructions;
	}
}