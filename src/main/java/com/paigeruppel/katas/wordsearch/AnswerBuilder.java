package com.paigeruppel.katas.wordsearch;

import java.util.HashMap;
import java.util.Map;

public class AnswerBuilder {

	private String toFind;
	private String holder;
	protected Map<Character, String> answerMap = new HashMap<>();
	private int maxInd;

	public AnswerBuilder(String toFind) {
		this.toFind = toFind;
		holder = toFind;
		maxInd = toFind.length() - 1;
	}

	public void buildAnswerMap(Character index, String coords) {
		answerMap.put(index, coords);
	}

	public void reset() {
		answerMap.clear();
	}

	public String coords(int row, int col) {
		return "(" + row + "," + col + ")";
	}

	public boolean maxInd(int ind) {
		if (ind == maxInd) {
			return true;
		}
		return false;
	}

	public int increment(int ind) {
		if (ind < maxInd) {
			ind++;
		}
		return ind;
	}

	public Character currentChar(int ind) {
		return holder.charAt(ind);
	}

	public String generate() {
		String answer = toFind + ": ";
		for (int i = 0; i < toFind.length(); i++) {
			if (i < toFind.length() - 1) {
				answer += answerMap.get(toFind.charAt(i)) + ",";
			} else {
				answer += answerMap.get(toFind.charAt(i));
			}
		}
		return answer;
	}

	public void reverseWord() {
		holder = new StringBuilder(holder).reverse().toString();

	}
}
