package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LetterGridTest {

	private LetterGrid underTest;

	@Before
	public void setup() {
		char[][] toSearch = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' } };
		underTest = new LetterGrid(toSearch);
	}

	@Test
	public void shouldReturnAFromCoordsZeroZero() {
		assertThat(underTest.charAt(0, 0), is('a'));
	}

	@Test
	public void shouldReturnBFromCoordsZeroOne() {
		assertThat(underTest.charAt(0, 1), is('b'));
	}

}
