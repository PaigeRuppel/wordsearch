package com.paigeruppel.katas.wordsearch;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WordSearchApp {

	private static WordSearch wordSearch;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		System.out.println(
				"Please enter the name of the file you wish to search: \n(Note: Please save the file in src/main/resources in the proper format if you have not already done so)");
		
		wordSearch = new WordSearch(input.nextLine());
		wordSearch.buildAnswerList();
		printFoundWords();
		
		input.close();

	}

	private static void printFoundWords() {
		List<String> foundWords = wordSearch.getFoundWordsWithCoords();
		for (String current : foundWords) {
			System.out.println(current);
		}
	}

}
