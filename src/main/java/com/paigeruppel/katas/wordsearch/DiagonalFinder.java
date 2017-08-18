package com.paigeruppel.katas.wordsearch;

// to satisfy third and fourth user stories (and fifth)
public class DiagonalFinder implements Finder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public DiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	private int start;

	private void clearAnswerSetStartAt0() {
		start = 0;
		answer.setTries(0);
		answer.resetAnswerAndLetterIndexToZero();
		answer.forwardWord();
	}

	public String scanXAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int y = 0, x = start; grid.withinEdges(y, x); y++, x++) {
				if (matchFound(y, x)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(y, x));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanYAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int y = start, x = 0; grid.withinEdges(y, x); y++, x++) {
				if (matchFound(y, x)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(y, x));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanXAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int y = 0, x = start; grid.withinEdges(y, x); y++, x--) {
				if (matchFound(y, x)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(y, x));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	public String scanYAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int y = start, x = grid.colLength - 1; grid.withinEdges(y, x); y++, x--) {
				if (matchFound(y, x)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(y, x));
					if (answer.atLastLetter()) {
						return answer.generate();
					}
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return "not found";
	}

	private void resetIfNextRToLCharNotPresent(int y, int x) {
		if (grid.getNextCharacterRToLDiagonalFrom(y, x) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

	private boolean matchFound(int y, int x) {
		return grid.getCharacterAt(y, x) == answer.currentChar();
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

	private void resetIfNextLToRDiagCharNotPresent(int y, int x) {
		if (grid.getNextCharacterLToRDiagonalFrom(y, x) != answer.currentChar()) {
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
