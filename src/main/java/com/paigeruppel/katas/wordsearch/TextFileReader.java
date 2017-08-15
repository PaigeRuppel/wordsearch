package com.paigeruppel.katas.wordsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFileReader {

	public ArrayList<String> readFirstLine(String textFile) {
		String firstLine = "";
		try {
			FileReader fileRead = new FileReader(new File(textFile));
			BufferedReader buffRead = new BufferedReader(fileRead);
			firstLine = buffRead.readLine();
			
			buffRead.close();
		}
		catch (IOException e) {
            e.printStackTrace();
        }
		ArrayList<String> listToFind = new ArrayList<String>(Arrays.asList(firstLine.split(",")));

		return listToFind;
	}

	public char[][] buildLetterGrid(String starTrekFile) {
		char[][] letterGrid = {
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
		return letterGrid;
	}

}
