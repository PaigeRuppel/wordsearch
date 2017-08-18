package com.paigeruppel.katas.wordsearch;


import java.util.ArrayList;
import java.util.Scanner;

public class WordSearchApp {

	public static void main(String[] args) {
		LetterGrid grid;
		WordSearch wordSearch;
		TextFileReader textFileReader;

		String path = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\";

		Scanner input = new Scanner(System.in);

		writeLine(
				"Please enter the name of the file you wish to search: \n(Note: Please save the file in src/main/resources in the proper format if you have not already done so)");

		String textFile = input.nextLine();

		textFileReader = new TextFileReader(path + textFile);
		ArrayList<String> listToFind = textFileReader.readFirstLine();
		char[][] toSearch = textFileReader.buildLetterGrid();

		wordSearch = new WordSearch(new LetterGrid(toSearch));
	
		writeLine(wordSearch.findAll(listToFind));

	}

	public static void writeLine(String message) {
		System.out.println(message);
	}
}
