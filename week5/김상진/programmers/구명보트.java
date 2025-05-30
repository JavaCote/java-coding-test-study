package week5.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 구명보트
 * Author      : sangxxjin
 * Date        : 2025. 5. 25.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 25.     sangxxjin               Initial creation
 */
public class 구명보트 {
	// 이전에 풀어봤던 문제라 투포인터 문제인걸 기억했음.
	// 무거운 사람을 기준으로 찾는게 중요.
	// 가벼운 사람은 짞을 고를 수 있는 경우가 많음.

	// 문제에서 구명보트에 최대 2명씩 밖에 탈 수 없는걸 놓치면 안되는 문제.
	import java.util.*;

	class Solution {
		public int solution(int[] people, int limit) {
			Arrays.sort(people);
			int left = 0;
			int right = people.length - 1;
			int answer = 0;

			while (left <= right) {
				// 동시에 여려명 태울 수 있는지 제일 무거운 사람과 가벼운 사람의 합을 계산
				if (people[left] + people[right] <= limit) {
					left++;
				}
				right--;
				answer++;
			}

			return answer;
		}
	}

}
