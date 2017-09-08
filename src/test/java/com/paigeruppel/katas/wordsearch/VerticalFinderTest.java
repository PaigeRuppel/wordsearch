package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VerticalFinderTest {

	private LetterGrid grid;

	private String toFind;

	public VerticalFinder createTest() {
		return new VerticalFinder(toFind, grid);
	}

	public void buildGrid(char[][] toSearch) {
		grid = new LetterGrid(toSearch);
	}	

	@Test
	public void shouldReturnCatAtXOneYZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'c', 'x' }, { 'x', 'a', 'x' }, { 'x', 't', 'x' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("cat: (1,0),(1,1),(1,2)"));
	}

	@Test
	public void shouldReturnCatAtXZeroYZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'c', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("cat: (0,0),(0,1),(0,2)"));
	}

	@Test
	public void shouldReturnAtAtXZeroYOneTwo() {
		toFind = "at";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("at: (0,1),(0,2)"));
	}

	@Test
	public void shouldReturnAtAtXZeroYOneTwoWithConfoundingA() {
		toFind = "at";
		char[][] toSearch = { { 'a', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("at: (0,1),(0,2)"));
	}

	@Test
	public void shouldReturnAtFitXTwoYZeroOneTwoWithConfoundingFi() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 'f' }, { 'x', 'i', 'i' }, { 'x', 'x', 't' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("fit: (2,0),(2,1),(2,2)"));
	}

	@Test
	public void shouldReturnFitAtXTwoYTwoOneZeroWithConfoundingFi() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 't' }, { 'x', 'i', 'i' }, { 'x', 'x', 'f' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("fit: (2,2),(2,1),(2,0)"));
	}

	@Test
	public void shouldReturnNotFoundForBit() {
		toFind = "bit";
		char[][] toSearch = { { 'x', 'f', 't' }, { 'x', 'i', 'i' }, { 'x', 'x', 'f' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("not found"));
	}

	@Test
	public void shouldReturnNotFoundForBill() {
		toFind = "bill";
		char[][] toSearch = { { 'b', 'i', 'l', 'l' }, { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' },
				{ 'x', 'b', 'a', 'l' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("not found"));
	}

	@Test
	public void shouldReturnKahnXFiveYNineThroughSix() {
		toFind = "KHAN";
		char[][] toSearch = { { 'U', 'M', 'K', 'H', 'U', 'L', 'K', 'I', 'N', 'V', 'J', 'O', 'C', 'W', 'E' },
				{ 'L', 'L', 'S', 'H', 'K', 'Z', 'Z', 'W', 'Z', 'C', 'G', 'J', 'U', 'Y', 'G' },
				{ 'H', 'S', 'U', 'P', 'J', 'P', 'R', 'J', 'D', 'H', 'S', 'B', 'X', 'T', 'G' },
				{ 'B', 'R', 'J', 'S', 'O', 'E', 'Q', 'E', 'T', 'I', 'K', 'K', 'G', 'L', 'E' },
				{ 'A', 'Y', 'O', 'A', 'G', 'C', 'I', 'R', 'D', 'Q', 'H', 'R', 'T', 'C', 'D' },
				{ 'S', 'C', 'O', 'T', 'T', 'Y', 'K', 'Z', 'R', 'E', 'P', 'P', 'X', 'P', 'F' },
				{ 'B', 'L', 'Q', 'S', 'L', 'N', 'E', 'E', 'E', 'V', 'U', 'L', 'F', 'M', 'Z' },
				{ 'O', 'K', 'R', 'I', 'K', 'A', 'M', 'M', 'R', 'M', 'F', 'B', 'A', 'P', 'P' },
				{ 'N', 'U', 'I', 'I', 'Y', 'H', 'Q', 'M', 'E', 'M', 'Q', 'R', 'Y', 'F', 'S' },
				{ 'E', 'Y', 'Z', 'Y', 'G', 'K', 'Q', 'J', 'P', 'C', 'Q', 'W', 'Y', 'A', 'K' },
				{ 'S', 'J', 'F', 'Z', 'M', 'Q', 'I', 'B', 'D', 'B', 'E', 'M', 'K', 'W', 'D' },
				{ 'T', 'G', 'L', 'B', 'H', 'C', 'B', 'E', 'C', 'H', 'T', 'O', 'Y', 'I', 'K' },
				{ 'O', 'J', 'Y', 'E', 'U', 'L', 'N', 'C', 'C', 'L', 'Y', 'B', 'Z', 'U', 'H' },
				{ 'W', 'Z', 'M', 'I', 'S', 'U', 'K', 'U', 'R', 'B', 'I', 'D', 'U', 'X', 'S' },
				{ 'K', 'Y', 'L', 'B', 'Q', 'Q', 'P', 'M', 'D', 'F', 'C', 'K', 'E', 'A', 'B' } };
		buildGrid(toSearch);
		assertThat(createTest().scan(), is("KHAN: (5,9),(5,8),(5,7),(5,6)"));
	}
}
