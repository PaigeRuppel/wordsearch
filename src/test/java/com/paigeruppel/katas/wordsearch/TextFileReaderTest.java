package com.paigeruppel.katas.wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TextFileReaderTest {

	
	@Test
	public void shouldReadFirstLineStarTrekSearch() {
		String starTrekFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\StarTrekSearch.txt";
		TextFileReader underTest = new TextFileReader();
	
		assertThat(underTest.readFirstLine(starTrekFile), is("BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA"));
	}
	
	@Test
	public void shouldReadFirstLineOakSpeciesSearch() {
		String oakSpeciesFile = "C:\\Users\\Paige\\code\\code-katas\\wordsearch\\src\\main\\resources\\OakSpeciesSearch.txt";
		TextFileReader underTest = new TextFileReader();
	
		assertThat(underTest.readFirstLine(oakSpeciesFile), is("ACERIFOLIA,ALBUS,BICOLOR,COCCINEA,IMBRICARIA,MACROCARPA,PRINUS,RUBRA,SHUMARDII,VELUTINA"));
	}
	

}
