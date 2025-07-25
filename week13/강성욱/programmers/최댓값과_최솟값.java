package week13.강성욱.programmers;

/**
 * PackageName : week13.강성욱.programmers
 * FileName    : 최댓값과_최솟값
 * Author      : Baekgwa
 * Date        : 2025-07-22
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-22     Baekgwa               Initial creation
 */
public class 최댓값과_최솟값 {

	class Solution {
		public String solution(String s) {
			String[] sArray = s.split(" ");
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (String numStr : sArray) {
				int num = Integer.parseInt(numStr);
				if (num > max) max = num;
				if (num < min) min = num;
			}

			return min + " " + max;
		}
	}
}
