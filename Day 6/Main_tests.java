import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Main_tests {

	@Test
	void test_getBlocksPerBank() {
		String input = "29	2	4	0	234	3	2	3	4	0	2	0	4	54	2	9923";
		int[] expectedOutput = new int[] { 29, 2, 4, 0, 234, 3, 2, 3, 4, 0, 2, 0, 4, 54, 2, 9923 };

		assertArrayEquals(expectedOutput, Main.getBlocksPerBank(input));
	}

	@Test
	void test_getRedistributedBanks() {
		int[] testBanks = new int[] { 0, 4, 8, 6, 0, 4, 5 };
		int[] expected = new int[] { 1, 5, 1, 8, 1, 5, 6 };

		assertArrayEquals(expected, Main.getRedistributedBanks(testBanks));
	}
}
