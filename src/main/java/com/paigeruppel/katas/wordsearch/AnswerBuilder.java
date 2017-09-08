package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class AnswerBuilder {

	private String toFind;
	private String toFindHolder;
	private int maxInd;
	private int tries;
	private int letterIndex;

	List<String> answerList = new ArrayList<String>();

	public int getLetterIndex() {
		return letterIndex;
	}

	public int getTries() {
		return tries;
	}

	public AnswerBuilder(String toFind) {
		this.toFind = toFind;
		toFindHolder = toFind;
		maxInd = toFind.length() - 1;
		tries = 0;
		letterIndex = 0;
	}

	public void incrementTries() {
		tries = getTries() + 1;
	}
	
	public void resetTries() {
		tries = 0;
	}

	public void buildAnswerAndIncrementLetterIndex(int x, int y) {
		buildAnswerList(getLetterIndex(), coords(x, y));
		incrementLetterIndex();
	}
	
	public void incrementLetterIndex() {
		if (letterIndex < maxInd) {
			letterIndex = getLetterIndex() + 1;
		}
	}

	public void buildAnswerList(int currentIndex, String coords) {
		answerList.add(currentIndex, coords);
	}

	public void resetAnswerAndLetterIndexToZero() {
		letterIndex = 0;
		answerList.clear();
	}

	public String coords(int x, int y) {
		return "(" + x + "," + y + ")";
	}

	public boolean atLastLetter() {
		return getLetterIndex() == maxInd;
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

}
