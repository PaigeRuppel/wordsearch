package com.paigeruppel.katas.wordsearch;

import java.util.HashMap;
import java.util.Map;

public class AnswerBuilder {

	private String toFind;
	private Map<Character, String> answerMap = new HashMap<>();

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
		String answer = toFind + ":";
		for (int i = 0; i < toFind.length(); i++) {
			answer += answerMap.get(toFind.charAt(i));
		}
		return answer;
	}
}
