package week14.강성욱.programmers;

/**
 * PackageName : week14.강성욱.programmers
 * FileName    : 최대공약수와_최대공배수
 * Author      : Baekgwa
 * Date        : 2025-07-28
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-28     Baekgwa               Initial creation
 */
public class 최대공약수와_최대공배수 {
	class Solution {
		public int[] solution(int n, int m) {
			int[] result = new int[2];

			result[0] = calMin(n, m); //최대공약수
			result[1] = (n * m) / result[0];

			return result;
		}

		// 유클리드 호제법
		// GCD(a, b) = GCD(b, a % b)
		private int calMin(int n, int m) {
			if (m == 0) return n;
			return calMin(m, n % m);
		}
	}
}
