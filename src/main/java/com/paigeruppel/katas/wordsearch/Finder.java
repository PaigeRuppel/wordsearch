package com.paigeruppel.katas.wordsearch;

public interface Finder {
	
	String scan();

	boolean isMatch(int x, int y);

	boolean isMatchAndAtLastLetter(int x, int y);
}
