package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story (and fifth)
public class HorizontalFinder implements Finder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	private static final String NOT_FOUND = "not found";

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind);
	}

	public String scan() {

		while (answer.getTries() < 2) {
			for (int y = 0; y < grid.getYLength(); y++) {
				for (int x = 0; x < grid.getXLength(); x++) {
					if (!isMatch(x, y)) {
						answer.resetAnswerAndLetterIndexToZero();	
					}
					if (isMatchAndAtLastLetter(x, y)) {
						return answer.buildAndReturnAnswer(x, y);
					} else if (isMatch(x, y)) {
						answer.buildAnswerAndIncrementLetterIndex(x, y);
					}
				}
			}
			answer.incrementTries();
			answer.reverseWord();
		}

		return NOT_FOUND;
	}

	public boolean isMatch(int x, int y) {
		return grid.charAt(y, x) == answer.currentChar();
	}

	public boolean isMatchAndAtLastLetter(int x, int y) {
		return isMatch(x, y) && answer.atLastLetter();
	}

	

}
