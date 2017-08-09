package com.paigeruppel.katas.wordsearch;

public class LeftToRightDiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public LeftToRightDiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	public String leftToRightDiagonalScan() {
//		int col = 0;
		int ind = 0;
		for (int row = 0, col = 0; row < grid.rowLength; row++, col++) {
			if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
				answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
				
				if (answer.maxInd(ind)) {
				return answer.generate();
				} else {
					ind++;
				}
		}

		}
		return "";
	}

}
