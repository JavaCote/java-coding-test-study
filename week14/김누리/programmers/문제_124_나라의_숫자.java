package week14.김누리.programmers;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : 문제_124_나라의_숫자
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-26
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 26.     김누리(NRKim)               Initial creation
 */

/*
10 진법    124 나라
 1          1
 2          2
 3          4
 4          11 --> 1 + 1
 5          12 --> 1 + 2
 6          14 --> 1 + 4
 7          21 --> 2 + 1

 규칙은 보임.

 그러면 저 규칙대로 반복문 돌려가면서 문자를 만들면 됨 ㅇㅇ

*/


public class 문제_124_나라의_숫자 {
	public String solution(int n) {
		int[] nums = {1,2,4}; //  1,2,4 로 구성할 값
		StringBuilder sb = new StringBuilder();
		String answer = "";

		while(n > 0) {
			n--; //  n값 -1
			sb.insert(0,nums[n%3]); //  맨 앞 자리에 nums[0],nums[1],nums[2] 순번으로 적재
			n /= 3; //  n값 / 3
		}

		answer = sb.toString();

		return answer;
	}
}
