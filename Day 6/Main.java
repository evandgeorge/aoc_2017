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
			System.out.println("Error reading instructions file from path \"" + args[0] +  "\". Check path");
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

	public static int[] getBlocksPerBank(String input) {
		int[] blocks = new int[16];
		
		return blocks;
	}
	
}