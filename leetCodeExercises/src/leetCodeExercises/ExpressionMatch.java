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
				String pivot = buffer.charAt(buffer.length() -1) + "*";
				buffer.deleteCharAt(buffer.length() - 1);
				if (buffer.length() != 0) result.add(buffer.toString());
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
	
	//s is input string, p is sub pattern, modify to return an int and add parameter index
	public static boolean subPatternMatch(String s, String p) {
		if (p.length() > s.length()) return false;
		int count = s.length();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*') return true;
			if (p.charAt(i) == '.' || (p.charAt(i) == s.charAt(i))) {
				count--;
			} else if (p.charAt(i) != s.charAt(i)) {
				return false;
			}
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//s is input string, p is pattern
	public static boolean isMatch(String s, String p) {
		if (!p.contains(".") && !p.contains("*") && !s.equals(p)) {
			return false;
		}
		ArrayList<String> subPatterns = stringToArray(p);
		for (int i = 0; i < subPatterns.size(); i++) {
			if (subPatternMatch(s, subPatterns.get(i))) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		boolean answer = isMatch("ab", "b*");
		ArrayList<String> test = stringToArray("mis*is.");
		System.out.println(test);
		System.out.println(answer);
	}
}
