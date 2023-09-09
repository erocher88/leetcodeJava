package leetCodeExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MedianSortedArrays {

	public static double findMedian(int[] nums1, int[] nums2) {
		ArrayList<Integer> allNums = IntStream.of(nums1).boxed().collect(Collectors.toCollection(ArrayList::new));
		allNums.addAll(IntStream.of(nums2).boxed().collect(Collectors.toCollection(ArrayList::new)));
		
		Collections.sort(allNums);
		
		if (allNums.size() % 2 == 0) {
			int index = allNums.size() / 2;
			double answer = (allNums.get(index - 1) + allNums.get(index)) / 2.0;
			return answer;
		} else {
			int index = allNums.size() / 2;
			double answer = allNums.get(index);
			return answer;
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		
		double answer = findMedian(nums1, nums2);
		System.out.println(answer);
	}
}
