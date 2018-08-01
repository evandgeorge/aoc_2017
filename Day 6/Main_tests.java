import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Main_tests {

	@Test
	void test_getBlocksPerBank() {
		String input = "29	2	4	0	234	3	2	3	4	0	2	0	4	54	2	9923";
		int[] expectedOutput = new int[] {29, 2, 4, 0, 234, 3, 2, 3, 4, 0, 2, 0, 4, 54, 2, 9923};
		assertEquals(expectedOutput, Main.getBlocksPerBank(input));
	}
	
}
