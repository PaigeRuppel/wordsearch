package com.paigeruppel.katas.wordsearch;

// to satisfy third and fourth user stories (and fifth)
public class DiagonalFinder implements Finder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	private static final String NOT_FOUND = "not found";

	public DiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	private int start;

	private void clearAnswerSetStartAt0() {
		start = 0;
		answer.resetTries();
		answer.resetAnswerAndLetterIndexToZero();
		answer.forwardWord();
	}

	public String scanXAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = start, y = 0; grid.withinEdges(x, y); x++, y++) {
				if (matchFound(x, y) && answer.atLastLetter()) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					return answer.generate();
				} else if (matchFound(x, y)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return NOT_FOUND;
	}

	public String scanYAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = 0, y = start; grid.withinEdges(x, y); x++, y++) {
				if (matchFound(x, y) && answer.atLastLetter()) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					return answer.generate();
				} else if (matchFound(x, y)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					answer.incrementLetterIndex();
					resetIfNextLToRDiagCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return NOT_FOUND;
	}

	public String scanXAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = start, y = 0; grid.withinEdges(x, y); x--, y++) {
				if (matchFound(x, y) && answer.atLastLetter()) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					return answer.generate();
				} else if (matchFound(x, y)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return NOT_FOUND;
	}

	public String scanYAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = grid.getXLength() - 1, y = start; grid.withinEdges(x, y); x--, y++) {
				if (matchFound(x, y) && answer.atLastLetter()) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					return answer.generate();
				} else if (matchFound(x, y)) {
					answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
					answer.incrementLetterIndex();
					resetIfNextRToLCharNotPresent(y, x);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return NOT_FOUND;
	}

	private void resetIfNextRToLCharNotPresent(int y, int x) {
		if (grid.getNextCharacterRToLDiagonalFrom(y, x) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

	private boolean matchFound(int x, int y) {
		return grid.getCharacterAt(y, x) == answer.currentChar();
	}

	private void incrementStartingPositionOrReverseWordAndIncrementTries() {
		if (start == grid.getXLength() - 1) {
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
		String answer = NOT_FOUND;
		if (scanYAxisLookingRightToLeft() != NOT_FOUND) {
			answer = scanYAxisLookingRightToLeft();
		} else if (scanXAxisLookingRightToLeft() != NOT_FOUND) {
			answer = scanXAxisLookingRightToLeft();
		} else if (scanYAxisLookingLeftToRight() != NOT_FOUND) {
			answer = scanYAxisLookingLeftToRight();
		} else if (scanXAxisLookingLeftToRight() != NOT_FOUND) {
			answer = scanXAxisLookingLeftToRight();
		}

		return answer;
	}
}
