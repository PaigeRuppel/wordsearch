package com.paigeruppel.katas.wordsearch;

// To satisfy the first user story
public class HorizontalFinder {

	private String toFind;
	private char[][] toSearch;

	public HorizontalFinder(String toFind, char[][] toSearch) {
		this.toFind = toFind;
		this.toSearch = toSearch;
	}

	public String horizontalScan() {
		String answer = toFind + ":";

		int ind = 0;
		for (int row = 0; row < toSearch.length; row++) {
			for (int col = 0; col < toSearch[row].length; col++) {
				if (toSearch[row][col] == toFind.charAt(ind)) {
					answer += "(" + row + "," + col + ")";
					if (ind < toFind.length() - 1) {
						ind++;
					}
				}
			}
		}
		return answer;
	}
}
