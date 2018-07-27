import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Terminate if no arguments are passed

		if (args.length == 0) {
			System.out.println("Error: Pass instructions file program as argument.");
			System.exit(-1);
		}

		String input = "";

		// Attempt to read file

		try {
			input = new String(Files.readAllBytes(Paths.get(args[0])));
		} catch (IOException e) {
			System.out.println("Error reading instructions file.");
			e.printStackTrace();
		}

		// attempt to parse instructions file into integer instructions
		ArrayList<Integer> instructions = getInstructions(input);

	}

	public static ArrayList<Integer> getInstructions(String input) {
		ArrayList<Integer> instructions = new ArrayList<Integer>();

		String instBuffer = ""; // buffer for characters read from input string

		/*
		 * For each character, if current char is not any kind of newline character and
		 * the buffer isn't empty, parse the buffer and add it to the instruction list
		 * and clear the buffer. If the character is not a newline or carriage return
		 * add it to the buffer
		 */

		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);

			if (currentChar == '\n' || currentChar == '\r') {

				if (!instBuffer.equals("")) {
					instructions.add(Integer.parseInt(instBuffer));
					instBuffer = "";
				}

			} else
				instBuffer += currentChar;
		}

		if (!instBuffer.equals(""))	//parse and add last instruction if the buffer isn't empty
			instructions.add(Integer.parseInt(instBuffer));

		return instructions;
	}
}