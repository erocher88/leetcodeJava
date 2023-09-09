package leetCodeExercises;

public class ReverseIntegerWithString {
	public static int reverseIntegerString(int x) {
		long answer = 0;
		String number = Integer.toString(Math.abs(x));
		StringBuilder stringB = new StringBuilder();
		for (int i = number.length() - 1; i >= 0; i--) {
			stringB.append(number.charAt(i));
		}
		if (x < 0) {
			stringB.insert(0, "-");
		}
		answer = Long.parseLong(stringB.toString());
		if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
			return 0;
		}
		return (int)answer;
	}
	
	public static void main(String[] args) {
		long begin = System.nanoTime();
		int answer = reverseIntegerString(214748364);
		long end = System.nanoTime();
		double time = end - begin;
		System.out.println(answer);
		System.out.println(time);
	}
}
