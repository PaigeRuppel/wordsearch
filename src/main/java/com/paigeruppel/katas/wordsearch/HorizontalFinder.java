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
			for (int row = 0; row < grid.rowLength; row++) {
				for (int col = 0; col < grid.colLength; col++) {
					if (grid.getCharacterAt(row, col) == answer.currentChar()) {
						answer.buildAnswerList(answer.letterIndex, answer.coords(row, col));
						if (answer.atLastLetter()) {
							return answer.generate();
						}
						answer.incrementLetterIndex();
						resetIfNextHorizontalCharNotPresent(row, col);
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
			answer.reset();
		}
	}


}
