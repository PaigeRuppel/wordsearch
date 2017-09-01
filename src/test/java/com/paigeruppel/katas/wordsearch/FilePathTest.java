package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FilePathTest {

	
	@Test
	public void shouldReturnAbsolutePathForStarTrekSearch() {
		FilePath underTest = new FilePath();
		assertThat(underTest.getFullFileName("StarTrekSearch.txt"),is("C:\\Users\\Paige\\code\\code-katas\\wordsearch\\bin\\StarTrekSearch.txt"));
	}
	
	@Test
	public void shouldReturnAbsolutePathForOakSpeciesSearch() {
		FilePath underTest = new FilePath();
		assertThat(underTest.getFullFileName("OakSpeciesSearch.txt"), is("C:\\Users\\Paige\\code\\code-katas\\wordsearch\\bin\\OakSpeciesSearch.txt"));
	}
}
