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

		while (answer.tries < 2) {
			for (int y = 0; y < grid.rowLength; y++) {
				for (int x = 0; x < grid.colLength; x++) {
					if (grid.getCharacterAt(y, x) == answer.currentChar()) {
						answer.buildAnswerList(answer.letterIndex, answer.coords(y, x));
						if (answer.atLastLetter()) {
							return answer.generate();
						}
						answer.incrementLetterIndex();
						resetIfNextHorizontalCharNotPresent(y, x);
					}
				}
			}
			answer.incrementTries();
			answer.reverseWord();
		}
	
		return "not found";
	}

	private void resetIfNextHorizontalCharNotPresent(int row, int col) {
		if (grid.getNextCharacterHorizontalFrom(row, col) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}


}
