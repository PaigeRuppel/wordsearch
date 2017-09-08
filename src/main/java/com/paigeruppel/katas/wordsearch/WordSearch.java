package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	private TextFileReader textFileReader;
	private List<String> listToFind;
	private LetterGrid grid;
	
	private List<String> foundWordsWithCoords;
	private Finder[] finders;

	private static String NOT_FOUND = "not found";

	public WordSearch(String filename) {
		textFileReader = new TextFileReader(getFilename(filename));
		listToFind = textFileReader.readFirstLine();
		grid = new LetterGrid(textFileReader.buildLetterGrid());
	}
	
	public WordSearch (LetterGrid grid) {
		this.grid = grid;
	}
	
	public static String getFilename(String fileName) {
		return new FilePath().getFullFileName(fileName);
	}

	public void buildAnswerList() {
		foundWordsWithCoords = new ArrayList<String>();
		for (String toFind : listToFind) {
			String singleCoords = find(toFind);
			foundWordsWithCoords.add(singleCoords);
		}
	}

	public List<String> getFoundWordsWithCoords() {
		return foundWordsWithCoords;
	}

	private void buildFinders(String toFind) {
		finders = new Finder[] { new DiagonalFinder(toFind, grid), new HorizontalFinder(toFind, grid),
				new VerticalFinder(toFind, grid) };
	}

	public String find(String toFind) {
		String answerWithCoords = NOT_FOUND;
		buildFinders(toFind);
		for (Finder f : finders) {
			answerWithCoords = f.scan();
			if (answerWithCoords != NOT_FOUND) {
				return answerWithCoords;
			}
		}
		return answerWithCoords;
	}

}
