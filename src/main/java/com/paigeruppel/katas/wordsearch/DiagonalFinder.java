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
		answer.resetAnswerAndLetterIndexToZero();
		answer.forwardWord();
	}

	public String scanXAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int yAxis = 0, xAxis = start; grid.withinEdges(yAxis, xAxis); yAxis++, xAxis++) {
				if (matchFound(yAxis, xAxis)) {
					answer.buildAnswerList(answer.letterIndex, answer.coords(yAxis, xAxis));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(yAxis, xAxis);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanYAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int yAxis = start, xAxis = 0; grid.withinEdges(yAxis, xAxis); yAxis++, xAxis++) {
				if (matchFound(yAxis, xAxis)) {
					answer.buildAnswerList(answer.letterIndex, answer.coords(yAxis, xAxis));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(yAxis, xAxis);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanXAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int yAxis = 0, xAxis = start; grid.withinEdges(yAxis, xAxis); yAxis++, xAxis--) {
				if (matchFound(yAxis, xAxis)) {
					answer.buildAnswerList(answer.letterIndex, answer.coords(yAxis, xAxis));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(yAxis, xAxis);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanYAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.tries < 2) {
			for (int yAxis = start, xAxis = grid.colLength - 1; grid.withinEdges(yAxis, xAxis); yAxis++, xAxis--) {
				if (matchFound(yAxis, xAxis)) {
					answer.buildAnswerList(answer.letterIndex, answer.coords(yAxis, xAxis));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(yAxis, xAxis);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	private void resetIfNextRToLCharNotPresent(int row, int col) {
		if (grid.getNextCharacterRToLDiagonalFrom(row, col) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

	private boolean matchFound(int row, int col) {
		return grid.getCharacterAt(row, col) == answer.currentChar();
	}

	private void incrementStartingPositionOrReverseWordAndIncrementTries() {
		if (start == grid.colLength - 1) {
			start = 0;
			answer.reverseWord();
			answer.resetAnswerAndLetterIndexToZero();
			answer.incrementTries();
		} else {
			start++;
		}
	}

	private void resetIfNextLToRDiagCharNotPresent(int row, int col) {
		if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

	public String scan() {
		String answer = "not found";

		if (scanYAxisLookingRightToLeft() != "not found") {
			answer = scanYAxisLookingRightToLeft();
		} else if (scanXAxisLookingRightToLeft() != "not found") {
			answer = scanXAxisLookingRightToLeft();
		} else if (scanYAxisLookingLeftToRight() != "not found") {
			answer = scanYAxisLookingLeftToRight();
		} else if (scanXAxisLookingLeftToRight() != "not found") {
			answer = scanXAxisLookingLeftToRight();
		}

		return answer;
	}
}
