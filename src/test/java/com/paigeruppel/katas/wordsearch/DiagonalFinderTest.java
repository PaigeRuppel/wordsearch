package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class DiagonalFinderTest {

	private LetterGrid grid;
	private DiagonalFinder underTest;

	public void createTest(String toFind, char[][] toSearch) {
		grid = new LetterGrid(toSearch);
		underTest = new DiagonalFinder(toFind, grid);
	}

	@Test
	public void shouldReturnCatAtZeroZeroOneOneTwoTwo() {
		char[][] toSearch = { { 'c', 'x', 'x' }, { 'x', 'a', 'x' }, { 'x', 'x', 't' } };
		createTest("cat", toSearch);
		assertThat(underTest.scanXAxisLookingLeftToRight(), is("cat: (0,0),(1,1),(2,2)"));
	}

	@Test
	public void shouldReturnItAtOneOneTwoTwo() {
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'x', 'i', 'x' }, { 'x', 'x', 't' } };
		createTest("it", toSearch);
		assertThat(underTest.scanXAxisLookingLeftToRight(), is("it: (1,1),(2,2)"));
	}

	@Test
	public void shouldReturnItAtOneZeroOneTwo() {
		char[][] toSearch = { { 'x', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scanXAxisLookingLeftToRight(), is("it: (1,0),(2,1)"));
	}

	@Test
	public void shouldReturnItWithConfoundingI() {
		char[][] toSearch = { { 'i', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scanXAxisLookingLeftToRight(), is("it: (1,0),(2,1)"));
	}

	@Test
	public void shouldReturnItAtTwoOneOneZero() {
		char[][] toSearch = { { 'x', 't', 'x' }, { 'x', 'x', 'i' }, { 'x', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scanXAxisLookingLeftToRight(), is("it: (2,1),(1,0)"));
	}

	@Test
	public void shouldReturnNotFoundForCat() {
		char[][] toSearch = { { 'x', 't', 'x' }, { 'x', 'x', 'i' }, { 'x', 'x', 'x' } };
		createTest("cat", toSearch);
		assertThat(underTest.scanXAxisLookingLeftToRight(), is("not found"));
	}

	@Test
	public void shouldReturnItAtZeroOneOneTwo() {
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'i', 'x', 'x' }, { 'x', 't', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scanYAxisLookingLeftToRight(), is("it: (0,1),(1,2)"));
	}

	@Test
	public void shouldReturnItAtZeroTwoOneThree() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'i', 'x', 'x', 'x' },
				{ 'x', 't', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scanYAxisLookingLeftToRight(), is("it: (0,2),(1,3)"));
	}

	@Test
	public void shouldReturnItAtZeroTwoOneThreeWithConfoundingT() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'i', 'x', 't', 'x' },
				{ 'x', 't', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scanYAxisLookingLeftToRight(), is("it: (0,2),(1,3)"));
	}

	@Test
	public void shouldReturnItAtOneThreeZeroTwoWithConfoundingI() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scanYAxisLookingLeftToRight(), is("it: (1,3),(0,2)"));
	}

	@Test
	public void shouldReturnNotFoundForBat() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		createTest("bat", toSearch);
		assertThat(underTest.scanYAxisLookingLeftToRight(), is("not found"));
	}

	@Test
	public void shouldReturnCatAtTwoZeroOneOneZeroTwo() {
		char[][] toSearch = { { 'x', 'x', 'c' }, { 'x', 'a', 'x' }, { 't', 'x', 'x' } };
		createTest("cat", toSearch);
		assertThat(underTest.scanXAxisLookingRightToLeft(), is("cat: (2,0),(1,1),(0,2)"));
	}

	@Test
	public void shouldReturnAtAtOneOneZeroTwo() {
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'x', 'a', 'x' }, { 't', 'x', 'x' } };
		createTest("at", toSearch);
		assertThat(underTest.scanXAxisLookingRightToLeft(), is("at: (1,1),(0,2)"));
	}

	@Test
	public void shouldReturnAtAtOneZeroZeroOne() {
		char[][] toSearch = { { 'x', 'a', 'x' }, { 't', 'x', 'x' }, { 'x', 'x', 'x' } };
		createTest("at", toSearch);
		assertThat(underTest.scanXAxisLookingRightToLeft(), is("at: (1,0),(0,1)"));
	}

	@Test
	public void shouldReturnCatAtTwoZeroOneOneZeroTwoWithConfoundingLetters() {
		char[][] toSearch = { { 'x', 'x', 'c', 'c' }, { 't', 'a', 'a', 'x' }, { 't', 'x', 't', 'x' },
				{ 'x', 'x', 'x', 'x' } };
		createTest("cat", toSearch);
		assertThat(underTest.scanXAxisLookingRightToLeft(), is("cat: (2,0),(1,1),(0,2)"));
	}

	@Test
	public void shouldReturnCatAtZeroTwoOneOneTwoZeroWithConfoundingLetters() {
		char[][] toSearch = { 
				{ 'x', 'x', 't', 'c' }, 
				{ 'x', 'a', 'a', 'x' }, 
				{ 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		createTest("cat", toSearch);
		assertThat(underTest.scanXAxisLookingRightToLeft(), is("cat: (0,2),(1,1),(2,0)"));
	}

	@Test
	public void shouldReturnNotFoundForCog() {
		char[][] toSearch = { { 'x', 'x', 't', 'c' }, { 'x', 'a', 'a', 'x' }, { 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		createTest("cog", toSearch);
		assertThat(underTest.scanXAxisLookingRightToLeft(), is("not found"));
	}

	@Test
	public void shouldReturnCatAtThreeOneTwoTwoOneThree() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'c' }, { 'x', 'x', 'a', 'x' },
				{ 'x', 't', 'x', 'x', } };
		createTest("cat", toSearch);
		assertThat(underTest.scanYAxisLookingRightToLeft(), is("cat: (3,1),(2,2),(1,3)"));
	}

	@Test
	public void shouldReturnItAtTwoTwoOneThree() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'i', 'x' },
				{ 'x', 't', 'x', 'x', } };
		createTest("it", toSearch);
		assertThat(underTest.scanYAxisLookingRightToLeft(), is("it: (2,2),(1,3)"));
	}

	@Test
	public void shouldReturnOffAtThreeOneTwoTwoOneThree() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'o' }, { 'x', 'x', 'f', 'x' },
				{ 'x', 'f', 'x', 'x', } };
		createTest("off", toSearch);
		assertThat(underTest.scanYAxisLookingRightToLeft(), is("off: (3,1),(2,2),(1,3)"));
	}

	@Test
	public void shouldReturnOffAtThreeOneTwoTwo() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'f' }, { 'x', 'x', 'f', 'x' },
				{ 'x', 'o', 'x', 'x', } };
		createTest("off", toSearch);
		assertThat(underTest.scanYAxisLookingRightToLeft(), is("off: (1,3),(2,2),(3,1)"));
	}

	@Test
	public void shouldReturnOffAtThreeOneTwoTwoWithConfoundingLetters() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'f', 'o' }, { 'x', 'x', 'f', 'x', 'x' },
				{ 'x', 'o', 'x', 'x', 'o' }, { 'x', 'x', 'x', 'x', 'x' } };
		createTest("off", toSearch);
		assertThat(underTest.scanYAxisLookingRightToLeft(), is("off: (1,3),(2,2),(3,1)"));
	}

	@Test
	public void shouldReturnOffAtOneThreeTwoTwoThreeOneWithConfoundingLettersFromScan() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'f', 'o' }, { 'x', 'x', 'f', 'x', 'x' },
				{ 'x', 'o', 'x', 'x', 'o' }, { 'x', 'x', 'x', 'x', 'x' } };
		createTest("off", toSearch);
		assertThat(underTest.scan(), is("off: (1,3),(2,2),(3,1)"));
	}

	@Test
	public void shouldReturnCatAtZeroTwoOneOneTwoZeroWithConfoundingLettersFromScan() {
		char[][] toSearch = { { 'x', 'x', 't', 'c' }, { 'x', 'a', 'a', 'x' }, { 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		createTest("cat", toSearch);
		assertThat(underTest.scan(), is("cat: (0,2),(1,1),(2,0)"));
	}

	@Test
	public void shouldReturnItAtThreeOneZeroTwoWithConfoundingIFromScan() {
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scan(), is("it: (1,3),(0,2)"));
	}

	@Test
	public void shouldReturnItAtOneZeroTwoOneWithConfoundingIFromScan() {
		char[][] toSearch = { { 'i', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		createTest("it", toSearch);
		assertThat(underTest.scan(), is("it: (1,0),(2,1)"));
	}

}
