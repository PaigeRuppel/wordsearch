package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class TextFileReaderTest {

	
	@Test
	public void shouldReadFirstLineStarTrekSearchAsAStringArrayList() {
		String starTrekFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\StarTrekSearch.txt";
		TextFileReader underTest = new TextFileReader();
		ArrayList<String> listToFind = new ArrayList<>();
		listToFind.add(0, "BONES");
		listToFind.add(1, "KHAN");
		listToFind.add(2, "KIRK");
		listToFind.add(3, "SCOTTY");
		listToFind.add(4, "SPOCK");
		listToFind.add(5, "SULU");
		listToFind.add(6, "UHURA");
		assertThat(underTest.readFirstLine(starTrekFile), is(listToFind));
	}
	
	@Test
	public void shouldReadFirstLineOakSpeciesSearchAsAStringArrayList() {
		String oakSpeciesFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\OakSpeciesSearch.txt";
		TextFileReader underTest = new TextFileReader();
		ArrayList<String> listToFind = new ArrayList<>();
		listToFind.add(0, "ACERIFOLIA");
		listToFind.add(1, "ALBUS");
		listToFind.add(2, "BICOLOR");
		listToFind.add(3, "COCCINEA");
		listToFind.add(4, "IMBRICARIA");
		listToFind.add(5, "MACROCARPA");
		listToFind.add(6, "PRINUS");
		listToFind.add(7, "RUBRA");
		listToFind.add(8, "SHUMARDII");
		listToFind.add(9, "VELUTINA");
		assertThat(underTest.readFirstLine(oakSpeciesFile), is(listToFind));
	}
	

}
