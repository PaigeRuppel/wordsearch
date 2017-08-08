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
	public void shouldReturnCatAtColumnOneRowZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'c', 'x' }, { 'x', 'a', 'x' }, { 'x', 't', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).verticalScan(), is("cat: (0,1),(1,1),(2,1)"));
	}

	@Test
	public void shouldReturnCatAtColumnZeroRowZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'c', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).verticalScan(), is("cat: (0,0),(1,0),(2,0)"));
	}
	
	@Test
	public void shouldReturnAtAtColumnZeroRowOneTwo() {
		toFind = "at";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).verticalScan(), is("at: (1,0),(2,0)"));
	}
	
	@Test
	public void shouldReturnAtAtColumnZeroRowOneTwoWithConfoundingA() {
		toFind = "at";
		char[][] toSearch = { { 'a', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).verticalScan(), is("at: (1,0),(2,0)"));
	}
}
