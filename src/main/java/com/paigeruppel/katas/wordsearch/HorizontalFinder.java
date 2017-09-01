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
					if (grid.getCharacterAt(y, x) == answer.currentChar() && answer.atLastLetter()) {
						answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
						return answer.generate();
					} else if (grid.getCharacterAt(y, x) == answer.currentChar()) {
						answer.buildAnswerList(answer.getLetterIndex(), answer.coords(x, y));
						answer.incrementLetterIndex();
						// TODO still some nesting here - revisit
						resetIfNextHorizontalCharNotPresent(x, y);
					}
				}
			}
			answer.incrementTries();
			answer.reverseWord();
		}

		return NOT_FOUND;
	}

	private void resetIfNextHorizontalCharNotPresent(int x, int y) {
		if (grid.getNextCharacterHorizontalFrom(y, x) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

}
