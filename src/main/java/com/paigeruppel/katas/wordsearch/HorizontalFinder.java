package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story
public class HorizontalFinder {

	private String toFind;
	private LetterGrid grid;
	int maxInd;

	private AnswerBuilder answer;

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.toFind = toFind;
		this.grid = grid;
		maxInd = toFind.length() - 1;
		answer = new AnswerBuilder(toFind);
	}

	public HorizontalFinder() {
	}

	public String horizontalScan() {
		int ind = 0;
		char currentChar = '0';
		int tries = 0;
		while (tries < 2) {
			for (int row = 0; row < grid.rowLength; row++) {
				for (int col = 0; col < grid.colLength; col++) {
					currentChar = toFind.charAt(ind);
					if (grid.getCharacterAt(row, col) == currentChar) {
						answer.buildAnswerMap(currentChar, coords(row, col));
						if (ind == maxInd) {
							return answer.generate();
						} else {
							ind = increment(ind);
							if (grid.getNextCharacterHorizontalFrom(row, col) != toFind.charAt(ind)) {
								answer.reset();
								ind = 0;
							}
						}
					}
				}
				answer.reset();
				ind = 0;
			}
			tries++;
			toFind = new StringBuilder(toFind).reverse().toString();
		}
		return "not found";
	}

	private int increment(int ind) {
		if (ind < maxInd) {
			ind++;
		}
		return ind;
	}

	private String coords(int row, int col) {
		return "(" + row + "," + col + ")";
	}
}
