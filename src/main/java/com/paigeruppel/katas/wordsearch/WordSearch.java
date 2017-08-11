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

		String answer = "";
		
		diagonal = new DiagonalFinder(toFind, grid);
		horizontal = new HorizontalFinder(toFind, grid);
		vertical = new VerticalFinder(toFind, grid);

		if (horizontal.scan() != "not found") {
			return horizontal.scan();
		} else if (vertical.scan() != "not found") {
			return vertical.scan().toString();
		} else if (diagonal.scan() != "not found") {
			return diagonal.scan();
		}
		return answer;
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
