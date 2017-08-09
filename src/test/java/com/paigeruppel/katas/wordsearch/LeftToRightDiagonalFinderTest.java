package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LeftToRightDiagonalFinderTest {

	private String toFind;
	private LetterGrid grid;

	public LeftToRightDiagonalFinder createTest(String toFind, LetterGrid grid) {
		return new LeftToRightDiagonalFinder(toFind, grid);
	}

	@Test
	public void shouldReturnCatAtZeroZeroOneOneTwoTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'c', 'x', 'x' }, { 'x', 'a', 'x' }, { 'x', 'x', 't' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).leftToRightDiagonalScan(), is("cat: (0,0),(1,1),(2,2)"));
	}
	
	@Test
	public void shouldReturnItAtOneOneTwoTwo() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'x', 'i', 'x' }, { 'x', 'x', 't' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).leftToRightDiagonalScan(), is("it: (1,1),(2,2)"));
	}
	@Test
	public void shouldReturnItAtZeroOneOneTwo() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).leftToRightDiagonalScan(), is("it: (0,1),(1,2)"));
	}
}
