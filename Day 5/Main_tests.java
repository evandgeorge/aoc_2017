import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Main_tests {

	@Test
	void test_getInstructions() {
		//input string has assorted combinations of carriage returns and newlines to account for different standards
		String input = "1\n\r-3\r2\n-6\r3";
		ArrayList<Integer> instructions = new ArrayList<Integer>();
		
		instructions.add(1);
		instructions.add(-3);
		instructions.add(2);
		instructions.add(-6);
		instructions.add(3);
		
		assertEquals(instructions, Main.getInstructions(input));
	}

}
