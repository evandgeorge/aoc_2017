import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// Terminate if no arguments are passed

		if (args.length == 0) {
			System.out.println("Error: Pass memory banks file to program as argument.");
			System.exit(-1);
		}

		String input = "";

		// Attempt to read file

		try {
			input = new String(Files.readAllBytes(Paths.get(args[0])));
		} catch (IOException e) {
			System.out.println("Error reading instructions file from path \"" + args[0] + "\". Check path");
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println(getPrograms(input).get(1200));
	}

	public static LinkedList<String> getPrograms(String input) {
		LinkedList<String> programs = new LinkedList<String>();

		String programBuffer = "";

		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);

			if (currentChar >= 'a' && currentChar <= 'z')
				programBuffer += currentChar;
			else {
				programs.add(programBuffer);
				programBuffer = "";

				// skip to next name in the list
				for (int j = i + 1; j < input.length(); j++) {
					currentChar = input.charAt(j);

					if (currentChar == '\r') { // if character is a carriage return a newline will follow, add 1 to skip both
						i = j + 1;
						break;
					}

					if (currentChar == '\n') { // if character is a newline, move to that index so it will pass it when i is incremented
						i = j;
						break;
					}
				}
			}
		}

		return programs;
	}

}