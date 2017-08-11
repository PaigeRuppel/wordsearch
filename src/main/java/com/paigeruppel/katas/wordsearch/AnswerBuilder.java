package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;

public class AnswerBuilder {

	private String toFind;
	private String toFindHolder;
	protected ArrayList<String> answerList = new ArrayList<String>();
	private int maxInd;
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

	public void buildAnswerList(String coords) {
		answerList.add(letterIndex, coords);
	}

	public void reset() {
		letterIndex = 0;
		answerList.clear();
	}

	public String coords(int row, int col) {
		return "(" + row + "," + col + ")";
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
			for (int i = 0; i < toFind.length(); i++) {
				if (i < toFind.length() - 1) {
					answer += answerList.get(i) + ",";
				} else {
					answer += answerList.get(i);
				}
			}
		} else {
			answer = generateReverse();
		}
		return answer;
	}

	public String generateReverse() {
		String answer = toFind + ": ";
		for (int i = toFind.length() - 1; i > -1; i--) {
			if (i > 0) {
				answer += answerList.get(i) + ",";
			} else {
				answer += answerList.get(i);
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
