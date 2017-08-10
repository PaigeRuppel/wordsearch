package com.paigeruppel.katas.wordsearch;

import java.util.ArrayList;

public class AnswerBuilder {

	private String toFind;
	private String holder;
	protected ArrayList<String> answerList = new ArrayList<String>();
	private int maxInd;

	public AnswerBuilder(String toFind) {
		this.toFind = toFind;
		holder = toFind;
		maxInd = toFind.length() - 1;
	}

	public void buildAnswerList(Integer index, String coords) {
		answerList.add(index, coords);
	}

	public void reset() {
		answerList.clear();
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
				answer += answerList.get(i) + ",";
			} else {
				answer += answerList.get(i);
			}
		}
		return answer;
	}
	
	

	public boolean reverseWord() {
		holder = new StringBuilder(holder).reverse().toString();
		return true;
	}
}
