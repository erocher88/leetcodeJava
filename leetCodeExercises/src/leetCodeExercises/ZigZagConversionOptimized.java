package leetCodeExercises;

public class ZigZagConversionOptimized {
	public static String convert(String s, int numRows) {
		if (numRows == 1 || s.length() <= numRows) {
			return s;
		}
		
		int row = 0, direction = 0;
		StringBuilder[] stringB = new StringBuilder[numRows];
		
		//Initialize array
		for (int i = 0; i < stringB.length; i++) {
			stringB[i] = new StringBuilder();
		}
		
		//Iterate word
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			row += direction;
			stringB[row].append(c);
			//The append is up or down?
			if (row == 0 || row == numRows - 1) {
				direction = (direction == 0) ? 1 : -direction;
			}
		}
		return convert(stringB);
	}
	
	public static String convert(StringBuilder[] stringB) {
		StringBuilder result = new StringBuilder();
		for (StringBuilder letters : stringB) {
			result.append(letters);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		long begin = System.nanoTime();
		String answer = convert("sdjfhalksdfjhkjasbvckjdsbclaskjdriiuhellkasjdclkasjdblkajfhaslkjdfjh", 4);
		long end = System.nanoTime();
		double time = end - begin;
		System.out.println(answer);
		System.out.println(time);
	}
}
