package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story
public class HorizontalFinder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.grid = grid;
		answer = new AnswerBuilder(toFind);
	}

	private int ind;
	private int tries;

	public String scan() {
		ind = 0;
		tries = 0;
		while (tries < 2) {
			for (int row = 0; row < grid.rowLength; row++) {
				for (int col = 0; col < grid.colLength; col++) {
					if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
						answer.buildAnswerList(ind, answer.coords(row, col));
						if (answer.atLastLetter(ind)) {
							return answer.generate(tries);
						}
						ind++;
						resetIfNextHorizontalCharNotPresent(row, col);
					}
				}
			}
			tries++;
			answer.reverseWord();
		}
		return "not found";
	}

	private void resetIfNextHorizontalCharNotPresent(int row, int col) {
		if (grid.getNextCharacterHorizontalFrom(row, col) != answer.currentChar(ind)) {
			answer.reset();
			ind = 0;
		}
	}


}
