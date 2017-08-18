package com.paigeruppel.katas.wordsearch;

//To satisfy the second user story (and fifth)
public class VerticalFinder implements Finder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	public VerticalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind);
	}

	public String scan() {

		while (answer.tries < 2) {
			for (int x = 0; x < grid.colLength; x++) {
				for (int y = 0; y < grid.rowLength; y++) {
					if (grid.getCharacterAt(y, x) == answer.currentChar()) {
						answer.buildAnswerList(answer.getLetterIndex(), answer.coords(y, x));
						if (answer.atLastLetter()) {
							return answer.generate();

						} else {
							answer.incrementLetterIndex();
							resetIfNextVerticalCharNotPresent(x, y);
						}
					}
				}
			}
			answer.reverseWord();
			answer.incrementTries();
		}
		return "not found";
	}

	private void resetIfNextVerticalCharNotPresent(int x, int y) {
		if (grid.getNextCharacterVerticalFrom(x, y) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

}
