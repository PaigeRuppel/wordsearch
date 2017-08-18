package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	private LetterGrid grid;

	public WordSearch(LetterGrid grid) {
		this.grid = grid;
	}

	private Finder[] finders;

	public String find(String toFind) {

		String answerWithCoords = "empty";

		buildFinders(toFind);
		for (Finder f: finders) {
			answerWithCoords = f.scan();
			if (answerWithCoords != "not found" ) {
				return answerWithCoords;
			}
		}
		return answerWithCoords;
	}

	private void buildFinders(String toFind) {
		finders = new Finder[] { new DiagonalFinder(toFind, grid), new HorizontalFinder(toFind, grid),
				new VerticalFinder(toFind, grid) };
	}

	// another way to do this - return a list instead (don't have new lines)
	// move the print each new entry on new line to main
	// have a method in app?
	// main getFilename()
	// calls findWords
	// prints results
	// static List<String> findWords(String filename) - could write an apptest
	// around those methods in your app, but not around main
	private List<String> allWordsWithCoords = new ArrayList<String>();
	public List<String> findAll(List<String> listToFind) {
		for (String toFind : listToFind) {
			String singleCoords = find(toFind);
			allWordsWithCoords.add(singleCoords);
		}

		return allWordsWithCoords;
	}

}
