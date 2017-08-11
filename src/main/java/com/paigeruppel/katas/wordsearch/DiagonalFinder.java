package com.paigeruppel.katas.wordsearch;

public class DiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public DiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	public DiagonalFinder(LetterGrid grid) {
		this.grid = grid;
	}

	public DiagonalFinder() {
	}

	private int letterIndex;
	private int tries;
	private int start;

	private void resetAll() {
		letterIndex = 0;
		tries = 0;
		start = 0;
		answer.resetHolder();
	}

	public String scanColumnsLookingLeftToRight() {
		resetAll();
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (matchFound(row, col)) {
					appendCoordsToAnswer(row, col);
					if (answer.maxInd(letterIndex)) {
						return answer.generate(tries);
					}
					letterIndex++;
					resetIfNextLToRDiagCharNotPresent(row, col);
				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}

	public String scanRowsLookingLeftToRight() {
		resetAll();
		while (tries < 2) {
			for (int row = start, col = 0; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (matchFound(row, col)) {
					appendCoordsToAnswer(row, col);
					if (answer.maxInd(letterIndex)) {
						return answer.generate(tries);
					}
					letterIndex++;
					resetIfNextLToRDiagCharNotPresent(row, col);
				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}

	public String scanColumnsLookingRightToLeft() {
		resetAll();
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col > -1; row++, col--) {
				if (matchFound(row, col)) {
					appendCoordsToAnswer(row, col);
					if (answer.maxInd(letterIndex)) {
						return answer.generate(tries);
					} else {
						letterIndex++;
						resetIfNextRToLCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}

	public String scanRowsLookingRightToLeft() {
		resetAll();
		while (tries < 2) {
			for (int row = start, col = grid.colLength - 1; row < grid.rowLength && col > -1; row++, col--) {
				if (matchFound(row, col)) {
					appendCoordsToAnswer(row, col);
					if (answer.maxInd(letterIndex)) {
						return answer.generate(tries);
					} else {
						letterIndex++;
						resetIfNextRToLCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}

	private void appendCoordsToAnswer(int row, int col) {
		answer.buildAnswerList(letterIndex, answer.coords(row, col));
	}

	private void resetIfNextRToLCharNotPresent(int row, int col) {
		if (grid.getNextCharacterRToLDiagonalFrom(row, col) != answer.currentChar(letterIndex)) {
			answer.reset();
			letterIndex = 0;
		}
	}

	private boolean matchFound(int row, int col) {
		return grid.getCharacterAt(row, col) == answer.currentChar(letterIndex);
	}

	private void checkPositionAndIncrementStartOrReverseWord() {
		if (start == grid.colLength - 1) {
			start = 0;
			answer.reverseWord();
			tries++;
		} else {
			start++;
		}
	}

	private void resetIfNextLToRDiagCharNotPresent(int row, int col) {
		if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar(letterIndex)) {
			answer.reset();
			letterIndex = 0;
		}
	}

	public String scan() {
		String answer = "not found";

		if (scanRowsLookingRightToLeft() != "not found") {
			answer = scanRowsLookingRightToLeft();
		} else if (scanColumnsLookingRightToLeft() != "not found") {
			answer = scanColumnsLookingRightToLeft();
		} else if (scanRowsLookingLeftToRight() != "not found") {
			answer = scanRowsLookingLeftToRight();
		} else if (scanColumnsLookingLeftToRight() != "not found") {
			answer = scanColumnsLookingLeftToRight();
		}

		return answer;
	}
}
