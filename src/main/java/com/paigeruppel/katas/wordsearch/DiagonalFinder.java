package com.paigeruppel.katas.wordsearch;

public class DiagonalFinder {

	private AnswerBuilder answer;
	private LetterGrid grid;

	public DiagonalFinder(String toFind, LetterGrid grid) {
		answer = new AnswerBuilder(toFind);
		this.grid = grid;
	}

	public DiagonalFinder(LetterGrid grid) {
		this.grid = grid;
	}

	public DiagonalFinder() {
	}

	private int ind;
	private int tries;
	private int start;


	public String scanAlongColumnsFromTopLeft() {
		ind = 0;
		tries = 0;
		start = 0;
		answer.resetHolder();
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerList(ind, answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate(tries); 
					}
					ind++;
					resetIfNextLToRDiagCharNotPresent(row, col);

				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}


	public String scanAlongRowsFromTopLeft() {
		start = 1; 
		ind = 0;
		tries = 0;
		answer.resetHolder();
		while (tries < 2) {
			for (int row = start, col = 0; row < grid.rowLength && col < grid.colLength; row++, col++) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerList(ind, answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate(tries);
					}
					ind++;
					resetIfNextLToRDiagCharNotPresent(row, col);

				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}

	public String scanAlongColumnsFromTopRight() {
		start = grid.colLength - 1;
		ind = 0;
		tries = 0;
		answer.resetHolder();
		while (tries < 2) {
			for (int row = 0, col = start; row < grid.rowLength && col > -1; row++, col--) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerList(ind, answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate(tries);
					} else {
						ind++;
						resetIfNextRToLCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndDecrementStartOrReverseWord();
		}
		return "not found";
	}


	public String scanAlongRowsFromTopRight() {
		start = 1;
		ind = 0;
		tries = 0;
		answer.resetHolder();
		while (tries < 2) {
			for (int row = start, col = grid.colLength - 1; row < grid.rowLength && col > -1; row++, col--) {
				if (grid.getCharacterAt(row, col) == answer.currentChar(ind)) {
					answer.buildAnswerList(ind, answer.coords(row, col));
					if (answer.maxInd(ind)) {
						return answer.generate(tries);
					} else {
						ind++;
						resetIfNextRToLCharNotPresent(row, col);
					}
				}
			}
			checkPositionAndIncrementStartOrReverseWord();
		}
		return "not found";
	}

	private void resetIfNextRToLCharNotPresent(int row, int col) {
		if (grid.getNextCharacterRToLDiagonalFrom(row, col) != answer.currentChar(ind)) {
			answer.reset();
			ind = 0;
		}
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

	public String scan() {
		String answer = "not found";
		String rowsFromTopLeft = scanAlongRowsFromTopLeft();
		String columnsFromTopLeft = scanAlongColumnsFromTopLeft();
		String rowsFromTopRight = scanAlongRowsFromTopRight();
		String columnsFromTopRight = scanAlongColumnsFromTopRight();
		
		if (rowsFromTopRight != "not found" ) {
			answer = rowsFromTopRight;
		} else if (columnsFromTopRight != "not found") {
			answer = columnsFromTopRight;
		} else if (rowsFromTopLeft != "not found") {
			answer = rowsFromTopLeft;
		} else if (columnsFromTopLeft != "not found" ) {
			answer = columnsFromTopLeft;
		}
		
			return answer;
	}
}
