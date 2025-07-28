package week14.김누리.programmers;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : 최대공약수와_최소공배수
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-28
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 28.     김누리(NRKim)               Initial creation
 */

/*

공약수랑 공배수의 경우 이전에 풀이했던 유클리드 호제법 이용

*/

public class 최대공약수와_최소공배수 {
	public int[] solution(int n, int m) {
		int gcd = gcd(n,m);

		return new int[] { gcd, (n*m) / gcd };
	}

	public int gcd(int n, int m) {
		//  b값이 0이면 a 값만 반환
		return m == 0 ? n : gcd(m, n % m);
	}
}
