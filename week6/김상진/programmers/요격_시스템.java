package week6.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 요격_시스템
 * Author      : sangxxjin
 * Date        : 2025. 6. 2.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 2.     sangxxjin               Initial creation
 */
public class 요격_시스템 {
	// 정렬만 하면 어려운 문제는 아니였음.
	//
	import java.util.*;
	class Solution {
		public int solution(int[][] targets) {
			Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

			int answer = 0;
			int lastEnd = -1;

			for (int[] target : targets) {
				if (target[0] >= lastEnd) {
					answer++;
					lastEnd = target[1];
				}
			}

			return answer;
		}
	}


}
