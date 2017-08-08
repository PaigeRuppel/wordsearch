package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LetterGridTest {


	@Test
	public void shouldReturnAFromCoordsZeroZero() {
		char[][] toSearch = {{'a', 'b', 'c'}, {'d','e','f'},{'g','h','i'}};
		LetterGrid underTest = new LetterGrid(toSearch);
		assertThat(underTest.getCharacterAt(0, 0), is('a'));
	}
	
	@Test
	public void shouldReturnBFromCoordsZeroOne() {
		char[][] toSearch = {{'a', 'b', 'c'}, {'d','e','f'},{'g','h','i'}};
		LetterGrid underTest = new LetterGrid(toSearch);
		assertThat(underTest.getCharacterAt(0, 1), is('b'));
	}
}
