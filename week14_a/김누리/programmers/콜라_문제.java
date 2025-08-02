package week14_a.김누리.programmers;

/**
 * PackageName : week14_a.김누리.programmers
 * FileName    : 콜라_문제
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 02.     김누리(NRKim)               Initial creation
 */

public class 콜라_문제 {
	public int solution(int a, int b, int n) {
		int answer = 0;

		while (n >= a) {
			answer += (n/a) * b;
			n = (n/a) * b +(n%a);
		}

		return answer;
	}
}
