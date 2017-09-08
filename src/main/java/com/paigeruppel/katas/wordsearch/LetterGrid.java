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

}
