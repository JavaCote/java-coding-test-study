package week13_a.강성욱.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week13_a.강성욱.programmers
 * FileName    : 짝지어_제거하기
 * Author      : Baekgwa
 * Date        : 2025-07-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-25     Baekgwa               Initial creation
 */
public class 짝지어_제거하기 {
	class Solution
	{
		public int solution(String s)
		{
			Deque<Character> deque = new ArrayDeque<>();

			for(int i=0; i<s.length(); i++) {
				char now = s.charAt(i);
				char lastChar = 0;
				if(!deque.isEmpty()) lastChar = deque.peekLast();

				if(now == lastChar) deque.pollLast();
				else deque.addLast(now);
			}

			return deque.size() == 0 ? 1 : 0;
		}
	}
}
