package week8.김상진.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 연속_부분_수열_합의_개수
 * Author      : sangxxjin
 * Date        : 2025. 6. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 16.     sangxxjin               Initial creation
 */
public class 연속_부분_수열_합의_개수 {
	import java.util.*;
	class Solution {
		public int solution(int[] elements) {
			Set<Integer> set = new HashSet<>();
			int n = elements.length;

			// 1~전체 길이
			for (int len = 1; len <= n; len++) {
				// 슬라이딩 윈도우 시작 index
				for (int start = 0; start < n; start++) {
					int sum = 0;
					for (int k = 0; k < len; k++) {
						sum += elements[(start + k) % n];
					}
					set.add(sum);
				}
			}

			return set.size();
		}
	}

}
