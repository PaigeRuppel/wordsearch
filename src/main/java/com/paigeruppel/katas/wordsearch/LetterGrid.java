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
		Character nextHorChar;
		if (col + 1 < toSearch[row].length) {
			nextHorChar = toSearch[row][col + 1];
		} else {
			nextHorChar = '0';
		}
		return nextHorChar;
	}

	public Character getNextCharacterVerticalFrom(int row, int col) {
		Character nextVerChar;
		if (row + 1 < toSearch.length) {
			nextVerChar = toSearch[row + 1][col];
		} else {
			nextVerChar = '0';
		}
		return nextVerChar;
	}

	public Character getNextCharacterLToRDiagonalFrom(int row, int col) {
		Character nextLToRDiagChar;
		if (col + 1 < toSearch[0].length && row + 1 < toSearch.length) {
			nextLToRDiagChar = toSearch[row + 1][col + 1];
		} else {
			nextLToRDiagChar = '0';
		}
		return nextLToRDiagChar;
	}

	public Character getNextCharacterRToLDiagonalFrom(int row, int col) {
		Character nextRToLDiagChar;
		if (col - 1 > -1 && row + 1 < toSearch.length) {
			nextRToLDiagChar = toSearch[row + 1][col - 1];
		} else {
			nextRToLDiagChar = '0';
		}
		return nextRToLDiagChar;
	}
	
	
}
