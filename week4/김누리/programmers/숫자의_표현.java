package week4.김누리.programmers;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 숫자의_표현
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 17.     김누리(NRKim)               Initial creation
 */

public class 숫자의_표현  {
	public int solution(int n) {
		int answer = 0;

		for(int i = 0; i < n; i++) {
			int sum = 0;

			for(int j = i+1; j <= n; j++) {
				sum += j;

				//  sum의 값이 타겟 n 값이랑 같으면 answer++
				if(sum == n) {
					answer++;
					break;
				}

				//  sum이 타겟 n 값 보다 크면 2번째 for문은 종료
				if(sum > n) {
					break;
				}
			}
		}

		return answer;
	}
}
