package com.paigeruppel.katas.wordsearch;

import java.util.HashMap;
import java.util.Map;

// To satisfy the first user story
public class HorizontalFinder {

	private String toFind;
	private char[][] toSearch;
	int maxInd;

	private String answer;

	public HorizontalFinder(String toFind, char[][] toSearch) {
		this.toFind = toFind;
		this.toSearch = toSearch;
		maxInd = toFind.length() - 1;
		resetAnswer();
	}

	public String horizontalScan() {
		int ind = 0;

		for (int row = 0; row < toSearch.length; row++) {
			for (int col = 0; col < toSearch[row].length; col++) {
				if (toSearch[row][col] == toFind.charAt(ind)) {
					answer += coords(row, col);
					if (ind == maxInd) {
						return answer;
					} else {
						ind = increment(ind);
					}
				} else {
					resetAnswer();
					ind = 0;
					if (toSearch[row][col] == toFind.charAt(ind)) {
						answer += coords(row, col);
						if (ind == maxInd) {
							return answer;
						} else {
							ind = increment(ind);
						}
					}
				}
			}
			resetAnswer();
			ind = 0;
		}
		return answer;
	}

	private void resetAnswer() {
		answer = toFind + ":";
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
