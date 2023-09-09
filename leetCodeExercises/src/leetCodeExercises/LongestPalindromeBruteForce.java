package leetCodeExercises;

public class LongestPalindromeBruteForce {

	public static boolean isPalindrome(String s) {
		if (s.length() == 0) {
			return false;
		}
		for (int i = 0, j = s.length() - 1; i < s.length()/2; i++, j--) {
			if (s.charAt(i) == s.charAt(j)) {
				//Do nothing
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public static String longestPalindrome(String s) {
		String answer = "";
		if (s.length() == 0) {
			return answer;
        }
        if (s.length() == 1 || isPalindrome(s)) {
        	return s;
        }
        for (int i = s.length() - 1, j = 1; i >= 1; i--, j++) {
        	for (int k = 0; k < j; k++) {
        		if (isPalindrome(s.substring(0+k,i+k))) {
        			return s.substring(0+k,i+k);
        		} else if (isPalindrome(s.substring(s.length()-i-k,s.length()-k))) {
        			return s.substring(s.length()-i-k,s.length()-k);
        		}
        	}
        }
        return answer;
	}
	
	public static void main(String[] args) {
		String test = "cbbd";
		String answer = longestPalindrome(test);
		System.out.println(answer);
	}
}
