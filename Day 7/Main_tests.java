import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class Main_tests {

	@Test
	void test_parseProgramData() {
		String testInput = "pbga (66)\r\n" + 
				"xhth (57)\r\n" + 
				"ebii (61)\r\n" + 
				"havc (66)\r\n" + 
				"ktlj (57)\r\n" + 
				"fwft (72) -> ktlj, cntj, xhth\r\n" + 
				"qoyq (66)\r\n" + 
				"padx (45) -> pbga, havc, qoyq\r\n" + 
				"tknk (41) -> ugml, padx, fwft\r\n" + 
				"jptl (61)\r\n" + 
				"ugml (68) -> gyxo, ebii, jptl\r\n" + 
				"gyxo (61)\r\n" + 
				"cntj (57)";
		
		LinkedList<String> expectedOutput = new LinkedList<String>();
		expectedOutput.add("pbga");
		expectedOutput.add("xhth");
		expectedOutput.add("ebii");
		expectedOutput.add("havc");
		expectedOutput.add("ktlj");
		expectedOutput.add("fwft");
		expectedOutput.add("qoyq");
		expectedOutput.add("padx");
		expectedOutput.add("tknk");
		expectedOutput.add("jptl");
		expectedOutput.add("ugml");
		expectedOutput.add("gyxo");
		expectedOutput.add("cntj");
		
		LinkedList<String> output = Main.getPrograms(testInput);
		
		for(int i = 0; i < expectedOutput.size(); i++) {
			assertEquals(expectedOutput.get(i), output.get(i));
		}
	}
	
}
