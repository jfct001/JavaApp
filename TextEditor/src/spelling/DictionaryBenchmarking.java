package spelling;


/** A class for timing the Dictionary Implementations
 */

public class DictionaryBenchmarking {

	
	public static void main(String [] args) {

	    int trials = 500;

	    // The text to test on
	    String dictFile = "data/dict.txt";
		
	    // The amount of words to increment each step
		int increment = 2000;

		// The number of steps to run.  
		int numSteps = 20;
		
		// The number of words to start with. 
		int start = 50000;
		
		String notInDictionary = "notaword";
		
		for (int numToCheck = start; numToCheck < numSteps*increment + start; 
				numToCheck += increment)
		{
			// Time the creation of finding a word that is not in the dictionary.
			DictionaryLL llDict = new DictionaryLL();
			DictionaryBST bstDict = new DictionaryBST();
			
			DictionaryLoader.loadDictionary(llDict, dictFile, numToCheck);
			DictionaryLoader.loadDictionary(bstDict, dictFile, numToCheck);
			
			long startTime = System.nanoTime();
			for (int i = 0; i < trials; i++) {
				llDict.isWord(notInDictionary);
			}
			long endTime = System.nanoTime();
			long timeLL = (endTime - startTime);  
			
			startTime = System.nanoTime();
			for (int i = 0; i < trials; i++) {
				bstDict.isWord(notInDictionary);
			}
			endTime = System.nanoTime();
			long timeBST = (endTime - startTime);
			
			System.out.println(numToCheck + "\t" + timeLL + "\t" + timeBST);
			
		}
	
	}
	
}
