package leetCodeExercises;

public class MyAtoi {
	public static int stringToInt(String s) {
		int sign = 1;
		long answer = 0;
		
		for (int i = 0, flagStop = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ' && flagStop == 0) {
				continue;
			} else if (flagStop == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				sign = (s.charAt(i) == '-') ? -1 : sign;
				flagStop = 1;
			} else if (Character.isDigit(s.charAt(i)) == false) {
				break;
			} else if (Character.isDigit(s.charAt(i))) {
				answer = answer * 10 + Long.parseLong("" + s.charAt(i));
				flagStop = 1;
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
