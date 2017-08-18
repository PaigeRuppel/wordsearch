package com.paigeruppel.katas.wordsearch;

import java.util.List;

public class WordSearch {

	private LetterGrid grid;

	public WordSearch(LetterGrid grid) {
		this.grid = grid;
	}

	private HorizontalFinder horizontal;
	private VerticalFinder vertical;
	private DiagonalFinder diagonal;

	public String find(String toFind) {

		String answerWithCoords = "empty";

		buildFinders(toFind);

		String horizontalAnswer = horizontal.scan();
		String verticalAnswer = vertical.scan();
		String diagonalAnswer = diagonal.scan();

		if (horizontalAnswer != "not found") {
			answerWithCoords = horizontalAnswer;
		} else if (verticalAnswer != "not found") {
			answerWithCoords = verticalAnswer;
		} else if (diagonalAnswer != "not found") {
			answerWithCoords = diagonalAnswer;
		}
		return answerWithCoords;
	}

	private void buildFinders(String toFind) {
		diagonal = new DiagonalFinder(toFind, grid);
		horizontal = new HorizontalFinder(toFind, grid);
		vertical = new VerticalFinder(toFind, grid);
	}

	// another way to do this - return a list instead (don't have new lines)
	// move the print each new entry on new line to main
	// have a method in app?
	// main getFilename()
	// calls findWords
	// prints results
	// static List<String> findWords(String filename) - could write an apptest
	// around those methods in your app, but not around main
	public String findAll(List<String> listToFind) {
		String allWordsWithCoords = "";
		for (String toFind : listToFind) {
			String singleCoords = find(toFind);
			allWordsWithCoords += singleCoords + "\r\n";
		}

		return allWordsWithCoords;
	}

}
