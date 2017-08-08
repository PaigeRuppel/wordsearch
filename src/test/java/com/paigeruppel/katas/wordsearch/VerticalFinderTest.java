package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VerticalFinderTest {
	private LetterGrid grid;
	private String toFind;


	public VerticalFinder createTest(String toFind, LetterGrid grid) {
		return new VerticalFinder(toFind, grid);
	}
	
	@Test
	public void shouldReturnCatAtRowOneColumnZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'c', 'x' }, { 'x', 'a', 'x' }, { 'x', 't', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).verticalScan(), is("cat: (1,0),(1,1),(1,2)"));
	}
}
