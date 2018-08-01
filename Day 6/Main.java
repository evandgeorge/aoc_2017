import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

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
		int[] blockCounts = new int[16];
		int currentBlock = 0;

		String bankBuffer = "";

		for (int i = 0; i < input.length(); i++) {
			char thisChar = input.charAt(i);

			if (thisChar >= '0' && thisChar <= '9') // If character is '0'-'9' add it to the buffer
				bankBuffer += thisChar;
			else {
				blockCounts[currentBlock] = Integer.parseInt(bankBuffer); // If its not '0'-'9' (tab/newline/etc.)
																			// parse the buffer and add it to the array,
																			// clear it, move to the next block.
				bankBuffer = "";
				currentBlock++;
			}
		}

		if (!bankBuffer.equals(""))
			blockCounts[currentBlock] = Integer.parseInt(bankBuffer); // If there's anything left in the buffer, parse
																		// it and add it to the array

		return blockCounts;
	}

	public static int[] getRedistributedBanks(int[] blockCounts) {
		// find highest bank count
		int indexOfHighest = 0;

		for (int i = 1; i < blockCounts.length; i++)
			if (blockCounts[i] > blockCounts[indexOfHighest])
				indexOfHighest = i;

		// store amount of banks in banksToDistribute and clear the blocks from the bank
		int blocksToDistribute = blockCounts[indexOfHighest];
		blockCounts[indexOfHighest] = 0;

		int currentBank;

		// start with next bank after highest (i + 1), or first (i = 0) if the last bank
		// was the highest
		if (indexOfHighest == blockCounts.length - 1)
			currentBank = 0;
		else
			currentBank = indexOfHighest + 1;

		do {
			// add 1 to current bank, subtract 1 from blocksToDistribute, go to the next bank
			blockCounts[currentBank]++;
			currentBank++;
			blocksToDistribute--;
			
			// if the index is equal to the length of the array, its past the last bank and
			// needs to go back to the first
			if (currentBank == blockCounts.length)
				currentBank = 0;

		} while (blocksToDistribute > 0);
		
		return blockCounts;
	}
	
	public static int getNumberOfCyclesUntilRepeat(int[] blockCounts) {
		int cycles = 0;
		
		// make array list to record all distributions of blocks after each redistribution
		ArrayList<int[]> previousBlockCounts = new ArrayList<int[]>(); 
		previousBlockCounts.add(blockCounts);
		
		while(true) {
			blockCounts = getRedistributedBanks(blockCounts);
			
			if(checkRepeat(previousBlockCounts, blockCounts))
				return cycles;
			
			
			previousBlockCounts.add(blockCounts);
		}
	}

	private static boolean checkRepeat(ArrayList<int[]> previousBlockCounts, int[] blockCounts) {
		for(int i = 0; i < previousBlockCounts.size(); i++)
			if(Arrays.equals(previousBlockCounts.get(i), blockCounts))
				return true;
		
		
		
		return false;
	}
}