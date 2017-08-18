package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordSearchTest {

	private String toFind;
	private LetterGrid grid;
	private List<String> listToFind = new ArrayList<String>();
	private List<String> allWordsWithCoords = new ArrayList<String>();

	@Test
	public void shouldReturnCatFromDiagRToL() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'c' }, { 'x', 'x', 'a', 'x' },
				{ 'x', 't', 'x', 'x', } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("cat: (3,1),(2,2),(1,3)"));
	}

	@Test
	public void shouldReturnLaFromHorizontal() {
		toFind = "la";
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'l', 'a' }, { 'x', 'x', 'x' } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("la: (1,1),(2,1)"));
	}

	@Test
	public void shouldReturnAtFitFromVertical() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 'f' }, { 'x', 'i', 'i' }, { 'x', 'x', 't' } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("fit: (2,0),(2,1),(2,2)"));
	}

	@Test
	public void shouldReturnItFromDiagLToRColumn() {
		toFind = "it";
		char[][] toSearch = { { 'i', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("it: (1,0),(2,1)"));
	}

	@Test
	public void shouldReturnItFromDiagLToRRows() {
		toFind = "it";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'x' }, { 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("it: (1,3),(0,2)"));
	}

	@Test
	public void shouldReturnCatFromRToLColumn() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 't', 'c' }, { 'x', 'a', 'a', 'x' }, { 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("cat: (0,2),(1,1),(2,0)"));
	}

	@Test
	public void shouldReturnBillAndLawFromSameGrid() {
		listToFind.add(0, "bill");
		listToFind.add(1, "law");
		char[][] toSearch = { { 'b', 'i', 'l', 'l' }, { 'x', 'x', 'a', 'x' }, { 'x', 'x', 'w', 'x' },
				{ 'x', 'x', 'x', 'x' } };

		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		allWordsWithCoords.add("bill: (0,0),(1,0),(2,0),(3,0)");
		allWordsWithCoords.add("law: (2,0),(2,1),(2,2)");
		assertThat(underTest.findAll(listToFind), is(allWordsWithCoords));
	}

	@Test
	public void shouldReturnEnterpriseCrewInAlphabeticalOrder() {
		listToFind.add("BONES");
		listToFind.add("KHAN");
		listToFind.add("KIRK");
		listToFind.add("SCOTTY");
		listToFind.add("SPOCK");
		listToFind.add("SULU");
		listToFind.add("UHURA");
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
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		allWordsWithCoords.add("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)");
		allWordsWithCoords.add("KHAN: (5,9),(5,8),(5,7),(5,6)");
		allWordsWithCoords.add("KIRK: (4,7),(3,7),(2,7),(1,7)");
		allWordsWithCoords.add("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)");
		allWordsWithCoords.add("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)");
		allWordsWithCoords.add("SULU: (3,3),(2,2),(1,1),(0,0)");
		allWordsWithCoords.add("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)");

		assertThat(underTest.findAll(listToFind), is(allWordsWithCoords));
	}
}
