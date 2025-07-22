package week12.김누리.programmers;

/**
 * PackageName : week12.김누리.programmers
 * FileName    : 퍼즐_게임_챌린지
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-18
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 18.     김누리(NRKim)               Initial creation
 */

/*

문제만 보고는 감이 안옴. 검색을 통해 확인해 보니 이진 탐색을 통해 진행하면 된다고 하지만?

이진 탐색을 위해 추려나가야 될 범위를? 못잡아서 다른 사람의 풀이를 참조함.

재풀이 필요

*/

public class 퍼즐_게임_챌린지 {
	public int solution(int[] diffs, int[] times, long limit) {
		int n = times.length;
		long min = 1;
		long max = limit;

		while(min <= max) {
			long level = (min + max) / 2;
			long spent = 0;

			for(int i = 0; i < n; ++i) {
				if(level < diffs[i]) {
					spent += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
				} else {
					spent += times[i];
				}
			}

			if(spent > limit) {
				min = level +1;
			} else {
				max = level -1;
			}
		}

		return (int) min;
	}
}
