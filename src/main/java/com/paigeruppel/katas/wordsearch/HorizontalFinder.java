package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story
public class HorizontalFinder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind);
	}

	public String scan() {
		int ind = 0;
		int tries = 0;
		while (tries < 2) {
			for (int row = 0; row < grid.rowLength; row++) {
				for (int col = 0; col < grid.colLength; col++) {
					if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
						answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
						if (answer.maxInd(ind)) {
							return answer.generate();
						} else {
							ind = answer.increment(ind);
							if (grid.getNextCharacterHorizontalFrom(row, col) != answer.currentChar(ind)) {
								answer.reset();
								ind = 0;
							}
						}
					}
				}
			}
			tries++;
			answer.reverseWord();
		}
		return "not found";
	}

}
