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
	
	@Test
	public void shouldReturnEFromLookAtNextVerticalPositionFromZeroOne() {
		assertThat(underTest.getNextCharacterVerticalFrom(0,1), is('e'));
	}
	
	@Test
	public void shouldReturnDFromLookAtNextVerticalPositionFromZeroZero() {
		assertThat(underTest.getNextCharacterVerticalFrom(0,0), is('d'));
	}
	
	@Test
	public void shouldReturn0FromLookAtNextVerticalPositionFromTwoZero() {
		assertThat(underTest.getNextCharacterVerticalFrom(2,0), is('0'));
	}
	
	@Test
	public void shouldReturnEFromLookAtNextLToRDiagonalPositionFromZeroZero() {
		assertThat(underTest.getNextCharacterLToRDiagonalFrom(0,0), is('e'));
	}
	
	@Test
	public void shouldReturnFFromLookAtNextLToRDiagonalPositionFromZeroOne() {
		assertThat(underTest.getNextCharacterLToRDiagonalFrom(0,1), is('f'));
	}
	
	@Test
	public void shouldReturn0FromLookAtNextLToRDiagonalPositionFromZeroTwo() {
		assertThat(underTest.getNextCharacterLToRDiagonalFrom(0,2), is('0'));
	}
	
	@Test
	public void shouldReturn0FromLookAtNextLToRDiagonalPositionFromTwoZero() {
		assertThat(underTest.getNextCharacterLToRDiagonalFrom(2,0), is('0'));
	}
	
	@Test
	public void shouldReturnEFromLookAtNextRToLDiagonalPositionFromZeroTwo() {
		assertThat(underTest.getNextCharacterRToLDiagonalFrom(0,2), is('e'));
	}
	
	@Test
	public void shouldReturnDFromLookAtNextRToLDiagonalPositionFromZeroOne() {
		assertThat(underTest.getNextCharacterRToLDiagonalFrom(0,1), is('d'));
	}
	
	@Test
	public void shouldReturn0FromLookAtNextRToLDiagonalPositionFromZeroZero() {
		assertThat(underTest.getNextCharacterRToLDiagonalFrom(0,0), is('0'));
	}
}
