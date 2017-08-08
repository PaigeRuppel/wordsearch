package com.paigeruppel.katas.wordsearch;

public class LetterGrid {

	private char[][] toSearch;
	
	public LetterGrid(char[][] toSearch) {
		this.toSearch = toSearch;
	}
	
	public Character getCharacterAt(int row, int col) {
		return toSearch[row][col];
	}

	public Character getNextCharacterHorizontalFrom(int row, int col) {
		// TODO Auto-generated method stub
		return toSearch[row][col+1];
	}
}
