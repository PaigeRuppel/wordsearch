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
			for (int yAxis = 0; yAxis < grid.rowLength; yAxis++) {
				for (int xAxis = 0; xAxis < grid.colLength; xAxis++) {
					if (grid.getCharacterAt(yAxis, xAxis) == answer.currentChar()) {
						answer.buildAnswerList(answer.letterIndex, answer.coords(yAxis, xAxis));
						if (answer.atLastLetter()) {
							return answer.generate();
						}
						answer.incrementLetterIndex();
						resetIfNextHorizontalCharNotPresent(yAxis, xAxis);
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
