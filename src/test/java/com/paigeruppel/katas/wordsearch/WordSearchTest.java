package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private String toFind;
	private LetterGrid grid;

	@Test
	public void shouldReturnCatAtOneThreeTwoTwoThreeOneDiagRToL() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x', 'x' }, { 'x', 'x', 'x', 'c' }, { 'x', 'x', 'a', 'x' },
				{ 'x', 't', 'x', 'x', } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("cat: (1,3),(2,2),(3,1)"));
	}

	@Test
	public void shouldReturnLaAtRowOneColumnOneTwoWithConfoundingLHorizontal() {
		toFind = "la";
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'l', 'a' }, { 'x', 'x', 'x' } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("la: (1,1),(1,2)"));
	}

	@Test
	public void shouldReturnAtFitColumnTwoRowZeroOneTwoWithConfoundingFiVertical() {
		toFind = "fit";
		char[][] toSearch = { { 'x', 'f', 'f' }, { 'x', 'i', 'i' }, { 'x', 'x', 't' } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("fit: (0,2),(1,2),(2,2)"));
	}

	@Test
	public void shouldReturnItAtZeroOneOneTwoWithConfoundingIDiagLToRColumn() {
		toFind = "it";
		char[][] toSearch = { { 'i', 'i', 'x' }, { 'x', 'x', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("it: (0,1),(1,2)"));
	}

	@Test
	public void shouldReturnItAtThreeOneTwoZeroWithConfoundingIDiagLToRRows() {
		toFind = "it";
		char[][] toSearch = { 
				{ 'x', 'x', 'x', 'x' }, 
				{ 'x', 'x', 'x', 'x' }, 
				{ 't', 'x', 'i', 'x' },
				{ 'x', 'i', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		WordSearch underTest = new WordSearch(grid);
		assertThat(underTest.find(toFind), is("it: (3,1),(2,0)"));
	}

	@Test
	public void shouldReturnCatAtTwoZeroOneOneZeroTwoWithConfoundingLettersRToLColumn() {
		toFind = "cat";
		char[][] toSearch = { 
				{ 'x', 'x', 't', 'c' }, 
				{ 'x', 'a', 'a', 'x' }, 
				{ 'c', 'x', 'x', 'x' },
				{ 'x', 'x', 'x', 'x', } };
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		assertThat(underTest.find(toFind), is("cat: (2,0),(1,1),(0,2)"));
	}
	
	
	@Test
	public void shouldReturnBillAndLawFromSameGrid() {
		ArrayList<String> listToFind = new ArrayList();
		listToFind.add(0, "bill");
		listToFind.add(1, "law");
		char[][] toSearch = {
				{'b','i','l','l'},
				{'x','x','a','x'},
				{'x','x','w','x'},
				{'x','x','x','x'}};
		
		WordSearch underTest = new WordSearch(new LetterGrid(toSearch));
		
		assertThat(underTest.findAll(listToFind), is("bill: (0,0),(0,1),(0,2),(0,3)\r\nlaw: (0,2),(1,2),(2,2)\r\n"));
	}
}
