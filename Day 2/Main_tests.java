import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Main_tests {

	@Test
	void test_getChecksum() {							//check the getChecksum() function using sample table data
	
		int[] row1 = {5, 92, 5, 74, 3, 8};	//89
		int[] row2 = {6, 3, 83, 1, 5, 9};	//82
		int[] row3 = {0, 13, 86, 75, 1, 3}; //86
		int[] row4 = {13, 6, 37, 7, 2, 7};	//35
		int[] row5 = {5, 2, 5, 45, 31, 988};//986	sum = 1278
		
		int[][] table = {row1, row2, row3, row4, row5};
		
		assertEquals(1278, Main.getChecksum(table));
	}

  @Test
  void test_getChecksumWithABrokenTable() {
    int[] row1 = {5};
    int[] row2 = {};
      
    int[][] table = {row1, row2};
    
    assertEquals(5, Main.getChecksum(table));
  }

  @Test
  void test_getChecksumWithAnEmptyTable() {
    int[][] table = null;
    assertEquals(0, Main.getChecksum(table));
  }
}
