package com.paigeruppel.katas.wordsearch;

public class VerticalFinder {

	private String toFind;
	private LetterGrid grid;

	private AnswerBuilder answer;

	public VerticalFinder(String toFind, LetterGrid grid) {
		this.toFind = toFind;
		this.grid = grid;

		answer = new AnswerBuilder(toFind);
	}

	public String verticalScan() {

		for (int col = 0; col < grid.colLength; col++) {

			if (grid.getCharacterAt(0, col) == toFind.charAt(0)) {
				answer.buildAnswerMap(toFind.charAt(0), "(0,"+ col + ")");
				answer.buildAnswerMap(toFind.charAt(1), "(1,"+ col + ")");
				answer.buildAnswerMap(toFind.charAt(2), "(2,"+ col + ")");
 			}

		}
		return answer.generate();

	}

}
