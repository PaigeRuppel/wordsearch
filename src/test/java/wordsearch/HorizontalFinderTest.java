package wordsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HorizontalFinderTest {

	@Test
	public void shouldReturnCatAtOneZeroOneTwo() {
		HorizontalFinder underTest = new HorizontalFinder();
		String toFind = "cat";
		char[][] toSearch = {{'x', 'x', 'x'},{'c','a', 't'},{'x','x','x'}};
		assertThat(underTest.horizontalScan(toFind, toSearch), is("cat:(1,0)(1,1)(1,2)"));
	}
}
