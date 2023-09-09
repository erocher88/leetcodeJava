package leetCodeExercises;

public class LongestPalindromeOptimized {

	public static int[] expandWord(String s, int start, int end) {
		int[] answer = new int[2];
		answer[0] = 0;
		answer[1] = 0;
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		if (answer[1] < end - start -1) {
			answer[0] = start + 1;
			answer[1] = end - start - 1;
		}
		return answer;
	}
	
	public static String longestPalindrome(String s) {
		int[] index = new int[2];
		index[0] = 0;
		index[1] = 0;
		if (s.length() < 2) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			int[] case1 = expandWord(s, i, i);
			int[] case2 = expandWord(s, i, i + 1);
			if (case1[1] > index[1]) {
				index = case1;
			}
			if (case2[1] > index[1]) {
				index = case2;
			}
		}
		
		return (s.substring(index[0], index[0] + index[1]));
	}
	
	public static void main(String[] args) {
		String test = "cbbd";
		String answer = longestPalindrome(test);
		System.out.println(answer);
	}
}
