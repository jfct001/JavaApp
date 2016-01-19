package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracketsCheckerTest {

	@Test
	public void simpleTests() {
		assertTrue(BracketsChecker.bracketsChecker("(hello evrybody)"));
		assertFalse(BracketsChecker.bracketsChecker("} - bracket"));
		assertFalse(BracketsChecker.bracketsChecker("[1] - the first example without ("));
	}

}
