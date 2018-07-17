import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Main_tests {

	@Test
	void test_getSquareNumber() {
		assertEquals(Main.getSquareNumber("264"), 264);
		assertEquals(Main.getSquareNumber("28"), 28);
	}
	
	@Test
	void test_getSquareNumber_invalidInput() {
		assertEquals(Main.getSquareNumber(""), -1);
		assertEquals(Main.getSquareNumber("1 3"), -1);
	}
	
	@Test
	void test_getCoordsOfSquare() {
		assertEquals(Arrays.equals(Main.getCoordsOfSquare(1), new int[] {0, 0}), true);
		assertEquals(Arrays.equals(Main.getCoordsOfSquare(5), new int[] {-1, 1}), true);
		assertEquals(Arrays.equals(Main.getCoordsOfSquare(17), new int[] {-2, 2}), true);
	}
	
	@Test
	void test_getManhattanDistance() {
		assertEquals(0, Main.getManhattanDistance(new int[] {0, 0}));
		assertEquals(3, Main.getManhattanDistance(new int[] {-1, -2}));
		assertEquals(3, Main.getManhattanDistance(new int[] {1, -2}));
		assertEquals(3, Main.getManhattanDistance(new int[] {1, -2}));
		assertEquals(50, Main.getManhattanDistance(new int[] {-20, -30}));
	}
}
