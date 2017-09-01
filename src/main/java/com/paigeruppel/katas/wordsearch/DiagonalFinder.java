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
				if (!isMatch(x, y) && answer.getLetterIndex() > 0) {
					answer.resetAnswerAndLetterIndexToZero();
				} else if (isMatchAndAtLastLetter(x, y)) {
					return buildAndReturnAnswer(x, y);
				} else if (isMatch(x, y)) {
					buildAnswerAndCheckForNextLToRDiagChar(x, y);
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
				if (!isMatch(x, y) && answer.getLetterIndex() > 0) {
					answer.resetAnswerAndLetterIndexToZero();
				} else if (isMatchAndAtLastLetter(x, y)) {
					return buildAndReturnAnswer(x, y);
				} else if (isMatch(x, y)) {
					buildAnswerAndCheckForNextLToRDiagChar(x, y);
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
				if (!isMatch(x, y) && answer.getLetterIndex() > 0) {
					answer.resetAnswerAndLetterIndexToZero();
				} else if (isMatchAndAtLastLetter(x, y)) {
					return buildAndReturnAnswer(x, y);
				} else if (isMatch(x, y)) {
					buildAnswerAndCheckForNextRToLDiagChar(x, y);
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
				//TODO think about whether it is necessary to include second letterIndex condition here
				if (!isMatch(x, y) && answer.getLetterIndex() > 0) {
					answer.resetAnswerAndLetterIndexToZero();
				} else if (isMatchAndAtLastLetter(x, y)) {
					return buildAndReturnAnswer(x, y);
				} else if (isMatch(x, y)) {
					buildAnswerAndCheckForNextRToLDiagChar(x, y);
				}
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return NOT_FOUND;
	}

	private void buildAnswerAndCheckForNextLToRDiagChar(int x, int y) {
		answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
		answer.incrementLetterIndex();
//		resetIfNextLToRDiagCharNotPresent(y, x);
	}

	private void buildAnswerAndCheckForNextRToLDiagChar(int x, int y) {
		answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
		answer.incrementLetterIndex();
//		resetIfNextRToLCharNotPresent(y, x);
	}

	private String buildAndReturnAnswer(int x, int y) {
		answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
		return answer.generate();
	}

	private boolean isMatchAndAtLastLetter(int x, int y) {
		return isMatch(x, y) && answer.atLastLetter();
	}

	private void resetIfNextRToLCharNotPresent(int y, int x) {
		if (grid.getNextCharacterRToLDiagonalFrom(y, x) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

	private boolean isMatch(int x, int y) {
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
