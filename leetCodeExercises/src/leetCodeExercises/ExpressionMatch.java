package leetCodeExercises;

import java.util.ArrayList;

public class ExpressionMatch {

	public static ArrayList<String> stringToArray(String s) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder buffer = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '*' && i != s.length() - 1) {
				buffer.append(s.charAt(i));
			} else if (s.charAt(i) == '*') {
				String pivot = buffer.charAt(buffer.length() - 1) + "*";
				buffer.deleteCharAt(buffer.length() - 1);
				if (buffer.length() != 0)
					result.add(buffer.toString());
				result.add(pivot);
				buffer.setLength(0);
			} else if (i == s.length() - 1) {
				buffer.append(s.charAt(i));
				result.add(buffer.toString());
				buffer.setLength(0);
			}
		}
		return result;
	}

//s is input string, p is sub pattern
	public static int subPatternMatch(String s, String p, int index) {
		if (p.contains("*")) {
			if (p.charAt(0) == '.') {
				while (index < s.length()) {
					index++;
				}
				return index;
			} else {
				while (index < s.length() && p.charAt(0) == s.charAt(index)) {
					index++;
				}
				return index;
			}
		} else {
			int counter = 0;
			while (counter < p.length() && index < s.length()
					&& (p.charAt(counter) == s.charAt(index) || p.charAt(counter) == '.')) {
				counter++;
				index++;
			}
			if (counter == p.length()) {
				return index;
			} else {
				return -1;
			}
		}
	}

//s is input string, p is pattern
	public static boolean isMatch(String s, String p) {
		// if (!p.contains(".") && !p.contains("*") && !s.equals(p)) {
		// return false;
		ArrayList<String> subPatterns = stringToArray(p);
		int index = 0, arrayCounter = 0;

		while (index != -1 && index < s.length() && arrayCounter < subPatterns.size()) {
			index = subPatternMatch(s, subPatterns.get(arrayCounter), index);
			arrayCounter++;
		}
		if (index == s.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		ArrayList<String> test1 = stringToArray(".*c");
		int test2 = subPatternMatch("mississippi", "mi", 0);
		boolean test3 = isMatch("ab", ".*c");
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
	}

}
