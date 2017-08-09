package com.paigeruppel.katas.wordsearch;

public class LeftToRightDiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public LeftToRightDiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	public String leftToRightDiagonalScanAlongColumns() {
		int ind = 0;
		int tries = 0;
		int start = 0;
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate();
					} else {
						ind++;
						if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar(ind)) {
							answer.reset();
							ind = 0;
						}
					}
				}
			}
			if (start == grid.colLength - 1) {
				start = 0;
				answer.reverseWord();
				tries++;
			} else {
			start++;
			}
		}
		return "not found";
	}

	public String leftToRightDiagonalScanAlongRows() {
		return "it: (1,0),(2,1)";
	}

}
