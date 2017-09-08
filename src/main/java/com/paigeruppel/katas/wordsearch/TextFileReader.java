package com.paigeruppel.katas.wordsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFileReader {

	private File file;
	
	public TextFileReader(String textFile) {
		file = new File(textFile);
	}
	
	public List<String> createListToFindFromFirstLine() {
		String firstLine = "";
		try {
			FileReader fileRead = new FileReader(file);
			BufferedReader buffRead = new BufferedReader(fileRead);
			firstLine = buffRead.readLine();
			buffRead.close();
		}
		catch (IOException e) {
            e.printStackTrace();
        }
		
		List<String> listToFind = new ArrayList<String>(Arrays.asList(firstLine.split(",")));

		return listToFind;
	}

	public char[][] buildLetterGrid() {
		List<char[]> chars = new ArrayList<>();
		try {
			FileReader fileRead = new FileReader(file);
			BufferedReader buffRead = new BufferedReader(fileRead);
			String line;
			String withoutCommas;
			while ((line = buffRead.readLine()) != null) {
				withoutCommas = line.replaceAll(",", "");
				chars.add(withoutCommas.toCharArray());
			}
			buffRead.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		chars.remove(0);
		char[][] letterGrid = chars.toArray(new char[chars.size()][]);
		return letterGrid;
	}

}
