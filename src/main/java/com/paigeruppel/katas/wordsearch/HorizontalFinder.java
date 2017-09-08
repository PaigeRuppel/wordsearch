package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story (and fifth)
public class HorizontalFinder implements Finder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	private static final String NOT_FOUND = "not found";

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind, grid);
	}

	public String scan() {

		while (answer.getTries() < 2) {
			for (int y = 0; y < grid.getYLength(); y++) {
				for (int x = 0; x < grid.getXLength(); x++) {
					if (answer.isMatchAndAtLastLetter(x, y)) {
						return answer.buildAndReturnAnswer(x, y);
					} 

					checkForMatchAndResetOrBuildAnswer(x, y);
				}
			}
			answer.incrementTries();
			answer.reverseWord();
		}

		return NOT_FOUND;
	}

	private void checkForMatchAndResetOrBuildAnswer(int x, int y) {
		if (!answer.isMatch(x, y)) {
			answer.resetAnswerAndLetterIndexToZero();
		}
		
		if (answer.isMatch(x, y)) {
			answer.buildAnswerAndIncrementLetterIndex(x, y);
		}
	}

	

}
