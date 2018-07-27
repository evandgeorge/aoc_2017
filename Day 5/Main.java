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
			System.out.println("Error reading instructions file. Check path");
			e.printStackTrace();
			System.exit(-1);
		}

		// attempt to parse instructions file into integer instructions
		ArrayList<Integer> instructions = getInstructions(input);
		System.out.println(getNumberOfJumpsToExit(instructions) + " jumps to escape");
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

		if (!instBuffer.equals("")) // parse and add last instruction if the buffer isn't empty
			instructions.add(Integer.parseInt(instBuffer));

		return instructions;
	}

	public static int getNumberOfJumpsToExit(ArrayList<Integer> instructions) {
		int jumps = 0; // number of jumps taken
		int index = 0; // current instruction index

		do {
			int offset = instructions.get(index); // get offset of current instruction
			instructions.set(index, instructions.get(index) + 1); // add 1 to current index
			index += offset; // add offset to index
			jumps++;

		} while (index < instructions.size());

		return jumps;
	}
}