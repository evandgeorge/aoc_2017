import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

	}

	public static int[] getBlocksPerBank(String input) {
		int[] blockCountss = new int[16];
		int currentBlock = 0;

		String bankBuffer = "";

		for (int i = 0; i < input.length(); i++) {
			char thisChar = input.charAt(i);

			if (thisChar >= '0' && thisChar <= '9') // If character is '0'-'9' add it to the buffer
				bankBuffer += thisChar;
			else {
				blockCountss[currentBlock] = Integer.parseInt(bankBuffer); // If its not '0'-'9' (tab/newline/etc.)
																			// parse the buffer and add it to the array,
																			// clear it, move to the next block.
				bankBuffer = "";
				currentBlock++;
			}
		}

		if (!bankBuffer.equals(""))
			blockCountss[currentBlock] = Integer.parseInt(bankBuffer); // If there's anything left in the buffer, parse
																		// it and add it to the array

		return blockCountss;
	}

}