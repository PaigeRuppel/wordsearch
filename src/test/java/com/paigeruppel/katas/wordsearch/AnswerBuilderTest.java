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
		underTest.buildAnswerList("(0,0)");

		assertThat(underTest.answerList, is(notNullValue()));
	}

	@Test
	public void shouldReturnCatAtZeroZeroZeroOneZeroTwo() {
		underTest = new AnswerBuilder("cat");
		underTest.buildAnswerList("(0,0)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(0,1)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(0,2)");
		assertThat(underTest.generate(), is("cat: (0,0),(0,1),(0,2)"));
	}

	@Test
	public void shouldReturnCatAtOneZeroOneOneOneTwo() {
		underTest = new AnswerBuilder("cat");
		underTest.buildAnswerList("(1,0)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,1)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,2)");
		assertThat(underTest.generate(), is("cat: (1,0),(1,1),(1,2)"));
	}

	@Test
	public void shouldReturnKataAtOneZeroOneOneOneTwoOneThree() {
		underTest = new AnswerBuilder("kata");
		underTest.buildAnswerList("(1,0)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,1)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,2)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,3)");
		assertThat(underTest.generate(), is("kata: (1,0),(1,1),(1,2),(1,3)"));
	}

	// simulate reverse word
	@Test
	public void shouldReturnKataAtOneThreeOneTwoOneOneOneZero() {
		underTest = new AnswerBuilder("kata");
		underTest.buildAnswerList("(1,0)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,1)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,2)");
		underTest.incrementLetterIndex();
		underTest.buildAnswerList("(1,3)");
		underTest.incrementTries();
		assertThat(underTest.generate(), is("kata: (1,3),(1,2),(1,1),(1,0)"));
	}
}
