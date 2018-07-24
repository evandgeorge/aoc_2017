import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Main {
	
	//Advent of Coding Day 4
	
	public static void main(String[] args) {
		String inputText = null;
		
		if(args.length == 0) {												//terminate if no arguments are passed
			System.out.println("Pass path of table text file as argument");
			System.exit(-1);
		}
		
		try {
			inputText = new String(Files.readAllBytes(Paths.get(args[0])));		//store contents of text file into string
			System.out.println(getNumberOfValidPassPhrases(inputText));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

	public static int getNumberOfValidPassPhrases(String input) {
	
		LinkedList<String> wordsInPhrase = new LinkedList<String>();
		String wordBuffer = "";
		boolean phraseIsValid = true;
		int validPhraseCount = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ') {
				if(phraseIsValid)
					phraseIsValid = checkValidityOfPhrase(wordsInPhrase, wordBuffer);
				wordsInPhrase.add(wordBuffer);
				wordBuffer = "";
				
				continue;
			}
			
			if(input.charAt(i) == '\r') {
				for(int j = 0; j < wordsInPhrase.size(); j++) {
					System.out.print(wordsInPhrase.get(j) + ' ' + wordBuffer + ' ');
				}
				
				System.out.print("\r\n");
				
				if(phraseIsValid)
					phraseIsValid = checkValidityOfPhrase(wordsInPhrase, wordBuffer);
				wordsInPhrase.clear();
				wordBuffer = "";
				
				if(phraseIsValid)
					validPhraseCount++;
				
				i++;
				phraseIsValid = true;
				
				continue;
			}
			
			wordBuffer += input.charAt(i);
		}
		
		if(phraseIsValid)
			phraseIsValid = checkValidityOfPhrase(wordsInPhrase, wordBuffer);
		
		if(phraseIsValid)
			validPhraseCount++;
		
		return validPhraseCount;
	}
	
	public static boolean checkValidityOfPhrase(LinkedList<String> phrase, String lastWord) {
		
		for(int i = 0; i < phrase.size(); i++)
			if(phrase.get(i).equals(lastWord))
				return false;
		
		return true;
	}
}