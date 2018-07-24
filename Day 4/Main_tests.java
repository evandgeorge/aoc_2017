import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class Main_tests {

	LinkedList<String> convertStringToListWithoutLast(String phrase) {
		
		LinkedList<String> list = new LinkedList<String>();
		String wordBuffer = "";
		
		for(int i = 0; i < phrase.length(); i++) {
			
			if(phrase.charAt(i) == ' ') {
				list.add(wordBuffer);
				wordBuffer = "";
			} else
				wordBuffer += phrase.charAt(i);
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.print('\n');
		
		return list;
	}
	
	@Test
	void test_checkValidityOfPhrase() {
		String phrase1 = "aa bb cc dd ee"; boolean valid1 = true;
		String phrase2 = "aa bb cc dd aa"; boolean valid2 = false;
		String phrase3 = "aa bb cc dd aaa"; boolean valid3 = true;
		String phrase4 = "qjs giedut mzsubkn rcbugk voxk yrlp rqxfvz kspz vxg zskp"; boolean valid4 = false;
		
		assertEquals(valid1, Main.checkValidityOfPhrase(convertStringToListWithoutLast(phrase1), "ee"));
		assertEquals(valid2, Main.checkValidityOfPhrase(convertStringToListWithoutLast(phrase2), "aa"));
		assertEquals(valid3, Main.checkValidityOfPhrase(convertStringToListWithoutLast(phrase3), "aaa"));
		assertEquals(valid4, Main.checkValidityOfPhrase(convertStringToListWithoutLast(phrase4), "aaa"));
	}
	
}
