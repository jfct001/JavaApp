package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrigramsTest {

	@Test
	public void test() {
		assertEquals(Trigrams.trigrams("the quick red"), "the he_ e_q _qu qui uic ick ck_ k_r _re red");
	}

}
