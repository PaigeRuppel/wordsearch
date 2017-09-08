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
		
		printFoundWords(wordsWithCoords);
		
		input.close();

	}

	private static void printFoundWords(List<String> wordsWithCoords) {
		for (String current : wordsWithCoords) {
			System.out.println(current);
		}
	}

	public static List<String> findWords(String filename) {
		wordSearch = new WordSearch(filename);
		wordSearch.buildAnswerList();
		return wordSearch.getFoundWordsWithCoords();
	}
}
