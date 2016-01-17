package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeGeneratorTest {
	

	@Test
	public void testIsPalindrome() {
		
		// My Class to be tested
	    PalindromeGenerator pg = new PalindromeGenerator();
	    
		assertEquals("isPalindrome return false", false, pg.isPalindrome("noob")); 
		assertEquals("IsPalindrome With Success", true, pg.isPalindrome("otto"));
		assertEquals("isPalindrome return false", false, pg.isPalindrome("noo")); 
		assertEquals("IsPalindrome With Success", true, pg.isPalindrome("otTo"));
	    
	}

	@Test
	public void testGenerateString() {
		
		// My Class to be tested
	    PalindromeGenerator pg = new PalindromeGenerator();
	    
	    assertEquals("GenerateString With Palindrome", "Otto", pg.generateString("Otto"));
	    assertEquals("GenerateString Without Palindrome", "noobboon", pg.generateString("noob"));
	    assertEquals("GenerateString With Case Palindrome", "NoobbooN", pg.generateString("Noob"));
	    assertEquals("GenerateString With Odd Palindrome", "AbccbA", pg.generateString("Abc"));
	    
	}

}
