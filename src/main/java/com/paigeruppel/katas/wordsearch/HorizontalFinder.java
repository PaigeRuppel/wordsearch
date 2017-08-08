package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story
public class HorizontalFinder {

	private String toFind;
	private LetterGrid grid;
	int maxInd;

	private String answer;

	public HorizontalFinder(String toFind, LetterGrid grid) {
		this.toFind = toFind;
		this.grid = grid;
		maxInd = toFind.length() - 1;
		resetAnswer();
	}

	public HorizontalFinder() {
	}

	public String horizontalScan() {
		int ind = 0;
		boolean answerFound = false;
		boolean reversed = false;
		
		while(answerFound == false) {
		for (int row = 0; row < grid.rowLength; row++) {
			for (int col = 0; col < grid.colLength; col++) {
				if (grid.getCharacterAt(row, col) == toFind.charAt(ind)) {
					answer += coords(row, col);
					if (ind == maxInd) {
						answerFound = true;
						if (reversed) {
							answer = new StringBuilder(answer).reverse().toString();
							toFind = new StringBuilder(toFind).reverse().toString();
						}
						return toFind + ":" + answer;
					} else {
						ind = increment(ind);
						if (grid.getNextCharacterHorizontalFrom(row, col) != toFind.charAt(ind)) {
							resetAnswer();
							ind = 0;
						}
					}
				}
			}
			resetAnswer();
			ind = 0;
		}
		toFind = new StringBuilder(toFind).reverse().toString();
		reversed = true;
		}
		return answer;
	}

	private void resetAnswer() {
		answer = "";
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
