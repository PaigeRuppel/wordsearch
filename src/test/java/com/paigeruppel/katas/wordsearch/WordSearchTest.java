package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WordSearchTest {

	private String toFind;
	private LetterGrid grid;
	
	@Test
	public void shouldReturnCatAtOneThreeTwoTwoThreeOneDiagRToL() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'c' }, { 'x', 'x', 'a', 'x' },
				{ 'x', 't', 'x', 'x', } };
		grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("cat: (1,3),(2,2),(3,1)"));
	}
	
	@Test
	public void shouldReturnLaAtRowOneColumnOneTwoWithConfoundingLHorizontal() {
		toFind = "la";
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'l', 'a' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("la: (1,1),(1,2)"));
	}
	
	@Test
	public void shouldReturnAtFitColumnTwoRowZeroOneTwoWithConfoundingFiVertical() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 'f' }, { 'x', 'i', 'i' }, { 'x', 'x', 't' } };
		grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("fit: (0,2),(1,2),(2,2)"));
	}
}
