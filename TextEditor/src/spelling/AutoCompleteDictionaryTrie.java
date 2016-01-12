package spelling;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
		String lowWord = word.toLowerCase();
		if (lowWord.length() == 0) return false;
		char letter = lowWord.charAt(0);
		TrieNode nextNode = root.getChild(letter);
		
		if (nextNode == null) {
			nextNode = root.insert(letter);
		}

		for (int i = 1; i < lowWord.length(); ++i) {
			letter = lowWord.charAt(i);
			if (nextNode.getValidNextCharacters().contains(letter)) {
				nextNode = nextNode.getChild(letter);
			} else {
				nextNode = nextNode.insert(letter);
			}
		}
		// already a word in the trie
		if (nextNode.endsWord()) {
			return false;
		} else {
			// set current word is valid word in the trie before return!
			nextNode.setEndsWord(true);
			this.size++;
			return true;
		}
	    // return !nextNode.endsWord();
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    return this.size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
		TrieNode nextNode = findPrefix(s);
		if (nextNode == null) return false;
		// reach this step means all the letters are in the trie
		// use the function endsWord to indicate whether this word is in the trie
		return nextNode.endsWord();
	}
	
	/** find the word as a prefix in the trie 
	 * @return return the last trieNode of the word in the trie
	 * 		   return null if this prefix or word is not in the trie
	 * **/
	private TrieNode findPrefix(String s)
	{
		String newWord = s.toLowerCase();
		// empty string is not a word in trie
//		if (newWord.length() == 0) return null;  is "" in the trie?
		if (newWord.length() == 0) return root;
		// set the first nextNode as the child of root 
		TrieNode nextNode = root.getChild(newWord.charAt(0));
		// if nextNode is null, the word is not in the trie
		if (nextNode == null) return null;
		char letter;
		// loop through remaining letters in the string
		// return false when the nextNode is null
		for(int i = 1; i < newWord.length(); ++i)
		{
			letter = newWord.charAt(i);
			nextNode = nextNode.getChild(letter);
			if (nextNode == null) return null;
		}
		return nextNode;
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // algorithm procedure:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 List<String> completions = new LinkedList<String>();
    	 TrieNode nextNode = findPrefix(prefix);
    	 
    	 if (nextNode == null) return completions;
    	 // if current prefix is valid word, add it into completions.
    	 if (nextNode.endsWord()) {
    		 completions.add(nextNode.getText());
    	 }

    	 LinkedList<TrieNode> q = new LinkedList<TrieNode>();
    	 
    	 for(Character c: nextNode.getValidNextCharacters()) {
    		 q.addLast(nextNode.getChild(c));
    	 }
    	 
    	 while (q.size() != 0) {
    		 if (completions.size() >= numCompletions) {
    			 return completions;
    		 }
    		 TrieNode cNode = q.removeFirst();
    		
    		 if (cNode.endsWord()) {
    			 completions.add(cNode.getText());
    		 }
    		 // breath-first search for children node
    		 for(Character c: cNode.getValidNextCharacters()) {
	    		 q.addLast(cNode.getChild(c));
	    	 }
    	 }

         return completions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	
}