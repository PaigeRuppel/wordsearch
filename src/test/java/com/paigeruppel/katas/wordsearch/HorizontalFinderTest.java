package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.paigeruppel.katas.wordsearch.HorizontalFinder;

public class HorizontalFinderTest {

	private LetterGrid grid;
	private String toFind;

	public HorizontalFinder createTest(String toFind, LetterGrid grid) {
		return new HorizontalFinder(toFind, grid);
	}

	@Test
	public void shouldReturnCatAtRowOneColumnZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'c', 'a', 't' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).horizontalScan(), is("cat:(1,0)(1,1)(1,2)"));
	}

	@Test
	public void shouldReturnCatAtRowZeroColumnZeroOneTwo() {
		toFind = "cat";
		char[][] toSearch = { { 'c', 'a', 't' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).horizontalScan(), is("cat:(0,0)(0,1)(0,2)"));
	}

	@Test
	public void shouldReturnLaAtRowZeroColumnOneTwo() {
		toFind = "la";
		char[][] toSearch = { { 'x', 'l', 'a' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).horizontalScan(), is("la:(0,1)(0,2)"));
	}

	@Test
	public void shouldReturnLaAtRowOneColumnOneTwoWithConfoundingL() {
		toFind = "la";
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'x', 'l', 'a' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).horizontalScan(), is("la:(1,1)(1,2)"));
	}

	@Test
	public void shouldReturnLaAtRowOneColumnOneTwoWithTwoConfoundingL() {
		toFind = "la";
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'l', 'l', 'a' }, { 'x', 'x', 'x' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).horizontalScan(), is("la:(1,1)(1,2)"));
	}
	
	@Test
	public void shouldReturnLabAtRowTwoColumnOneTwoWithConfoundingLa() {
		toFind = "lab";
		char[][] toSearch = { { 'l', 'x', 'x' }, { 'l', 'l', 'a' }, { 'l', 'a', 'b' } };
		grid = new LetterGrid(toSearch);
		assertThat(createTest(toFind, grid).horizontalScan(), is("lab:(2,0)(2,1)(2,2)"));
	}
}
