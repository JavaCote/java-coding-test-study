package week4.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 과일_장수
 * Author      : sangxxjin
 * Date        : 2025. 5. 17.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 17.     sangxxjin               Initial creation
 */
public class 과일_장수 {
	// 문제를 보고 배열을 정리한 후 각 그룹 별로 가장 작은 값에 개수를 곱하면 된다고 생각
	import java.util.*;
	class Solution {
		public int solution(int k, int m, int[] score) {
			int answer = 0;
			Arrays.sort(score);
			int groupCount = score.length / m;
			int startIndex = score.length - (m * groupCount);
			for (int i = startIndex; i < score.length; i += m) {
				answer += score[i] * m;
			}
			return answer;
		}
	}
}
