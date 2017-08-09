package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DiagonalFinderTest {

	private String toFind;
	private LetterGrid grid;

	public DiagonalFinder createTest(String toFind, LetterGrid grid) {
		return new DiagonalFinder(toFind, grid);
	}

	@Test
	public void shouldReturnCatAtZeroZeroOneOneTwoTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'c', 'x', 'x' }, { 'x', 'a', 'x' }, { 'x', 'x', 't' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongColumnsLeftToRight(), is("cat: (0,0),(1,1),(2,2)"));
	}

	@Test
	public void shouldReturnItAtOneOneTwoTwo() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'x', 'i', 'x' }, { 'x', 'x', 't' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongColumnsLeftToRight(), is("it: (1,1),(2,2)"));
	}

	@Test
	public void shouldReturnItAtZeroOneOneTwo() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongColumnsLeftToRight(), is("it: (0,1),(1,2)"));
	}

	@Test
	public void shouldReturnItAtZeroOneOneTwoWithConfoundingI() {
		toFind = "it";
		char[][] toSearch = { { 'i', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongColumnsLeftToRight(), is("it: (0,1),(1,2)"));
	}
	
	@Test
	public void shouldReturnItAtOneTwoZeroOne() {
		toFind = "it";
		char[][] toSearch = { { 'x', 't', 'x' }, { 'x', 'x', 'i' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongColumnsLeftToRight(), is("it: (1,2),(0,1)"));
	}
	
	@Test
	public void shouldReturnNotFoundForCat() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 't', 'x' }, { 'x', 'x', 'i' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongColumnsLeftToRight(), is("not found"));
	}
	
	@Test
	public void shouldReturnItAtOneZeroTwoOne() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'i', 'x', 'x' }, { 'x', 't', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongRowsTopToBottom(), is("it: (1,0),(2,1)"));
	}
	
	
	@Test
	public void shouldReturnItAtTwoZeroThreeOne() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'i', 'x', 'x', 'x' },{'x','t','x','x'} };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongRowsTopToBottom(), is("it: (2,0),(3,1)"));
	}
	
	@Test
	public void shouldReturnItAtTwoZeroThreeOneWithConfoundingT() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'i', 'x', 't', 'x' },{'x','t','x','x'} };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongRowsTopToBottom(), is("it: (2,0),(3,1)"));
	}
	
	@Test
	public void shouldReturnItAtThreeOneTwoZeroWithConfoundingI() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },{'x','i','x','x'} };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongRowsTopToBottom(), is("it: (3,1),(2,0)"));
	}
	
	@Test
	public void shouldReturnNotFoundForBat() {
		toFind = "bat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },{'x','i','x','x'} };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanAlongRowsTopToBottom(), is("not found"));
	}
}