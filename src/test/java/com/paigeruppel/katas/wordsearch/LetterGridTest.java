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
		assertThat(underTest.getCharacterAt(0, 0), is('a'));
	}

	@Test
	public void shouldReturnBFromCoordsZeroOne() {
		assertThat(underTest.getCharacterAt(0, 1), is('b'));
	}

	@Test
	public void shouldReturnCFromLookAtNextHorizontalPositionFromZeroOne() {
		assertThat(underTest.getNextCharacterHorizontalFrom(0,1), is('c'));
	}
	
	@Test
	public void shouldReturnFFromLookAtNextHorizontalPositionFromOneOne() {
		assertThat(underTest.getNextCharacterHorizontalFrom(1,1), is('f'));
	}
	
	@Test
	public void shouldReturn0FromLookAtNextHorizontalPositionFromOneTwo() {
		assertThat(underTest.getNextCharacterHorizontalFrom(1,2), is('0'));
	}
}
