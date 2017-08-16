package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

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
		assertThat(createTest(toFind, grid).scanXAxisLookingLeftToRight(), is("cat: (0,0),(1,1),(2,2)"));
	}

	@Test
	public void shouldReturnItAtOneOneTwoTwo() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'x', 'i', 'x' }, { 'x', 'x', 't' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingLeftToRight(), is("it: (1,1),(2,2)"));
	}

	@Test
	public void shouldReturnItAtOneZeroOneTwo() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingLeftToRight(), is("it: (1,0),(2,1)"));
	}

	@Test
	public void shouldReturnItWithConfoundingI() {
		toFind = "it";
		char[][] toSearch = { { 'i', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingLeftToRight(), is("it: (1,0),(2,1)"));
	}

	@Test
	public void shouldReturnItAtTwoOneOneZero() {
		toFind = "it";
		char[][] toSearch = { { 'x', 't', 'x' }, { 'x', 'x', 'i' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingLeftToRight(), is("it: (2,1),(1,0)"));
	}

	@Test
	public void shouldReturnNotFoundForCat() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 't', 'x' }, { 'x', 'x', 'i' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingLeftToRight(), is("not found"));
	}

	@Test
	public void shouldReturnItAtZeroOneOneTwo() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'i', 'x', 'x' }, { 'x', 't', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingLeftToRight(), is("it: (0,1),(1,2)"));
	}

	@Test
	public void shouldReturnItAtZeroTwoOneThree() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'i', 'x', 'x', 'x' },
				{ 'x', 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingLeftToRight(), is("it: (0,2),(1,3)"));
	}

	@Test
	public void shouldReturnItAtZeroTwoOneThreeWithConfoundingT() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'i', 'x', 't', 'x' },
				{ 'x', 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingLeftToRight(), is("it: (0,2),(1,3)"));
	}

	@Test
	public void shouldReturnItAtOneThreeZeroTwoWithConfoundingI() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingLeftToRight(), is("it: (1,3),(0,2)"));
	}

	@Test
	public void shouldReturnNotFoundForBat() {
		toFind = "bat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingLeftToRight(), is("not found"));
	}

	@Test
	public void shouldReturnCatAtTwoZeroOneOneZeroTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'c' }, { 'x', 'a', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingRightToLeft(), is("cat: (2,0),(1,1),(0,2)"));
	}

	@Test
	public void shouldReturnAtAtOneOneZeroTwo() {
		toFind = "at";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'x', 'a', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingRightToLeft(), is("at: (1,1),(0,2)"));
	}

	@Test
	public void shouldReturnAtAtOneZeroZeroOne() {
		toFind = "at";
		char[][] toSearch = { { 'x', 'a', 'x' }, { 't', 'x', 'x' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingRightToLeft(), is("at: (1,0),(0,1)"));
	}

	@Test
	public void shouldReturnCatAtTwoZeroOneOneZeroTwoWithConfoundingLetters() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'c', 'c' }, { 't', 'a', 'a', 'x' }, { 't', 'x', 't', 'x' },
				{ 'x', 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingRightToLeft(), is("cat: (2,0),(1,1),(0,2)"));
	}

	@Test
	public void shouldReturnCatAtZeroTwoOneOneTwoZeroWithConfoundingLetters() {
		toFind = "cat";
		char[][] toSearch = { 
				{ 'x', 'x', 't', 'c' }, 
				{ 'x', 'a', 'a', 'x' }, 
				{ 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingRightToLeft(), is("cat: (0,2),(1,1),(2,0)"));
	}
	
	@Test
	public void shouldReturnNotFoundForCog() {
		toFind = "cog";
		char[][] toSearch = { { 'x', 'x', 't', 'c' }, { 'x', 'a', 'a', 'x' }, { 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanXAxisLookingRightToLeft(), is("not found"));
	}
	
	@Test
	public void shouldReturnCatAtThreeOneTwoTwoOneThree() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'c' }, { 'x', 'x', 'a', 'x' },
				{ 'x', 't', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingRightToLeft(), is("cat: (3,1),(2,2),(1,3)"));
	}

	@Test
	public void shouldReturnItAtTwoTwoOneThree() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'i', 'x' },
				{ 'x', 't', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingRightToLeft(), is("it: (2,2),(1,3)"));
	}
	
	@Test
	public void shouldReturnOffAtThreeOneTwoTwoOneThree() {
		toFind = "off";
		char[][] toSearch = { 
				{ 'x', 'x', 'x', 'x' }, 
				{ 'x', 'x', 'x', 'o' }, 
				{ 'x', 'x', 'f', 'x' },
				{ 'x', 'f', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingRightToLeft(), is("off: (3,1),(2,2),(1,3)"));
	}
	
	@Test
	public void shouldReturnOffAtThreeOneTwoTwo() {
		toFind = "off";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'f' }, { 'x', 'x', 'f', 'x' },
				{ 'x', 'o', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingRightToLeft(), is("off: (1,3),(2,2),(3,1)"));
	}
	
	@Test
	public void shouldReturnOffAtThreeOneTwoTwoWithConfoundingLetters() {
		toFind = "off";
		char[][] toSearch = { 
				{ 'x', 'x', 'x', 'x', 'x' }, 
				{ 'x', 'x', 'x', 'f', 'o' }, 
				{ 'x', 'x', 'f', 'x', 'x' },
				{ 'x', 'o', 'x', 'x', 'o' },
				{ 'x', 'x', 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scanYAxisLookingRightToLeft(), is("off: (1,3),(2,2),(3,1)"));
	}
	
	@Test
	public void shouldReturnOffAtOneThreeTwoTwoThreeOneWithConfoundingLettersFromScan() {
		// rows from top right
		toFind = "off";
		char[][] toSearch = { 
				{ 'x', 'x', 'x', 'x', 'x' }, 
				{ 'x', 'x', 'x', 'f', 'o' }, 
				{ 'x', 'x', 'f', 'x', 'x' },
				{ 'x', 'o', 'x', 'x', 'o' },
				{ 'x', 'x', 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("off: (1,3),(2,2),(3,1)"));
	}
	
	@Test
	public void shouldReturnCatAtZeroTwoOneOneTwoZeroWithConfoundingLettersFromScan() {
		// columns from top right
		toFind = "cat";
		char[][] toSearch = { 
				{ 'x', 'x', 't', 'c' }, 
				{ 'x', 'a', 'a', 'x' }, 
				{ 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("cat: (0,2),(1,1),(2,0)"));
	}

	@Test
	public void shouldReturnItAtThreeOneZeroTwoWithConfoundingIFromScan() {
		// rows from top left
		toFind = "it";
		char[][] toSearch = { 
				{ 'x', 'x', 'x', 'x' }, 
				{ 'x', 'x', 'x', 'x' }, 
				{ 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("it: (1,3),(0,2)"));
	}
	
	@Test
	public void shouldReturnItAtOneZeroTwoOneWithConfoundingIFromScan() {
		// columns from top left
		toFind = "it";
		char[][] toSearch = { 
				{ 'i', 'i', 'x' }, 
				{ 'x', 'x', 't' }, 
				{ 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("it: (1,0),(2,1)"));
	}
	


}
