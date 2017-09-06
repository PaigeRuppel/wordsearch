package com.paigeruppel.katas.wordsearch;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WordSearchApp {


	private static WordSearch wordSearch;
	private static TextFileReader textFileReader;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		System.out.println(
				"Please enter the name of the file you wish to search: \n(Note: Please save the file in src/main/resources in the proper format if you have not already done so)");
			List<String> wordsWithCoords = findWords(input.nextLine());
			for (String current : wordsWithCoords) {
				System.out.println(current);
			}		
			input.close();
		
	}

	public static String getFilename(String fileName) {
		return new FilePath().getFullFileName(fileName);
	}

	public static List<String> findWords(String filename) {
		textFileReader = new TextFileReader(getFilename(filename));
		List<String> listToFind = textFileReader.readFirstLine();
		char[][] toSearch = textFileReader.buildLetterGrid();
		wordSearch = new WordSearch(new LetterGrid(toSearch));
		return wordSearch.buildAnswerList(listToFind);
	}
}
