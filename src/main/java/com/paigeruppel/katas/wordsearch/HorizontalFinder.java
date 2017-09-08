package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story (and fifth)
public class HorizontalFinder implements Finder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind, grid);
	}

	public String scan() {
		while (answer.getTries() < 2) {
			for (int y = 0; y < grid.getYLength(); y++) {
				for (int x = 0; x < grid.getXLength(); x++) {
					answer.lookForMatchAndBuildFormattedAnswerIfWordIsFound(x, y);
				}
			}
			answer.incrementTries();
			answer.reverseWord();
		}

		return answer.getFormattedAnswer();
	}

	

}
