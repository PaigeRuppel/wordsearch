package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class AnswerBuilder {

	private String toFind;
	private String toFindHolder;
	private int maxInd;
	private int tries;
	private int letterIndex;

	private List<String> answerList = new ArrayList<String>();

	private LetterGrid grid;
	
	public int getTries() {
		return tries;
	}

	public int getLetterIndex() {
		return letterIndex;
	}
	
	public List<String> getAnswerList() {
		return answerList;
	}

	public AnswerBuilder(String toFind) {
		this.toFind = toFind;
		toFindHolder = toFind;
		maxInd = toFind.length() - 1;
		tries = 0;
		letterIndex = 0;
	}
	
	public AnswerBuilder(String toFind, LetterGrid grid) {
		this.toFind = toFind;
		this.grid = grid;
		toFindHolder = toFind;
		maxInd = toFind.length() - 1;
		tries = 0;
		letterIndex = 0;
	}

	public boolean atLastLetter() {
		return getLetterIndex() == maxInd;
	}

	public void incrementLetterIndex() {
		if (!atLastLetter()) {
			letterIndex = getLetterIndex() + 1;
		}
	}

	public void incrementTries() {
		tries = getTries() + 1;
	}

	public void resetTries() {
		tries = 0;
	}

	public void buildAnswerList(int currentIndex, String coords) {
		answerList.add(currentIndex, coords);
	}

	public void buildAnswerAndIncrementLetterIndex(int x, int y) {
		buildAnswerList(getLetterIndex(), formattedCoords(x, y));
		incrementLetterIndex();
	}

	public String buildAndReturnAnswer(int x, int y) {
		buildAnswerList(getLetterIndex(), formattedCoords(x, y));
		return generate();
	}

	public void resetAnswerAndLetterIndexToZero() {
		letterIndex = 0;
		answerList.clear();
	}

	public String formattedCoords(int x, int y) {
		return "(" + x + "," + y + ")";
	}

	public Character currentChar() {
		return toFindHolder.charAt(getLetterIndex());
	}

	public String generate() {
		String answer = toFind + ": ";
		if (getTries() == 0) {
			answer = generateForward(answer);
		} else {
			answer = generateReverse(answer);
		}
		return answer;
	}

	private String generateForward(String answer) {
		letterIndex = 0;
		for (int index = getLetterIndex(); index < toFind.length(); index++) {
			if (index < toFind.length() - 1) {
				answer += answerList.get(index) + ",";
			} else {
				answer += answerList.get(index);
			}
		}
		return answer;
	}

	public String generateReverse(String answer) {
		letterIndex = maxInd;
		for (int index = getLetterIndex(); index > -1; index--) {
			if (index > 0) {
				answer += answerList.get(index) + ",";
			} else {
				answer += answerList.get(index);
			}
		}
		return answer;
	}

	public void reverseWord() {
		toFindHolder = new StringBuilder(toFindHolder).reverse().toString();
	}

	public void forwardWord() {
		toFindHolder = toFind;
	}
	
	public boolean isMatch(int x, int y) {
		return grid.charAt(y, x) == currentChar();
	}
	
	public boolean isMatchAndAtLastLetter(int x, int y) {
		return isMatch(x, y) && atLastLetter();
	}
	
	public void checkForMatchAndResetOrBuildAnswer(int x, int y) {
		if (!isMatch(x, y)) {
			resetAnswerAndLetterIndexToZero();
		}
		
		if (isMatch(x, y)) {
			buildAnswerAndIncrementLetterIndex(x, y);
		}
	}

}
