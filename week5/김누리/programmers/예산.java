package week5.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 예산
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-27
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 27.     김누리(NRKim)               Initial creation
 */

/*
1.  d 배열 정렬. ex) case 1 : {1,2,3,4,5}
2.  d의 요소들을 더함. 이 때 오소들의 합이 budget을 초과한다? >> 반복문 종료
*/

public class 예산 {
	public int solution(int[] d, int budget) {
		int answer = 0;
		int sum = 0;

		Arrays.sort(d);

		for(int dv : d) {
			sum += dv;

			if (sum <= budget) answer++;
			else break;
		}

		return answer;
	}
}
