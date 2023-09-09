package leetCodeExercises;

public class ZigzagConversionBruteForce {

	public static void print2dArray(String[][] array) {
		for (String[] rows : array) {
			for (String columns : rows) {
				System.out.print(columns + " ");
			}
			System.out.println();
		}
	}
	
	public static int noColumns(int len, int rows) {
		int columns = 0;
		if (rows == 1) {
			return len;
		} 
		if (rows >= len) {
			return 1;
		}
		while (len > 0) {
			len -= rows;
			columns++;
			if (len > rows -2) {
				len = len - rows + 2;
				columns = columns + rows - 2;
			} else if (len <= rows -2 && len > 0) {
				columns += len;
				len = len - rows + 2;
			}
		}
		return columns;
	}
	
	public static String convert(String s, int numRows) {
		boolean flag = false;
		String answer = "";
		if (numRows == 1 || s.length() <= numRows) {
			return s;
		}
		//Initializing array
		String[][] array = new String[numRows][noColumns(s.length(), numRows)];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < noColumns(s.length(), numRows); j++) {
				array[i][j] = "/";
			}
		}
		//Replacing characters
		for (int counter = 0, rowFlag = 1, i = 0, j =0; counter < s.length(); counter++) {
			if (rowFlag == 1) {flag = false;}
			if (rowFlag == numRows) {flag = true;}
			array[i][j] = "" + s.charAt(counter);
			
			if (flag == false) {
				i++;
				rowFlag++;
			} else if (flag == true){
				i--;
				j++;
				rowFlag--;
			}
		}
		//print2dArray(array);
		//Convert to String
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < noColumns(s.length(), numRows); j++) {
				if (array[i][j] != "/") {
					answer += array[i][j];
				}
			}
		}
		return answer;
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
