package com.paigeruppel.katas.wordsearch;

import java.io.File;

public class FilePath {

	private ClassLoader classLoader = getClass().getClassLoader();
	
	public String getFullFileName(String fileName) {
		return new File(classLoader.getSystemResource(fileName).getFile()).getAbsolutePath();
	}

}
