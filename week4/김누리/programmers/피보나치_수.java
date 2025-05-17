package week4.김누리.programmers;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 피보나치_수
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 17.     김누리(NRKim)               Initial creation
 */

public class 피보나치_수 {
	public int solution(int n) {
		int answer = 0;
		int x = 1234567;

		int a = 0;
		int b = 1;

		if (n == a) answer = a % x;
		if (n == b) answer = b % x;

		for(int i = 2; i <= n; i++) {
			int sum = (a + b) % x;
			answer = sum;
			a = b;
			b = sum;
		}

		return answer;
	}
}
