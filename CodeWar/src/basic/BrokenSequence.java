package basic;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class BrokenSequence {
	public int findMissingNumber(String sequence) {	
		if(sequence.equals("")) return 0;
		int missing = 0;

		List<String> numList = new ArrayList<String>(Arrays.asList(sequence.split(" ")));
		
		if (!numList.get(0).equals("1")) return 1;
		
		if (numList.size() == 0) return 1;
  
		for (String num : numList) {
			int curNum = Integer.parseInt(num);
			if ((curNum - missing) != 1) {
				return missing + 1;
			}
			missing = curNum;
		}
  
		return 0;
	}
}