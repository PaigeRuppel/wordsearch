package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TextFileReaderTest {

	private String starTrekFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\StarTrekSearch.txt";
	private String oakSpeciesFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\OakSpeciesSearch.txt";

	private TextFileReader starTrekReader;
	private TextFileReader oakSpeciesReader;

	@Before
	public void setup() {
		starTrekReader = new TextFileReader(starTrekFile);
		oakSpeciesReader = new TextFileReader(oakSpeciesFile);
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
		assertThat(starTrekReader.readFirstLine(), is(listToFind));
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
		assertThat(oakSpeciesReader.readFirstLine(), is(listToFind));
	}

	@Test
	public void shouldReturnLetterGridAsCharArrayArrayFromStarTrekSearch() {
		char[][] starTrekGrid = { { 'U', 'M', 'K', 'H', 'U', 'L', 'K', 'I', 'N', 'V', 'J', 'O', 'C', 'W', 'E' },
				{ 'L', 'L', 'S', 'H', 'K', 'Z', 'Z', 'W', 'Z', 'C', 'G', 'J', 'U', 'Y', 'G' },
				{ 'H', 'S', 'U', 'P', 'J', 'P', 'R', 'J', 'D', 'H', 'S', 'B', 'X', 'T', 'G' },
				{ 'B', 'R', 'J', 'S', 'O', 'E', 'Q', 'E', 'T', 'I', 'K', 'K', 'G', 'L', 'E' },
				{ 'A', 'Y', 'O', 'A', 'G', 'C', 'I', 'R', 'D', 'Q', 'H', 'R', 'T', 'C', 'D' },
				{ 'S', 'C', 'O', 'T', 'T', 'Y', 'K', 'Z', 'R', 'E', 'P', 'P', 'X', 'P', 'F' },
				{ 'B', 'L', 'Q', 'S', 'L', 'N', 'E', 'E', 'E', 'V', 'U', 'L', 'F', 'M', 'Z' },
				{ 'O', 'K', 'R', 'I', 'K', 'A', 'M', 'M', 'R', 'M', 'F', 'B', 'A', 'P', 'P' },
				{ 'N', 'U', 'I', 'I', 'Y', 'H', 'Q', 'M', 'E', 'M', 'Q', 'R', 'Y', 'F', 'S' },
				{ 'E', 'Y', 'Z', 'Y', 'G', 'K', 'Q', 'J', 'P', 'C', 'Q', 'W', 'Y', 'A', 'K' },
				{ 'S', 'J', 'F', 'Z', 'M', 'Q', 'I', 'B', 'D', 'B', 'E', 'M', 'K', 'W', 'D' },
				{ 'T', 'G', 'L', 'B', 'H', 'C', 'B', 'E', 'C', 'H', 'T', 'O', 'Y', 'I', 'K' },
				{ 'O', 'J', 'Y', 'E', 'U', 'L', 'N', 'C', 'C', 'L', 'Y', 'B', 'Z', 'U', 'H' },
				{ 'W', 'Z', 'M', 'I', 'S', 'U', 'K', 'U', 'R', 'B', 'I', 'D', 'U', 'X', 'S' },
				{ 'K', 'Y', 'L', 'B', 'Q', 'Q', 'P', 'M', 'D', 'F', 'C', 'K', 'E', 'A', 'B' } };
		assertThat(starTrekReader.buildLetterGrid(), is(starTrekGrid));
	}

	@Test
	public void shouldReturnLetterGridAsCharArrayFromOakSpeciesSearch() {
		char[][] oakSpeciesGrid = {
				{ 'C', 'S', 'U', 'N', 'I', 'R', 'P', 'B', 'P', 'U', 'O', 'Y', 'W', 'J', 'X', 'C', 'I', 'P', 'I', 'N' },
				{ 'E', 'O', 'V', 'O', 'K', 'B', 'I', 'Y', 'K', 'P', 'I', 'M', 'S', 'Y', 'V', 'Z', 'P', 'J', 'M', 'J' },
				{ 'V', 'X', 'C', 'N', 'S', 'C', 'P', 'G', 'T', 'L', 'L', 'C', 'F', 'H', 'M', 'M', 'W', 'C', 'V', 'J' },
				{ 'V', 'M', 'F', 'C', 'O', 'R', 'N', 'U', 'F', 'F', 'A', 'M', 'K', 'E', 'H', 'Z', 'H', 'S', 'D', 'D' },
				{ 'U', 'O', 'A', 'L', 'I', 'K', 'L', 'K', 'F', 'A', 'I', 'Y', 'O', 'B', 'N', 'P', 'M', 'B', 'R', 'W' },
				{ 'K', 'E', 'O', 'Q', 'I', 'N', 'O', 'O', 'H', 'R', 'R', 'C', 'F', 'V', 'D', 'V', 'J', 'N', 'V', 'Q' },
				{ 'M', 'R', 'W', 'C', 'M', 'M', 'E', 'P', 'U', 'B', 'A', 'S', 'A', 'L', 'J', 'A', 'Y', 'E', 'P', 'J' },
				{ 'G', 'Q', 'G', 'J', 'V', 'Q', 'J', 'A', 'V', 'U', 'C', 'V', 'X', 'A', 'S', 'T', 'O', 'E', 'G', 'E' },
				{ 'A', 'I', 'W', 'F', 'Q', 'N', 'A', 'A', 'E', 'R', 'I', 'S', 'D', 'A', 'W', 'V', 'P', 'B', 'J', 'M' },
				{ 'N', 'I', 'B', 'H', 'H', 'Q', 'J', 'U', 'L', 'V', 'R', 'B', 'C', 'V', 'A', 'J', 'X', 'O', 'S', 'X' },
				{ 'X', 'A', 'L', 'D', 'N', 'P', 'N', 'F', 'U', 'A', 'B', 'L', 'E', 'P', 'U', 'R', 'L', 'R', 'I', 'I' },
				{ 'U', 'V', 'S', 'O', 'P', 'U', 'A', 'Q', 'T', 'V', 'M', 'G', 'R', 'F', 'M', 'G', 'I', 'L', 'P', 'M' },
				{ 'Y', 'S', 'S', 'U', 'F', 'S', 'U', 'U', 'I', 'A', 'I', 'A', 'Q', 'V', 'N', 'K', 'X', 'E', 'M', 'W' },
				{ 'T', 'D', 'N', 'H', 'B', 'I', 'X', 'M', 'N', 'Z', 'C', 'S', 'H', 'U', 'M', 'A', 'R', 'D', 'I', 'I' },
				{ 'I', 'T', 'G', 'V', 'P', 'L', 'R', 'S', 'A', 'O', 'H', 'G', 'F', 'V', 'M', 'H', 'J', 'S', 'C', 'B' },
				{ 'L', 'Q', 'I', 'W', 'A', 'Z', 'A', 'E', 'R', 'A', 'T', 'P', 'W', 'Z', 'H', 'Y', 'Z', 'C', 'P', 'K' },
				{ 'W', 'A', 'N', 'W', 'C', 'X', 'H', 'C', 'C', 'G', 'B', 'R', 'D', 'J', 'W', 'D', 'M', 'Q', 'K', 'P' },
				{ 'A', 'M', 'U', 'V', 'I', 'S', 'A', 'Z', 'B', 'A', 'Q', 'E', 'R', 'F', 'W', 'T', 'K', 'Q', 'U', 'Q' },
				{ 'C', 'W', 'Q', 'R', 'K', 'M', 'S', 'W', 'D', 'Z', 'N', 'C', 'P', 'H', 'W', 'N', 'F', 'E', 'I', 'F' },
				{ 'E', 'K', 'N', 'C', 'I', 'R', 'N', 'V', 'G', 'S', 'I', 'D', 'J', 'N', 'U', 'H', 'J', 'F', 'R', 'X' } };
		assertThat(oakSpeciesReader.buildLetterGrid(), is(oakSpeciesGrid));
	}

}
