package com.paigeruppel.katas.wordsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

	public String readFirstLine(String textFile) {
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
		return firstLine;
	}

}
