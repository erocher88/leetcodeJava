package leetCodeExercises;

public class MyAtoiOptimized {
	public static int stringToInt(String s) {
		int sign = 1, index = 0;
		long answer = 0;
		
		if (s == null || s.trim().length() == 0) return 0;
		
		while (s.charAt(index) == ' ') {
			index++;
		}
		
		if (s.charAt(index) == '+' || s.charAt(index) == '-') {
			sign = (s.charAt(index) == '-') ? -1 : sign;
			index++;
		}
		
		for (int i = index; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) == false) {
				break;
			} else if (Character.isDigit(s.charAt(i))) {
				answer = answer * 10 + Long.parseLong("" + s.charAt(i));
			}
			if (answer * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if (answer * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		}
		return (int)answer*sign;
	}
	
	public static void main(String[] args) {
		long begin = System.nanoTime();
		int answer = stringToInt("       -7687687986978");
		long end = System.nanoTime();
		double time = end - begin;
		System.out.println(answer);
		System.out.println(time);
	}
}
