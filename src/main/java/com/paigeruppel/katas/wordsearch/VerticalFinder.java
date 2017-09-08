package com.paigeruppel.katas.wordsearch;

//To satisfy the second user story (and fifth)
public class VerticalFinder implements Finder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	private static final String NOT_FOUND = "not found";

	public VerticalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind, grid);
	}

	public String scan() {

		while (answer.getTries() < 2) {
			for (int x = 0; x < grid.getXLength(); x++) {
				for (int y = 0; y < grid.getYLength(); y++) {
					if (answer.isMatchAndAtLastLetter(x, y)) {
						return answer.buildAndReturnAnswer(x, y);
					} 

					answer.checkForMatchAndResetOrBuildAnswer(x, y);
				}
			}
			answer.reverseWord();
			answer.incrementTries();
		}
		return NOT_FOUND;

	}

	



}
