import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	
	//Advent of Code 2017 Day 2
	
	static String tableText;
	
	public static void main(String[] args) {
		
		if(args[0].equals(null)) {							//terminate if no arguments are passed
			System.out.println("Pass path of table text file as argument");
			System.exit(-1);
		}
		
		try {
			tableText = new String(Files.readAllBytes(Paths.get(args[0])));		//store contents of text file into string
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		int[][] tableData = initTableData();						//parse string data into 2D integer array
		
		System.out.println(getChecksum(tableData));					//print checksum of table
	}

	private static int[][] initTableData() {
		int[][] tableData = new int[16][16];
		int row = 0;
		int column = 0;
		String currentTableEntry = "";							//buffer that characters are stored in as the table string is read
		
		for(int i = 0; i < tableText.length(); i++) {					//cycles through each character in the file string
			
			if(tableText.charAt(i) == '\t') {					//if current character is a tab/indent,
				tableData[row][column] = Integer.parseInt(currentTableEntry);	//parse the currentTableEntry buffer and store it in the corresponding place in the array
				currentTableEntry = "";						//clear buffer
				column++;							//increment the column index (tabs separate each column)
				continue;							//skip to next cycle so that tab character is not stored in the buffer
			}
			
			if(tableText.charAt(i) == '\r') {					//if current character is a carriage return,
				tableData[row][column] = Integer.parseInt(currentTableEntry);	//parse the currentTableEntry buffer and store it in the corresponding place in the array
				currentTableEntry = "";						//clear buffer
				row++;								//increment the row index (carriage returns & newlines separate each row)
				column = 0;							//reset column index to 0 to read left most table entry of the next row
				i++;								//add 1 to i to skip both the carriage return and following newline character (each newline consists of carriage return and newline character ("\r\n")
				continue;							//skip to next cycle to so that the newline character is not stored in the buffer
			}
			
			currentTableEntry += tableText.charAt(i);				//if character is not a tab or carriage return, add it to the currentTableEntry buffer
		}
		
		tableData[15][15] = Integer.parseInt(currentTableEntry);			//parse the final table entry and put it in the last column of the last row
		
		return tableData;
	}
	
	public static int getChecksum(int[][] tableData) {					//initialize checksum to 0
		int checksum = 0;

		for(int row = 0; row < tableData.length; row++) {				//cycle through each row of the 2D integer array to compute checksum
			int rowMin = tableData[row][0];						//initialize the maximum and minimum values of the current row to the first entry in the row
			int rowMax = tableData[row][0];
			
			for(int column = 1; column < tableData[row].length; column++) {		//starting at the second entry in the row, compare each table entry to the current max & min to find the absolute maximum and minimum values of the row
				if(rowMin > tableData[row][column])
					rowMin = tableData[row][column];
				
				if(rowMax < tableData[row][column])
					rowMax = tableData[row][column];
			}
			
			checksum += rowMax - rowMin;						//add the difference between the row max and min to checksum
		}
		
		return checksum;
	}
	
}
