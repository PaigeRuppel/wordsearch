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

}
