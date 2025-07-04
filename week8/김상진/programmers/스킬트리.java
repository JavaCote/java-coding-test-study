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
				//스킬트리 먼저 stack에 저장
				Deque<Character> deque = new ArrayDeque<>();
				for (char c : skill.toCharArray()) {
					deque.offerLast(c);
				}

				boolean isValid = true;
				for (char current : str.toCharArray()) {
					//스킬트리에 없는 스킬이면 continue
					if (!skill.contains(String.valueOf(current))) continue;
					// 스킬트리에 순서대로 있다면 pop
					if (!deque.isEmpty() && current == deque.peekFirst()) {
						deque.pollFirst();
					//순서대로 있지 않다면 false 종료
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
