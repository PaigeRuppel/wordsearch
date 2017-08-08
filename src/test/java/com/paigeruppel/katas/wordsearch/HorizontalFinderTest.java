package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.paigeruppel.katas.wordsearch.HorizontalFinder;

public class HorizontalFinderTest {

	public HorizontalFinder createTest(String toFind, char[][]toSearch) {
		return new HorizontalFinder(toFind, toSearch);
	}
	@Test
	public void shouldReturnCatAtRowOneColumnZeroOneTwo() {
		String toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'c', 'a', 't' }, { 'x', 'x', 'x' } };
		assertThat(createTest(toFind, toSearch).horizontalScan(), is("cat:(1,0)(1,1)(1,2)"));
	}

	@Test
	public void shouldReturnCatAtRowZeroColumnZeroOneTwo() {
		String toFind = "cat";
		char[][] toSearch = { { 'c', 'a', 't' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		assertThat(createTest(toFind, toSearch).horizontalScan(), is("cat:(0,0)(0,1)(0,2)"));
	}

	@Test
	public void shouldReturnLaAtRowZeroColumnOneTwo() {
		String toFind = "la";
		char[][] toSearch = { { 'x', 'l', 'a' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		assertThat(createTest(toFind, toSearch).horizontalScan(), is("la:(0,1)(0,2)"));
	}
}
