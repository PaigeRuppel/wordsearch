package com.paigeruppel.katas.wordsearch;

import java.util.List;
import java.util.Scanner;

public class WordSearchApp {

	private static final String FILE_PATH = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\";
	
	private static LetterGrid grid;
	private static WordSearch wordSearch;
	private static TextFileReader textFileReader;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		writeLine(
				"Please enter the name of the file you wish to search: \n(Note: Please save the file in src/main/resources in the proper format if you have not already done so)");

		textFileReader = new TextFileReader(getFilename(input.nextLine()));


//
//		writeLine(wordSearch.findAll(listToFind));

	}

	// move the print each new entry on new line to main
	// have a method in app?
	// main getFilename()
	public static String getFilename(String filename) {
		return FILE_PATH + filename;
	}

	public static List<String> findWords(String filename) {
		textFileReader = new TextFileReader(getFilename(filename));
		List<String> listToFind = textFileReader.readFirstLine();
		char[][] toSearch = textFileReader.buildLetterGrid();

		wordSearch = new WordSearch(new LetterGrid(toSearch));
		return wordSearch.findAll(listToFind);
	}
	// static List<String> findWords(String filename) - could write an apptest
	// around those methods in your app, but not around main

	public static void writeLine(String message) {
		System.out.println(message);
	}
}
