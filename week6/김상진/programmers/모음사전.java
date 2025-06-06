package week6.김상진.programmers;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 모음사전
 * Author      : sangxxjin
 * Date        : 2025. 6. 3.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 3.     sangxxjin               Initial creation
 */
public class 모음사전 {
	// 처음에 순서를 이해하는게 시간이 걸렸음.
	class Solution {
		static String[] vowels = {"A", "E", "I", "O", "U"};
		static int index = 0;
		static int answer = 0;
		static boolean found = false;

		public int solution(String word) {
			dfs("", word);
			return answer;
		}

		private void dfs(String current, String target) {
			if (current.equals(target)) {
				found = true;
				answer = index;
				return;
			}
			if (current.length() == 5) return;

			for (int i = 0; i < vowels.length; i++) {
				if (found) return;
				index++;
				dfs(current + vowels[i], target);
			}
		}
	}

}
