package week8.김누리.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 연속_부분_수열_합의_개수
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-18
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 18.     김누리(NRKim)               Initial creation
 */

/*
Case 1 :

hashset 이용.

연속 범위가
1인 경우
    7 9 1 1 4

2인 경우
    7 9 ==> 16
    9 1 ==> 10
    1 1 ==>  2
    1 4 ==>  5
    4 7 ==> 11

3인 경우
   7 9 1 ==> 17
   9 1 1 ==> 11
   1 1 4 ==>  6
   1 4 7 ==> 12
   4 7 9 ==> 20

4인 경우
    7 9 1 1 ==> 18
    9 1 1 4 ==> 15
    1 1 4 7 ==> 13
    1 4 7 9 ==> 21

5인 경우
    7 9 1 1 4 ==> 22
*/

public class 연속_부분_수열_합의_개수 {
	public int solution(int[] elements) {
		int answer = 0;
		Set<Integer> set = new HashSet<>(); // 중복 제거용

		//  원형 수열의 배열 만큼 반복
		for(int i = 0; i < elements.length; i++) {
			for(int j = 1; j <= elements.length; j++) {
				int sum = 0;

				//  연속된 수열 만큼 덧셈
				for(int k = 0; k < j; k++) {
					sum += elements[(i+k) % elements.length];
				}
				set.add(sum);
			}
		}

		answer = set.size();

		return answer;
	}
}
