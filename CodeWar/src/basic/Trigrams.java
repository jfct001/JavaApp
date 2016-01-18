package basic;

public class Trigrams {
	public static String trigrams(String phrase) {
		if (phrase.length() < 3) return "";
		// replace whitespace with _
		phrase = phrase.replaceAll("\\s", "_");
		
		StringBuffer gramString = new StringBuffer();
		gramString.append(phrase.substring(0,3));
		// iterate through the string
		for(int i = 1; i < phrase.length()-2; i++) {
			// we need add white space in the solution
			gramString.append(" " + phrase.substring(i, i+3));
		}
		return gramString.toString();
	}
}
