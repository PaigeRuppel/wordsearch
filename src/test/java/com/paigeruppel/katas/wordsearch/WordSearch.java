package com.paigeruppel.katas.wordsearch;

public class WordSearch {

	private LetterGrid grid;

	// private String toFind;

	public WordSearch(LetterGrid grid) {
		this.grid = grid;
	}

	private HorizontalFinder horizontal;
	private VerticalFinder vertical;
	private DiagonalFinder diagonal;

	public String find(String toFind) {

		String answer = "";
		diagonal = new DiagonalFinder(toFind, grid);
		horizontal = new HorizontalFinder(toFind, grid);
		vertical = new VerticalFinder(toFind, grid);

		if (horizontal.scan() != "not found") {
			answer = horizontal.scan();
		}  else if (vertical.scan() != "not found") {
			answer = vertical.scan();
		} else if (diagonal.scanAlongRowsFromTopRight() != "not found") {
			answer = diagonal.scanAlongRowsFromTopRight();
		} else if (diagonal.scanAlongColumnsFromTopLeft() != "not found") {
			answer = diagonal.scanAlongColumnsFromTopLeft();
		}

		return answer;
	}

}
