package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;

public class WordSearch {

	private LetterGrid grid;


	public WordSearch(LetterGrid grid) {
		this.grid = grid;
	}

	private HorizontalFinder horizontal;
	private VerticalFinder vertical;
	private DiagonalFinder diagonal;

	public String find(String toFind) {

		String answerWithCoords = "";
		
		diagonal = new DiagonalFinder(toFind, grid);
		horizontal = new HorizontalFinder(toFind, grid);
		vertical = new VerticalFinder(toFind, grid);

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

	public String findAll(ArrayList<String> listToFind) {
		String allWordsWithCoords = "";
		for (String toFind: listToFind) {
		String singleCoords = find(toFind);
		allWordsWithCoords += singleCoords + "\r\n";
		}
		
		return allWordsWithCoords;
	}

}
