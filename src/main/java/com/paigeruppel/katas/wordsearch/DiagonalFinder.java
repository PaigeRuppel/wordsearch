package com.paigeruppel.katas.wordsearch;

// to satisfy third and fourth user stories (and fifth)
public class DiagonalFinder implements Finder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	private int start;

	private static final String NOT_FOUND = "not found";

	public DiagonalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind, grid);
	}

	public String scan() {
		String formattedAnswer = NOT_FOUND;
		if (scanYAxisLookingRightToLeft() != NOT_FOUND) {
			formattedAnswer = scanYAxisLookingRightToLeft();
		} else if (scanXAxisLookingRightToLeft() != NOT_FOUND) {
			formattedAnswer = scanXAxisLookingRightToLeft();
		} else if (scanYAxisLookingLeftToRight() != NOT_FOUND) {
			formattedAnswer = scanYAxisLookingLeftToRight();
		} else if (scanXAxisLookingLeftToRight() != NOT_FOUND) {
			formattedAnswer = scanXAxisLookingLeftToRight();
		}

		return formattedAnswer;
	}

	public String scanXAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = start, y = 0; grid.withinEdges(x, y); x++, y++) {
				answer.lookForMatchAndBuildFormattedAnswerIfWordIsFound(x, y);
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return answer.getFormattedAnswer();
	}

	public String scanYAxisLookingLeftToRight() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = 0, y = start; grid.withinEdges(x, y); x++, y++) {
				answer.lookForMatchAndBuildFormattedAnswerIfWordIsFound(x, y);
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return answer.getFormattedAnswer();
	}

	public String scanXAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = start, y = 0; grid.withinEdges(x, y); x--, y++) {
				answer.lookForMatchAndBuildFormattedAnswerIfWordIsFound(x, y);
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return answer.getFormattedAnswer();
	}

	public String scanYAxisLookingRightToLeft() {
		clearAnswerSetStartAt0();
		while (answer.getTries() < 2) {
			for (int x = grid.getXLength() - 1, y = start; grid.withinEdges(x, y); x--, y++) {
				answer.lookForMatchAndBuildFormattedAnswerIfWordIsFound(x, y);
			}
			incrementStartingPositionOrReverseWordAndIncrementTries();
		}
		return answer.getFormattedAnswer();
	}

	private void clearAnswerSetStartAt0() {
		start = 0;
		answer.resetTries();
		answer.resetAnswerAndLetterIndexToZero();
		answer.forwardWord();
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

}
