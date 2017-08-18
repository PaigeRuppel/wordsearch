package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordSearchAppTest {

	@Test
	public void shouldReturnFilenameForOakSpecies() {
		String pathPlusFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\"
				+ "OakSpeciesSearch.txt";
		assertThat(WordSearchApp.getFilename("OakSpeciesSearch.txt"), is(pathPlusFile));
	}
	
	@Test
	public void shouldReturnListWithCoordsForStarTrekSearch() {
		List<String> allWordsWithCoords = new ArrayList<>();
		allWordsWithCoords.add("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)");
		allWordsWithCoords.add("KHAN: (5,9),(5,8),(5,7),(5,6)");
		allWordsWithCoords.add("KIRK: (4,7),(3,7),(2,7),(1,7)");
		allWordsWithCoords.add("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)");
		allWordsWithCoords.add("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)");
		allWordsWithCoords.add("SULU: (3,3),(2,2),(1,1),(0,0)");
		allWordsWithCoords.add("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)");
		assertThat(WordSearchApp.findWords("StarTrekSearch.txt"), is(allWordsWithCoords));
	}
}
