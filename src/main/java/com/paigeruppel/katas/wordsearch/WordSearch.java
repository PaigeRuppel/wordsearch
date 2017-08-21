package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	private LetterGrid grid;
	private List<String> allWordsWithCoords = new ArrayList<String>();

	public WordSearch(LetterGrid grid) {
		this.grid = grid;
	}

	private Finder[] finders;

	public String find(String toFind) {

		String answerWithCoords = "empty";

		buildFinders(toFind);
		for (Finder f : finders) {
			answerWithCoords = f.scan();
			if (answerWithCoords != "not found") {
				return answerWithCoords;
			}
		}
		return answerWithCoords;
	}

	private void buildFinders(String toFind) {
		finders = new Finder[] { new DiagonalFinder(toFind, grid), new HorizontalFinder(toFind, grid),
				new VerticalFinder(toFind, grid) };
	}

	public List<String> findAll(List<String> listToFind) {
		for (String toFind : listToFind) {
			String singleCoords = find(toFind);
			allWordsWithCoords.add(singleCoords);
		}

		return allWordsWithCoords;
	}

}
