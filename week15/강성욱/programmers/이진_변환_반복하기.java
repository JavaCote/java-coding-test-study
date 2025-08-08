package week15.강성욱.programmers;

/**
 * PackageName : week15.강성욱.programmers
 * FileName    : 이진_변환_반복하기
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 이진_변환_반복하기 {
	class Solution {
		public int[] solution(String s) {
			// String a = "1111";
			// System.out.print("a : " + a.length());
			// System.out.print("\n");
			// String b = "111";
			// System.out.print("b : " + b.length());
			int[] result = new int[2];

			while(!s.equals("1")) {
				int zeroCount = s.length() - s.replace("0", "").length();
				result[1] += zeroCount;
				int oneCount = s.length() - zeroCount;
				s = Integer.toString(oneCount, 2);
				result[0]++;
			}

			return result;
		}
	}
}
