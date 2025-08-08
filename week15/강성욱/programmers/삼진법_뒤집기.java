package week15.강성욱.programmers;

/**
 * PackageName : week15.강성욱.programmers
 * FileName    : 삼진법_뒤집기
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 삼진법_뒤집기 {

	class Solution {
		public int solution(int n) {
			//3진법 String 으로 변환
			n = 11;
			String wlsqjq3 = Integer.toString(n, 3);
			System.out.print(wlsqjq3);

			//reverse
			StringBuffer sb = new StringBuffer(wlsqjq3);

			String result = sb.reverse().toString();
			return Integer.valueOf(result, 3);
		}
	}
}
