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
					if (grid.getCharacterAt(y, x) == answer.currentChar() && answer.atLastLetter()) {
						answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
						return answer.generate();
					} else if (grid.getCharacterAt(y, x) == answer.currentChar()) {
						answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
						answer.incrementLetterIndex();
						// TODO think about addressing nesting here...
						resetIfNextVerticalCharNotPresent(x, y);
					}
				}
			}
			answer.reverseWord();
			answer.incrementTries();
		}
		return NOT_FOUND;

	}

	private void resetIfNextVerticalCharNotPresent(int x, int y) {
		if (grid.getNextCharacterVerticalFrom(x, y) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

}
