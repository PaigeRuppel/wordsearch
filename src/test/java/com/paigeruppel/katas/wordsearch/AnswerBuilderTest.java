package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AnswerBuilderTest {

	private AnswerBuilder underTest;

	private LetterGrid grid;

	private HorizontalFinder horizontalFind;

	@Test
	public void shouldReturnCatAtZeroZeroZeroOneZeroTwo() {
		char[][] toSearch = { { 'c', 'a', 't' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		underTest = new AnswerBuilder("cat");
		assertThat(underTest.generate(), is("cat: (0,0),(0,1),(0,2)"));
	}
	
	@Test
	public void shouldReturnCatAtOneZeroOneOneOneTwo() {
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'c', 'a', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		underTest = new AnswerBuilder("cat");
		assertThat(underTest.generate(), is("cat: (1,0),(1,1),(1,2)"));
	}
}
