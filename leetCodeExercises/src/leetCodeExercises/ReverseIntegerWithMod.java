package leetCodeExercises;

public class ReverseIntegerWithMod {
	public static int reverseIntegerMod(int x) {
		long answer = 0;
		while (x != 0) {
			answer = answer * 10 + x % 10;
			x /= 10;
		}
		if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
			return 0;
		}
		return (int)answer;
	}
	
	public static void main(String[] args) {
		long begin = System.nanoTime();
		int answer = reverseIntegerMod(214748364);
		long end = System.nanoTime();
		double time = end - begin;
		System.out.println(answer);
		System.out.println(time);
	}
}
