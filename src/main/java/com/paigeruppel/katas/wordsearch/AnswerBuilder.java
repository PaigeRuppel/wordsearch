package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;

public class AnswerBuilder {

	private String toFind;
	private String toFindHolder;
	private int maxInd;
	protected ArrayList<String> answerList = new ArrayList<String>();
	protected int tries;
	protected int letterIndex;

	public AnswerBuilder(String toFind) {
		this.toFind = toFind;
		toFindHolder = toFind;
		maxInd = toFind.length() - 1;
		tries = 0;
		letterIndex = 0;
	}

	public void incrementTries() {
		tries++;
	}

	public void incrementLetterIndex() {
		if (letterIndex < maxInd) {
			letterIndex++;
		}
	}

	public void buildAnswerList(int currentIndex, String coords) {
		answerList.add(currentIndex, coords);
	}

	public void resetAnswerAndLetterIndexToZero() {
		letterIndex = 0;
		answerList.clear();
	}

	public String coords(int row, int col) {
		return "(" + col + "," + row + ")";
	}

	public boolean atLastLetter() {
		if (letterIndex == maxInd) {
			return true;
		}
		return false;
	}

	public Character currentChar() {
		return toFindHolder.charAt(letterIndex);
	}

	public String generate() {
		String answer = toFind + ": ";
		if (tries == 0) {
			answer = generateForward(answer);
		} else {
			answer = generateReverse(answer);
		}
		return answer;
	}

	private String generateForward(String answer) {
		letterIndex = 0;
		for (int index = letterIndex; index < toFind.length(); index++) {
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
		for (int index = letterIndex; index > -1; index--) {
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

//	public boolean completed() {
//		return true;
//	}

}
