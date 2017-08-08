package com.paigeruppel.katas.wordsearch;

import java.util.HashMap;
import java.util.Map;

public class AnswerBuilder {

	private String toFind;
	protected Map<Character, String> answerMap = new HashMap<>();

	public AnswerBuilder(String toFind) {
		this.toFind = toFind;
	}

	public void buildAnswerMap(Character index, String coords) {
		answerMap.put(index, coords);
	}

	public void reset() {
		answerMap.clear();
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
}
