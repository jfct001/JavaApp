package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BracketsChecker {
	
	public static boolean bracketsChecker(String str) {
		Stack<Character> open = new Stack<Character>();
		List<Character> close = new ArrayList<Character>();
		
		for (int i = 0; i < str.length(); ++i) {
			char symbol = str.charAt(i);
			// char is primitive data type, can be compared with ==
			if (symbol == '{' || symbol == '(' || symbol == '[') {
				open.add(symbol);
			} else if (symbol == '}') {
				close.add('{');
			} else if (symbol == ')') {
				close.add('(');
			} else if (symbol == ']') {
				close.add('[');
			}
		}
		
		if (close.size() != open.size()) return false;
		
		while (!close.isEmpty()) {
			char closeSymbol = close.remove(0);
			char openSymbol = open.pop();
			if (closeSymbol != openSymbol) return false;
		}
		
		return true;
	}
}
