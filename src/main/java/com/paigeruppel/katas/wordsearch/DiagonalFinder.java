package com.paigeruppel.katas.wordsearch;

public class DiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public DiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	private int ind;
	private int tries;
	private int start;

	public String scanAlongColumnsLeftToRight() {
		ind = 0;
		tries = 0;
		start = 0;
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate();
					} else {
						ind++;
						resetIfNextCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndContinueOrReverseWord();
		}
		return "not found";
	}

	public String scanAlongRowsTopToBottom() {
		start = 1; // since row zero is scanned in alongColumn method
		ind = 0;
		tries = 0;
		while (tries < 2) {
			for (int row = start, col = 0; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate();
					} else {
						ind++;
						resetIfNextCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndContinueOrReverseWord();
		}
		return "not found";
	}

	private void checkPositionAndContinueOrReverseWord() {
		if (start == grid.colLength - 1) {
			start = 0;
			answer.reverseWord();
			tries++;
		} else {
			start++;
		}
	}

	private void resetIfNextCharNotPresent(int row, int col) {
		if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar(ind)) {
			answer.reset();
			ind = 0;
		}
	}
}
