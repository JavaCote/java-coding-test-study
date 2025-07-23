package week13.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week13.김누리.programmers
 * FileName    : 징검다리_건너기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-23
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 23.     김누리(NRKim)               Initial creation
 */

/*
디딤돌을 밟으면 밟은 디딤돌은 내구도 --
내구도가 0인 디딤돌은 pass
내구도가 0은 디딤돌이 연속으로 k개 존재한다면? 횡단 불가 ==> 내구도가 0인 돌 + 내구도가 0이 아닌 도착 돌 <= K여야 슈퍼 점프 가능

그렇게 해서 건넌 사람 수를 ++ 하면 됨

그러면 배열의 크기나..... 내구성을 보면? 완전 탐색은 불가능 20만 * 200만 ? 프로그램이 난죽택을 선택함

이진 탐색을 통해

left right? 비교하며 위치를 조정해가며 ㄱㄱ 하면 될거 같은데?

*/

public class 징검다리_건너기 {
	public int solution(int[] stones, int k) {
		int answer = 0;

		answer = binarySearch(stones,k);

		return answer;
	}

	//  이진 탐색용 함수
	public int binarySearch(int[] stones, int k) {
		int left = 1; //  최초 위치 1
		int right = Arrays.stream(stones).max().getAsInt(); //  내구도가 가장 큰 인자를 right에
		int complete = 0;

		while(left <= right) {
			int mid = (left + right) / 2;

			if(canCross(stones, k, mid)) {
				complete = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return complete;
	}

	//  건널 수 있는지 확인
	public boolean canCross(int[] stones, int k, int p) {
		int skip = 0; //  연속 점프 가능한 돌 수

		for(int s : stones) {
			if (s - p < 0) {
				//  돌 - 인수 >= 0 인 경우 계속 ㄱㄱ
				skip++;

				//  연속되는 돌 수가 K 이상이면 못건넘
				if(skip >= k) return false;
			} else {
				skip = 0;
			}
		}

		return true;
	}
}
