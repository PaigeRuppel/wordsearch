package com.paigeruppel.katas.wordsearch;

//To satisfy the second user story
public class VerticalFinder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	public VerticalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind);
	}

	public String scan() {

		while (answer.tries < 2) {
			for (int col = 0; col < grid.colLength; col++) {
				for (int row = 0; row < grid.rowLength; row++) {
					if (grid.getCharacterAt(row, col) == answer.currentChar()) {
						answer.buildAnswerList(answer.letterIndex, answer.coords(row, col));
						if (answer.atLastLetter()) {
							
							return answer.generate();
						
						} else {
							answer.incrementLetterIndex();
							resetIfNextVerticalCharNotPresent(col, row);
						}
					}
				}
			}
			answer.reverseWord();
			answer.incrementTries();
		}
		return "not found";
	}

	private void resetIfNextVerticalCharNotPresent(int col, int row) {
		if (grid.getNextCharacterVerticalFrom(row, col) != answer.currentChar()) {
			answer.resetAnswerAndLetterIndexToZero();
		}
	}

}
