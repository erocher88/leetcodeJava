package leetCodeExercises;

public class MyAtoi {
	public static int stringToInt(String s) {
		int flagSign = 1, flagStop = 0, flagEmpty = 0;
		long answer = 0;
		
		for (int i = 0; i < s.length(); i++) {			
			if (answer * flagSign > Integer.MAX_VALUE || answer * flagSign < Integer.MIN_VALUE) {
				break;
			}
			if (flagStop == -1 || s.charAt(i) == '.') break;
			flagSign = (s.charAt(i) != '-' || Character.isDigit(s.charAt(i))) ? flagSign : -1;
			
			if (Character.isDigit(s.charAt(i))) {
				answer = answer * 10 + Long.parseLong("" + s.charAt(i));
				flagStop = 1;
				flagEmpty = 1;
			} else if (s.charAt(i) == ' ') {
				flagStop = (flagEmpty == 1) ? -1 : flagStop;
			} else if (Character.isDigit(s.charAt(i)) == false) {
				flagStop = (flagStop == 1) ? -1 : flagStop;
				flagEmpty = 1;
			}
		}
		answer *= flagSign;
		if (answer > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (answer < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return (int)answer;
		}
	}
	
	public static void main(String[] args) {
		long begin = System.nanoTime();
		int answer = stringToInt("   sdfsdf  dfgdgdfg32848987.1");
		long end = System.nanoTime();
		double time = end - begin;
		System.out.println(answer);
		System.out.println(time);
	}
}
