package week8.김상진.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 스킬트리
 * Author      : sangxxjin
 * Date        : 2025. 6. 15.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 15.     sangxxjin               Initial creation
 */
public class 스킬트리 {
	import java.util.*;

	class Solution {
		public int solution(String skill, String[] skill_trees) {
			int answer = 0;

			for (String str : skill_trees) {
				Deque<Character> deque = new ArrayDeque<>();
				for (char c : skill.toCharArray()) {
					deque.offerLast(c);
				}

				boolean isValid = true;
				for (char current : str.toCharArray()) {
					if (!skill.contains(String.valueOf(current))) continue;

					if (!deque.isEmpty() && current == deque.peekFirst()) {
						deque.pollFirst();
					} else {
						isValid = false;
						break;
					}
				}

				if (isValid) answer++;
			}

			return answer;
		}
	}

}
