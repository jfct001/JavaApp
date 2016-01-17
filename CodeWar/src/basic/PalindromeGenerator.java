package basic;

public class PalindromeGenerator {
	
	/*
	 *  StringBuffer in Java: thread-safe and mutable sequence of characters
	 */
	
	public boolean isPalindrome(String word) {
  	String reverseWord = new StringBuffer(word).reverse().toString();
		return word.toLowerCase().equals(reverseWord.toLowerCase());
	}
	
	public String generateString(String word) {
		if (isPalindrome(word)) {
			return word;
		}else {
			String reverseWord = new StringBuffer(word).reverse().toString();
			return new StringBuffer(word).append(reverseWord).toString();
    	}
	}
}
