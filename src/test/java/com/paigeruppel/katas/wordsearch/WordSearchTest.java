package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordSearchTest {

	private String toFind;

	private List<String> foundWordsWithCoords = new ArrayList<String>();

	private WordSearch underTest;
	
	
	public void buildTest(char[][] toSearch) {
		underTest = new WordSearch(new LetterGrid(toSearch));
	}

	@Test
	public void shouldReturnCatFromDiagRToL() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'c' }, { 'x', 'x', 'a', 'x' },
				{ 'x', 't', 'x', 'x', } };
		buildTest(toSearch);
		assertThat(underTest.find(toFind), is("cat: (3,1),(2,2),(1,3)"));
	}

	@Test
	public void shouldReturnLaFromHorizontal() {
		toFind = "la";
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'l', 'a' }, { 'x', 'x', 'x' } };
		buildTest(toSearch);
		assertThat(underTest.find(toFind), is("la: (1,1),(2,1)"));
	}

	@Test
	public void shouldReturnAtFitFromVertical() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 'f' }, { 'x', 'i', 'i' }, { 'x', 'x', 't' } };
		buildTest(toSearch);
		assertThat(underTest.find(toFind), is("fit: (2,0),(2,1),(2,2)"));
	}

	@Test
	public void shouldReturnItFromDiagLToRColumn() {
		toFind = "it";
		char[][] toSearch = { { 'i', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		buildTest(toSearch);
		assertThat(underTest.find(toFind), is("it: (1,0),(2,1)"));
	}

	@Test
	public void shouldReturnItFromDiagLToRRows() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		buildTest(toSearch);
		assertThat(underTest.find(toFind), is("it: (1,3),(0,2)"));
	}

	@Test
	public void shouldReturnCatFromRToLColumn() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 't', 'c' }, { 'x', 'a', 'a', 'x' }, { 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		buildTest(toSearch);
		assertThat(underTest.find(toFind), is("cat: (0,2),(1,1),(2,0)"));
	}

	@Test
	public void shouldReturnEnterpriseCrewInAlphabeticalOrder() {
		WordSearch starTrek = new WordSearch("StarTrekSearch.txt");

		foundWordsWithCoords.add("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)");
		foundWordsWithCoords.add("KHAN: (5,9),(5,8),(5,7),(5,6)");
		foundWordsWithCoords.add("KIRK: (4,7),(3,7),(2,7),(1,7)");
		foundWordsWithCoords.add("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)");
		foundWordsWithCoords.add("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)");
		foundWordsWithCoords.add("SULU: (3,3),(2,2),(1,1),(0,0)");
		foundWordsWithCoords.add("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)");
		
		starTrek.buildAnswerList();
		assertThat(starTrek.getFoundWordsWithCoords(), is(foundWordsWithCoords));
	}
}
