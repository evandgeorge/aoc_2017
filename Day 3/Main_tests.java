import static org.junit.jupiter.api.Assertions.*;

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

}
