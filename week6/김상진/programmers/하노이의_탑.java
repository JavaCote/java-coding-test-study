package week6.김상진.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 하노이의_탑
 * Author      : sangxxjin
 * Date        : 2025. 6. 5.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 5.     sangxxjin               Initial creation
 */
public class 하노이의_탑 {
	// 알고리즘 이해하는데 고생함..
	import java.util.*;

	class Solution {
		public List<int[]> solution(int n) {
			List<int[]> result = new ArrayList<>();
			move(n, 1, 3, 2, result);
			return result;
		}

		private void move(int n, int from, int to, int via, List<int[]> result) {
			if (n == 1) {
				result.add(new int[]{from, to});
				return;
			}
			move(n - 1, from, via, to, result);
			result.add(new int[]{from, to});
			move(n - 1, via, to, from, result);
		}
	}
}
