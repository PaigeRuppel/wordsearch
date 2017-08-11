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
		assertThat(createTest(toFind, grid).scan(), is("cat: (1,0),(1,1),(1,2)"));
	}

	@Test
	public void shouldReturnCatAtColumnZeroRowZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'c', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("cat: (0,0),(0,1),(0,2)"));
	}
	
	@Test
	public void shouldReturnAtAtColumnZeroRowOneTwo() {
		toFind = "at";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("at: (0,1),(0,2)"));
	}
	
	@Test
	public void shouldReturnAtAtColumnZeroRowOneTwoWithConfoundingA() {
		toFind = "at";
		char[][] toSearch = { { 'a', 'x', 'x' }, { 'a', 'x', 'x' }, { 't', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("at: (0,1),(0,2)"));
	}
	
	@Test
	public void shouldReturnAtFitColumnTwoRowZeroOneTwoWithConfoundingFi() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 'f' }, 
								{ 'x', 'i', 'i' }, 
								{ 'x', 'x', 't' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("fit: (2,0),(2,1),(2,2)"));
	}
	
	@Test
	public void shouldReturnFitAtColumnTwoRowTwoOneZeroWithConfoundingFi() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 't' }, { 'x', 'i', 'i' }, { 'x', 'x', 'f' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("fit: (2,2),(2,1),(2,0)"));
	}
	
	@Test
	public void shouldReturnNotFoundForBit() {
		toFind = "bit";
		char[][] toSearch = { { 'x', 'f', 't' }, { 'x', 'i', 'i' }, { 'x', 'x', 'f' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("not found"));
	}
	
	@Test
	public void shouldReturnNotFoundForBill() {
		toFind = "bill";
		char[][] toSearch = { { 'b', 'i', 'l', 'l' }, { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' },
				{ 'x', 'b', 'a', 'l' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("not found"));
	}
	
	@Test
	public void shouldReturnKahnXCoords5YCoords9Through6() {
		toFind = "KHAN";
		char[][] toSearch = {
				{'U','M','K','H','U','L','K','I','N','V','J','O','C','W','E'},
				{'L','L','S','H','K','Z','Z','W','Z','C','G','J','U','Y','G'},
				{'H','S','U','P','J','P','R','J','D','H','S','B','X','T','G'},
				{'B','R','J','S','O','E','Q','E','T','I','K','K','G','L','E'},
				{'A','Y','O','A','G','C','I','R','D','Q','H','R','T','C','D'},
				{'S','C','O','T','T','Y','K','Z','R','E','P','P','X','P','F'},
				{'B','L','Q','S','L','N','E','E','E','V','U','L','F','M','Z'},
				{'O','K','R','I','K','A','M','M','R','M','F','B','A','P','P'},
				{'N','U','I','I','Y','H','Q','M','E','M','Q','R','Y','F','S'},
				{'E','Y','Z','Y','G','K','Q','J','P','C','Q','W','Y','A','K'},
				{'S','J','F','Z','M','Q','I','B','D','B','E','M','K','W','D'},
				{'T','G','L','B','H','C','B','E','C','H','T','O','Y','I','K'},
				{'O','J','Y','E','U','L','N','C','C','L','Y','B','Z','U','H'},
				{'W','Z','M','I','S','U','K','U','R','B','I','D','U','X','S'},
				{'K','Y','L','B','Q','Q','P','M','D','F','C','K','E','A','B'}};
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).scan(), is("KHAN: (5,9),(5,8),(5,7),(5,6)"));
	}
}
