package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.paigeruppel.katas.wordsearch.HorizontalFinder;

public class HorizontalFinderTest {

	@Test
	public void shouldReturnCatAtRowOneColumnZeroOneTwo() {
		HorizontalFinder underTest = new HorizontalFinder();
		String toFind = "cat";
		char[][] toSearch = { { 'x', 'x', 'x' }, { 'c', 'a', 't' }, { 'x', 'x', 'x' } };
		assertThat(underTest.horizontalScan(toFind, toSearch), is("cat:(1,0)(1,1)(1,2)"));
	}

	@Test
	public void shouldReturnCatAtRowZeroColumnZeroOneTwo() {
		HorizontalFinder underTest = new HorizontalFinder();
		String toFind = "cat";
		char[][] toSearch = { { 'c', 'a', 't' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		assertThat(underTest.horizontalScan(toFind, toSearch), is("cat:(0,0)(0,1)(0,2)"));
	}

	@Test
	public void shouldReturnLaAtRowZeroColumnOneTwo() {
		HorizontalFinder underTest = new HorizontalFinder();
		String toFind = "la";
		char[][] toSearch = { { 'x', 'l', 'a' }, { 'x', 'x', 'x' }, { 'x', 'x', 'x' } };
		assertThat(underTest.horizontalScan(toFind, toSearch), is("la:(0,1)(0,2)"));
	}
}
