package com.paigeruppel.katas.wordsearch;

public class LeftToRightDiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public LeftToRightDiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	public String scanAlongColumns() {
		int ind = 0;
		int tries = 0;
		int start = 0;
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col < grid.colLength; row++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate();
					} else {
						ind++;
						if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar(ind)) {
							answer.reset();
							ind = 0;
						} else {
							col++;
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

	public String scanAlongRows() {
		int start = 1; // since row zero is scanned in alongColumn method
		int ind = 0;
		int tries = 0;
		while (tries < 2) {
			for (int row = start, col = 0; row < grid.rowLength && col < grid.colLength; col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate();
					} else {
						ind++;
						if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar(ind)) {
							answer.reset();
							ind = 0;
						} else {
							row++;
						}
					}
				}
			}
			if (start == grid.rowLength - 1) {
				start = 0;
				answer.reverseWord();
				tries++;
			} else {
				start++;
			}
		}
		return "";
	}

}
