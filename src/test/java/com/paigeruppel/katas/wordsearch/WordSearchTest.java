package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WordSearchTest {

	
	@Test
	public void shouldReturnCatAtOneThreeTwoTwoThreeOneDiagRToL() {
		String toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'c' }, { 'x', 'x', 'a', 'x' },
				{ 'x', 't', 'x', 'x', } };
		LetterGrid grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("cat: (1,3),(2,2),(3,1)"));
	}
}
