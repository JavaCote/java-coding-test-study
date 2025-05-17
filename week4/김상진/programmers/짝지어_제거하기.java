package week4.김상진.programmers;

import java.util.Stack;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 짝지어_제거하기
 * Author      : sangxxjin
 * Date        : 2025. 5. 17.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 17.     sangxxjin               Initial creation
 */
public class 짝지어_제거하기 {
	import java.util.*;
	class Solution
	{
		public int solution(String s)
		{
			Stack<Character> stack = new Stack<>();
			for(int i=0; i< s.length(); i++){
				if(!stack.isEmpty() && stack.peek() == s.charAt(i))stack.pop();
				else stack.push(s.charAt(i));
			}
			if(stack.isEmpty())return 1;
			return 0;
		}
	}
}
