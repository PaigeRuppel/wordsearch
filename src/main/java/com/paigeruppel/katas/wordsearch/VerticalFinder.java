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
		int ind = 0;

		for (int col = 0; col < grid.colLength; col++) {
			for (int row = 0; row < grid.rowLength; row++) {
				if (grid.getCharacterAt(row, col) == toFind.charAt(ind)) {
					answer.buildAnswerMap(toFind.charAt(ind), "(" + row + "," + col + ")");
					if (ind < toFind.length() - 1) {
						ind++;
					}
				}

			}

		}
		return answer.generate();

	}

}
