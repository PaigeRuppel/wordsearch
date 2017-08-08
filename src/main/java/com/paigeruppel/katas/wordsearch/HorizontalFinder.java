package com.paigeruppel.katas.wordsearch;

public class HorizontalFinder {
	// To satisfy the first user story

	public String horizontalScan(String toFind, char[][] toSearch) {
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
