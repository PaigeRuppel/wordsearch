package com.paigeruppel.katas.wordsearch;

//To satisfy the second user story (and fifth)
public class VerticalFinder implements Finder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	private static final String NOT_FOUND = "not found";

	public VerticalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind);
	}

	public String scan() {

		while (answer.getTries() < 2) {
			for (int x = 0; x < grid.getXLength(); x++) {
				for (int y = 0; y < grid.getYLength(); y++) {
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
			answer.reverseWord();
			answer.incrementTries();
		}
		return NOT_FOUND;

	}

	private boolean isMatch(int x, int y) {
		return grid.getCharacterAt(y, x) == answer.currentChar();
	}

	private boolean isMatchAndAtLastLetter(int x, int y) {
		return isMatch(x, y) && answer.atLastLetter();
	}
	



}
