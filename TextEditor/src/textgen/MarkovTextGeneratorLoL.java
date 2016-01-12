package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		String[] words = sourceText.split("[\\s.]+");
		starter = words[0];
		ListNode prevWord = new ListNode(starter);
		wordList.add(prevWord);
		String curWord;
		int findIndex;
		for (int i = 1; i < words.length; ++i)
		{
			curWord = words[i];
			// check to see if "prevWord" is already a node in the wordList
			findIndex = findWord(prevWord.getWord());
			// if "prevWord" is a node in the list
			if (findIndex != -1) { 			
				prevWord.addNextWord(curWord);
			} else {
				// if "prevWord" is not a node in the list, add a node with prevWord.getWord() to the wordList
				wordList.add(prevWord);
				prevWord.addNextWord(curWord);
			}
			findIndex = findWord(curWord);
			if (findIndex != -1) {
				prevWord = wordList.get(findIndex);
			} else {
				prevWord = new ListNode(curWord);
			}

		}
		// for the last word in the text, set starter into its nextWord.
		findIndex = findWord(prevWord.getWord());
		if (findIndex == -1) {
			wordList.add(prevWord);
			wordList.get(wordList.size()-1).addNextWord(starter);
		} else {
			wordList.get(findIndex).addNextWord(starter);
		}
		
		return;
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		
		//  If the generator has not yet been trained, return empty string
		if (wordList.size() == 0) {
			return "";
		}
		
		String output = "";
		String curWord = output;
		String newWord;
		int i = 0;
		int nodeIndex;
		while (i < numWords)
		{
			//  find the "node" corresponding to "currWord" in the list
			//  if curWord == "" randomly return index
			if (curWord.isEmpty())
			{
				nodeIndex = Math.abs(rnGenerator.nextInt() % wordList.size());
			} else {
				nodeIndex = findWord(curWord);
			}
			// select a random word "newWord" from the list "nextWords" for "node"
			newWord = wordList.get(nodeIndex).getRandomNextWord(rnGenerator);
			// add the newWord to output
			output += newWord + " ";
			// reset curWord to be newWord
			curWord = newWord;
			i++;
		}
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		starter = "";
		wordList.clear();
		train(sourceText);
	}
	
	/** find word in the wordList **/
	private int findWord(String word) {
		ListNode curNode;
		for (int i = 0; i < wordList.size(); ++i) {
			curNode = wordList.get(i);
			if (curNode.getWord().equals(word)) {
				return i;
			}
		}
		return -1; // word doesn't exist in wordList
	}
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int index = generator.nextInt();
		index %= nextWords.size();
		index = Math.abs(index);
	    return nextWords.get(index);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


