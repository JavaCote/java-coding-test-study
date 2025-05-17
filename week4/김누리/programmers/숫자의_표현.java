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

			// sum에 1부터 n 까지 반복하며 sum == n이면 answer ++ 아니면 반복 종료
			for(int j = i+1; j <= n; j++) {
				sum += j;

				if(sum == n) {
					answer++;
					break;
				} else if(sum > n){
					break;
				}
			}
		}

		return answer;
	}
}
