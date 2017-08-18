package com.paigeruppel.katas.wordsearch;

public class LetterGrid {

	private char[][] toSearch;
	private int yLength;
	private int xLength;

	protected int getYLength() {
		return yLength;
	}

	protected int getXLength() {
		return xLength;
	}

	public LetterGrid(char[][] toSearch) {
		this.toSearch = toSearch;
		yLength = toSearch.length;
		xLength = toSearch[0].length;
	}

	public boolean withinEdges(int x, int y) {
		return y > -1 && y < getYLength() && x > -1 && x < getXLength();

	}

	public Character getCharacterAt(int y, int x) {
		return toSearch[y][x];
	}

	public Character getNextCharacterHorizontalFrom(int y, int x) {
		Character nextHorChar;
		if (x + 1 < toSearch[y].length) {
			nextHorChar = toSearch[y][x + 1];
		} else {
			nextHorChar = '0';
		}
		return nextHorChar;
	}

	public Character getNextCharacterVerticalFrom(int x, int y) {
		Character nextVerChar;
		if (y + 1 < toSearch.length) {
			nextVerChar = toSearch[y + 1][x];
		} else {
			nextVerChar = '0';
		}
		return nextVerChar;
	}

	public Character getNextCharacterLToRDiagonalFrom(int y, int x) {
		Character nextLToRDiagChar;
		if (x + 1 < toSearch[0].length && y + 1 < toSearch.length) {
			nextLToRDiagChar = toSearch[y + 1][x + 1];
		} else {
			nextLToRDiagChar = '0';
		}
		return nextLToRDiagChar;
	}

	public Character getNextCharacterRToLDiagonalFrom(int y, int x) {
		Character nextRToLDiagChar;
		if (x - 1 > -1 && y + 1 < toSearch.length) {
			nextRToLDiagChar = toSearch[y + 1][x - 1];
		} else {
			nextRToLDiagChar = '0';
		}
		return nextRToLDiagChar;
	}

}
