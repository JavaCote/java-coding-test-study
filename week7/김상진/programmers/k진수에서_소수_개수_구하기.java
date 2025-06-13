package week7.김상진.programmers;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : k진수에서_소수_개수_구하기
 * Author      : sangxxjin
 * Date        : 2025. 6. 10.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 10.     sangxxjin               Initial creation
 */
public class k진수에서_소수_개수_구하기 {
	// 진수변환 참고 블로그 -> https://priming.tistory.com/27
	// 모르는 문법이 많았음.
	import java.util.*;

	class Solution {
		public int solution(int n, int k) {
			// n을 k진수로 변환
			String baseK = Integer.toString(n, k);
			// 0을 기준으로 분할 -> 0이 여러개면 알맞게 적용
			String[] tokens = baseK.split("0+");
			int count = 0;

			for (String token : tokens) {
				if (token.isEmpty()) continue;

				long num = Long.parseLong(token);
				if (isPrime(num)) {
					count++;
				}
			}

			return count;
		}

		private boolean isPrime(long num) {
			if (num < 2) return false;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) return false;
			}
			return true;
		}
	}

}
