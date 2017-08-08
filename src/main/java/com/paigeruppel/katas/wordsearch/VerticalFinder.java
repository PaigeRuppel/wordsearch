package com.paigeruppel.katas.wordsearch;

public class VerticalFinder {

	private LetterGrid grid;
	private AnswerBuilder answer;

	public VerticalFinder(String toFind, LetterGrid grid) {

		this.grid = grid;

		answer = new AnswerBuilder(toFind);
	}

	public String verticalScan() {
		int ind = 0;

		for (int col = 0; col < grid.colLength; col++) {
			for (int row = 0; row < grid.rowLength; row++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerMap(answer.currentChar(ind), answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate();
					} else {
						ind = answer.increment(ind);
						if (grid.getNextCharacterVerticalFrom(row, col) != answer.currentChar(ind)) {
							answer.reset();
							ind = 0;
						}
					}

				}

			}

		}
		return answer.generate();
	}
}
