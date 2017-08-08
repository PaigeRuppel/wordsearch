package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AnswerBuilderTest {

	private AnswerBuilder underTest;

	@Test
	public void shouldReturnCatAtZeroZeroZeroOneZeroTwo() {
		underTest = new AnswerBuilder("cat");
		assertThat(underTest.generateAnswer(), is("cat: (0,0),(0,1),(0,2)"));
	}
}
