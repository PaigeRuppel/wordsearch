package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TextFileReaderTest {

	private String starTrekFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\StarTrekSearch.txt";
	private String oakSpeciesFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\OakSpeciesSearch.txt";
	
	private TextFileReader underTest;
	
	@Before
	public void setup() {
		underTest = new TextFileReader();
	}
	
	@Test
	public void shouldReadFirstLineStarTrekSearchAsAStringArrayList() {
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
	
	@Test
	public void shouldReadLetterGridAsCharArrayArrayFromStarTrekSearch() {
		char[][] starTrekGrid = {
				{'U','M','K','H','U','L','K','I','N','V','J','O','C','W','E'},
				{'L','L','S','H','K','Z','Z','W','Z','C','G','J','U','Y','G'},
				{'H','S','U','P','J','P','R','J','D','H','S','B','X','T','G'},
				{'B','R','J','S','O','E','Q','E','T','I','K','K','G','L','E'},
				{'A','Y','O','A','G','C','I','R','D','Q','H','R','T','C','D'},
				{'S','C','O','T','T','Y','K','Z','R','E','P','P','X','P','F'},
				{'B','L','Q','S','L','N','E','E','E','V','U','L','F','M','Z'},
				{'O','K','R','I','K','A','M','M','R','M','F','B','A','P','P'},
				{'N','U','I','I','Y','H','Q','M','E','M','Q','R','Y','F','S'},
				{'E','Y','Z','Y','G','K','Q','J','P','C','Q','W','Y','A','K'},
				{'S','J','F','Z','M','Q','I','B','D','B','E','M','K','W','D'},
				{'T','G','L','B','H','C','B','E','C','H','T','O','Y','I','K'},
				{'O','J','Y','E','U','L','N','C','C','L','Y','B','Z','U','H'},
				{'W','Z','M','I','S','U','K','U','R','B','I','D','U','X','S'},
				{'K','Y','L','B','Q','Q','P','M','D','F','C','K','E','A','B'}};
		assertThat(underTest.buildLetterGrid(starTrekFile), is(starTrekGrid));
	}

	

}
