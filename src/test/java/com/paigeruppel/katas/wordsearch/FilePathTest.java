package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FilePathTest {

	private FilePath underTest;
	
	@Before
	public void setup() {
		underTest = new FilePath();
	}
	
	@Test
	public void shouldReturnAbsolutePathForStarTrekSearch() {
		assertThat(underTest.getFullFileName("StarTrekSearch.txt"),is("C:\\Users\\Paige\\code\\code-katas\\wordsearch\\bin\\StarTrekSearch.txt"));
	}
	
	@Test
	public void shouldReturnAbsolutePathForOakSpeciesSearch() {
		assertThat(underTest.getFullFileName("OakSpeciesSearch.txt"), is("C:\\Users\\Paige\\code\\code-katas\\wordsearch\\bin\\OakSpeciesSearch.txt"));
	}
}
