package week10.강성욱.programmers;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 제일_작은_수_제거하기
 * Author      : Baekgwa
 * Date        : 2025-07-02
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-02     Baekgwa               Initial creation
 */
public class 제일_작은_수_제거하기 {
	class Solution {
		public int[] solution(int[] arr) {

			if (arr.length == 1) return new int[]{-1};

			int min = Integer.MAX_VALUE;
			int minIndex = Integer.MAX_VALUE;

			for(int i=0; i<arr.length; i++) {
				if(min > arr[i]) {
					min = arr[i];
					minIndex = i;
				}
			}

			int index = 0;
			int[] result = new int[arr.length-1];
			for(int i=0; i<arr.length; i++) {
				if(i == minIndex) continue;
				result[index++] = arr[i];
			}
			return result;
		}
	}
}
