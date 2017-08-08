package com.paigeruppel.katas.wordsearch;

public class LetterGrid {

	private char[][] toSearch;
	protected int rowLength;
	protected int colLength;

	public LetterGrid(char[][] toSearch) {
		this.toSearch = toSearch;
		rowLength = toSearch.length;
		colLength = toSearch[0].length;
	}

	public Character getCharacterAt(int row, int col) {
		return toSearch[row][col];
	}

	public Character getNextCharacterHorizontalFrom(int row, int col) {
		Character nextChar;
		if (col + 1 < toSearch[row].length) {
			nextChar = toSearch[row][col+1];
		} else {
			nextChar = '0';
		}
		return nextChar;
	}

	public Character getNextCharacterVerticalFrom(int row, int col) {
		// TODO Auto-generated method stub
		return 'e';
	}
}
