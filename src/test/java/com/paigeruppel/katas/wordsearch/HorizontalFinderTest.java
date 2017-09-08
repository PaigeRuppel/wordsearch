package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HorizontalFinderTest {

	private LetterGrid grid;

	private HorizontalFinder underTest;

	public void createTest(String toFind, char[][] toSearch) {
		grid = new LetterGrid(toSearch);
		underTest = new HorizontalFinder(toFind, grid);
	}

	@Test
	public void shouldReturnCatAtRowOneColumnZeroOneTwo() {
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'c', 'a', 't' }, { 'x', 'x', 'x' } };
		createTest("cat", toSearch);
		assertThat(underTest.scan(), is("cat: (0,1),(1,1),(2,1)"));
	}

	@Test
	public void shouldReturnCatAtRowZeroColumnZeroOneTwo() {
		char[][] toSearch = { { 'c', 'a', 't' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		createTest("cat", toSearch);
		assertThat(underTest.scan(), is("cat: (0,0),(1,0),(2,0)"));
	}

	@Test
	public void shouldReturnLaAtRowZeroColumnOneTwo() {
		char[][] toSearch = { { 'x', 'l', 'a' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		createTest("la", toSearch);
		assertThat(underTest.scan(), is("la: (1,0),(2,0)"));
	}

	@Test
	public void shouldReturnLaAtRowOneColumnOneTwoWithConfoundingL() {
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'l', 'a' }, { 'x', 'x', 'x' } };
		createTest("la", toSearch);
		assertThat(underTest.scan(), is("la: (1,1),(2,1)"));
	}

	@Test
	public void shouldReturnLaAtRowOneColumnOneTwoWithTwoConfoundingL() {
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'l', 'l', 'a' }, { 'x', 'x', 'x' } };
		createTest("la", toSearch);
		assertThat(underTest.scan(), is("la: (1,1),(2,1)"));
	}

	@Test
	public void shouldReturnLabAtRowTwoColumnZeroOneTwoWithConfoundingLa() {
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'l', 'l', 'a' }, { 'l', 'a', 'b' } };
		createTest("lab", toSearch);
		assertThat(underTest.scan(), is("lab: (0,2),(1,2),(2,2)"));
	}

	@Test
	public void shouldReturnLabAtRowTwoColumnTwoOneZeroWithConfoundingLa() {
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'x', 'x' }, { 'b', 'a', 'l' } };
		createTest("lab", toSearch);
		assertThat(underTest.scan(), is("lab: (2,2),(1,2),(0,2)"));
	}

	@Test
	public void shouldReturnNotFoundForCat() {
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'x', 'x' }, { 'b', 'a', 'l' } };
		createTest("cat", toSearch);
		assertThat(underTest.scan(), is("not found"));
	}

	@Test
	public void shouldReturnBill() {
		char[][] toSearch = { { 'b', 'i', 'l', 'l' }, { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' },
				{ 'x', 'b', 'a', 'l' } };
		createTest("bill", toSearch);
		assertThat(underTest.scan(), is("bill: (0,0),(1,0),(2,0),(3,0)"));
	}

	@Test
	public void shouldReturnKirkXCoords4Through1YCoord7() {
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
		createTest("KIRK", toSearch);
		assertThat(underTest.scan(), is("KIRK: (4,7),(3,7),(2,7),(1,7)"));
	}
}
