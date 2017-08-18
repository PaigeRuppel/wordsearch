package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story (and fifth)
public class HorizontalFinder implements Finder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind);
	}

	public String scan() {

		while (answer.getTries() < 2) {
			for (int y = 0; y < grid.getYLength(); y++) {
				for (int x = 0; x < grid.getXLength(); x++) {
					if (grid.getCharacterAt(y, x) == answer.currentChar()) {
						answer.buildAnswerList(answer.getLetterIndex(), answer.coords(y, x));
						if (answer.atLastLetter()) {
							return answer.generate();
						}
						answer.incrementLetterIndex();
						resetIfNextHorizontalCharNotPresent(x, y);
					}
				}
			}
			answer.incrementTries();
			answer.reverseWord();
		}
	
		return "not found";
	}

	private void resetIfNextHorizontalCharNotPresent(int x, int y) {
		if (grid.getNextCharacterHorizontalFrom(y, x) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}


}
