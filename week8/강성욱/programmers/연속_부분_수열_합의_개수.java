package week8.강성욱.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 연속_부분_수열_합의_개수
 * Author      : Baekgwa
 * Date        : 2025-06-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-17     Baekgwa               Initial creation
 */
public class 연속_부분_수열_합의_개수 {
	class Solution {
		public int solution(int[] elements) {
			int n = elements.length;
			Set<Integer> sumSet = new HashSet<>();

			for (int start = 0; start < n; start++) {
				int sum = 0;

				for (int len = 1; len <= n; len++) {
					int idx = (start + len - 1) % n;
					sum += elements[idx];
					sumSet.add(sum);
				}
			}

			return sumSet.size();
		}
	}
}
