package com.paigeruppel.katas.wordsearch;

public class DiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public DiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	private int ind;
	private int tries;
	private int start;

	public String scanAlongColumnsFromTopLeft() {
		ind = 0;
		tries = 0;
		start = 0;
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerList(ind, answer.coords(row, col));
					if (answer.maxInd(ind) && tries == 0) {
						return answer.generate();
					} else if (answer.maxInd(ind)) {
						return answer.generateReverse();
					}else {
						ind++;
						resetIfNextLToRDiagCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}

	public String scanAlongRowsFromTopLeft() {
		start = 1; // since row zero is scanned in alongColumn method
		ind = 0;
		tries = 0;
		while (tries < 2) {
			for (int row = start, col = 0; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerList(ind, answer.coords(row, col));
					if (answer.maxInd(ind) && tries == 0) {
						return answer.generate();
					} else if (answer.maxInd(ind)) {
						return answer.generateReverse();
					} else {
						ind++;
						resetIfNextLToRDiagCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}


	public String scanAlongColumnsFromTopRight() {
		start = grid.colLength - 1;
		ind = 0;

		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col > -1; row++, col--) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerList(ind, answer.coords(row, col));
					if (answer.maxInd(ind) && tries == 0) {
						return answer.generate();
					} else if (answer.maxInd(ind)) {
						return answer.generateReverse();
					} else {
						ind++;
						if (grid.getNextCharacterRToLDiagonalFrom(row, col) != answer.currentChar(ind)) {
							answer.reset();
							ind = 0;
						}
					}
				}
			}
			checkPositionAndDecrementStartOrReverseWord();
		}
		return "not found";
	}

	public Object scanAlongRowsFromTopRight() {
		start = 1;
		ind = 0;
		
		while(tries < 2) {
		for (int row = start, col = grid.colLength - 1; row < grid.rowLength && col > -1; row++, col--) {
			if (grid.getCharacterAt(row, col) == answer.currentChar(ind) ) {
				answer.buildAnswerList(ind, answer.coords(row, col));
				if (answer.maxInd(ind) && tries == 0) {
					return answer.generate();
				} else if (answer.maxInd(ind)) {
					return answer.generateReverse();
				} else {
					ind++;
					if (grid.getNextCharacterRToLDiagonalFrom(row, col) != answer.currentChar(ind)) {
						answer.reset();
						ind = 0;
					}
				}
			}
		}
		checkPositionAndIncrementStartOrReverseWord();
		}
		
		return "";
	}

	private void checkPositionAndDecrementStartOrReverseWord() {
		if (start == 0) {
			start = grid.colLength - 1;
			answer.reverseWord();
			tries++;
		} else {
			start--;
		}
	}
	
	private void checkPositionAndIncrementStartOrReverseWord() {
		if (start == grid.colLength - 1) {
			start = 0;
			answer.reverseWord();
			tries++;
		} else {
			start++;
		}
	}
	
	private void resetIfNextLToRDiagCharNotPresent(int row, int col) {
		if (grid.getNextCharacterLToRDiagonalFrom(row, col) != answer.currentChar(ind)) {
			answer.reset();
			ind = 0;
		}
	}

}
