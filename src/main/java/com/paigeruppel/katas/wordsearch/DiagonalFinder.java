package com.paigeruppel.katas.wordsearch;

// to satisfy third and fourth user stories
public class DiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public DiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	private int start;

	private void clearAnswerSetStartAt0() {
		start = 0;
		answer.tries = 0;
		answer.reset();
		answer.forwardWord();
	}

	public String scanColumnsLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int row = 0, col = start; grid.withinEdges(row, col); row++, col++) {
				if (matchFound(row, col)) {
					answer.buildAnswerList(answer.coords(row, col));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(row, col);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanRowsLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int row = start, col = 0; grid.withinEdges(row, col); row++, col++) {
				if (matchFound(row, col)) {
					answer.buildAnswerList(answer.coords(row, col));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(row, col);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanColumnsLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int row = 0, col = start; grid.withinEdges(row, col); row++, col--) {
				if (matchFound(row, col)) {
					answer.buildAnswerList(answer.coords(row, col));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(row, col);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanRowsLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int row = start, col = grid.colLength - 1; grid.withinEdges(row, col); row++, col--) {
				if (matchFound(row, col)) {
					answer.buildAnswerList(answer.coords(row, col));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(row, col);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}


	private void resetIfNextRToLCharNotPresent(int row, int col) {
		if (grid.getNextCharacterRToLDiagonalFrom(row, col) != answer.currentChar()) {
			answer.reset();
		}
	}

	private boolean matchFound(int row, int col) {
		return grid.getCharacterAt(row, col) == answer.currentChar();
	}

	private void incrementStartingPositionOrReverseWordAndIncrementTries() {
		if (start == grid.colLength - 1) {
			start = 0;
			answer.reverseWord();
			answer.reset();
			answer.incrementTries();
		} else {
			start++;
		}
	}

	private void resetIfNextLToRDiagCharNotPresent(int row, int col) {
		if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar()) {
			answer.reset();
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
