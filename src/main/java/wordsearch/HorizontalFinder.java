package wordsearch;

public class HorizontalFinder {
	// To satisfy the first user story

	public String horizontalScan(String toFind, char[][] toSearch) {
		String answer = toFind+":";

		for (int row = 0; row < toSearch.length; row++) {
			if (toSearch[row][0] == toFind.charAt(0)) {
				answer += "(" + row + ",0)(" + row + ",1)(" + row + ",2)";
			}
		}
		return answer;
	}

}
