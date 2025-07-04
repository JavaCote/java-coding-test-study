package week5.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 구명보트
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 25.     김누리(NRKim)               Initial creation
 */
/*
처음 접근 방법.
일단 Queue를 만들고 people를 queue에 넣고 진행하면 될거라 생각.
그래서 처음에 70 50 80 50 일 때

1차 : 70 50 80 50
limit(100) - 70 = 30 (1명 승차됨);
limit(30) - 50 = -20 (중량오버로 추가 승차 불가); ==> Queue에 다시 offer()
limit(30) - 80 = -50 (중량오버로 추가 승차 불가); ==> Queue에 다시 offer()

그래서 일단 70인 1명 먼저 보냄 answer++;

2차 : 50 80 50
limit(100) - 50 = 50 (1명 승차됨);
limit(50) - 80 = -30 (중량오버로 추가 승차 불가); ==> Queue에 다시 offer()
limit(50) - 50 = 0 (딱중량);

그래서 50을 2명 태운 100키로로 보냄 answer++;

3차 : 80
limit(100) - 80 = 20 (1명 승차됨);
더 태울 사람 없으므로 보낸다 >> answer++;


반례 : people = [20, 50, 50, 80], limit = 100 일 경우

1차 : 20 50 80 50
limit(100) - 20 = 80 (1명 승차됨);
limit(80) - 50 = 30 (2명 승차 완료); ==> 보냄 answer++;

2차 : 80 50
limit(100) - 80 = 20 (1명 승차됨);
limit(20) - 50 = -30 (중량오버로 추가 승차 불가); ==> Queue에 다시 offer()

그래서 80zlfh 1명을 보냄 answer++;

3차 : 50
limit(100) - 50 = 40 (1명 승차됨);
더 태울 사람 없으므로 보낸다 >> answer++;

그러나, 20 + 80으로 1번, 50 + 50으로 2번만 보내면 되는데??

접근방법 변경

1.  정렬 처리 50 50 70 80
2.  left[0번 idx] + right[마지막 idx] <= limit ? left++;
  >>  가벼운 사람 + 무거운 사람 <= limit인지 검증용
3.  2번조건 미충족? right--;
4.  2~3 반복하며 answer++;
*/

public class 구명보트 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		int left = 0;
		int right = people.length -1; // 마지막번 idx

		Arrays.sort(people);

		while (left <= right) {
			//  가장 가벼운 사람 + 가장 무거운 사람이 제한 중량을 안넘는지 판단
			if(people[left] + people[right] <= limit) {
				left++;
			}

			right--;
			answer++;
		}

		return answer;
	}
}
