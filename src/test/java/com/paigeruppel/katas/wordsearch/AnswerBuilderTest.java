package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AnswerBuilderTest {


	private AnswerBuilder underTest;

	@Test
	public void shouldBuildAnAnswerMapWithA() {
		underTest = new AnswerBuilder("a");
		underTest.buildAnswerMap('a', "(0,0)");
		assertThat(underTest.answerMap, is(notNullValue()));
	}

	@Test
	public void shouldReturnCatAtZeroZeroZeroOneZeroTwo() {
		underTest = new AnswerBuilder("cat");
		underTest.buildAnswerMap('c', "(0,0)");
		underTest.buildAnswerMap('a', "(0,1)");
		underTest.buildAnswerMap('t', "(0,2)");
		assertThat(underTest.generate(), is("cat: (0,0),(0,1),(0,2)"));
	}
	
	@Test
	public void shouldReturnCatAtOneZeroOneOneOneTwo() {
		underTest = new AnswerBuilder("cat");
		underTest.buildAnswerMap('c', "(1,0)");
		underTest.buildAnswerMap('a', "(1,1)");
		underTest.buildAnswerMap('t', "(1,2)");
		assertThat(underTest.generate(), is("cat: (1,0),(1,1),(1,2)"));
	}
}
