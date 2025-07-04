package week8.김누리.programmers;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 기사단원의_무기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-18
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 18.     김누리(NRKim)               Initial creation
 */

public class 기사단원의_무기 {
	class Solution {
		public int solution(int number, int limit, int power) {
			int answer = 0;
			int knight = 1;

			//  약수 갯수 구하며 무기 수치 제한
			for(int i = 0; i < number; i++) {
				int cnt = 0;

				//  기사단의 수가 많아지면 약수의 갯수가 쌍을 이루기 때문
				for(int j = 1; j*j <= knight; j++) {
					if(knight % j == 0) {
						cnt++;

						//  j가 제곱근일 때 처리
						if ( j != knight / j) cnt++;
					}
				}

				if(cnt > limit) cnt = power;
				answer += cnt;

				knight++;
			}

			return answer;
		}
	}
}
