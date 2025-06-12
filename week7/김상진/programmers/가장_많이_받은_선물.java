package week7.김상진.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 가장_많이_받은_선물
 * Author      : sangxxjin
 * Date        : 2025. 6. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 12.     sangxxjin               Initial creation
 */
public class 가장_많이_받은_선물 {
	//답지 없이 못 풀었음. -> 구현 이해
	// 다시 풀어볼 문제
	// 각 친구는 다른 친구에게 선물을 줄 수 있음
	// 선물 기록을 바탕으로 다음 달 누가 누구에게 선물을 받을지를 계산
	// 선물을 더 많이 준 사람이 다음 달에 받음
	// 준 수가 같으면 선물 지수 높은 사람이 받음
	// 그것도 같으면 못 받음
	// 가장 많이 선물을 받는 사람의 예상 수를 구하는 문제
	import java.util.*;

	class Solution {
		public int solution(String[] friends, String[] gifts) {
			int n = friends.length;

			// 친구 이름을 인덱스로 매핑 (ex: "muzi" → 0)
			Map<String, Integer> nameToIndex = new HashMap<>();
			for (int i = 0; i < n; i++) {
				nameToIndex.put(friends[i], i);
			}

			// 1. 선물 교환 내역 기록
			int[][] giftMatrix = new int[n][n];  // giftMatrix[i][j]: i가 j에게 준 선물 수
			int[] giftScore = new int[n];        // 선물 지수 = 준 선물 수 - 받은 선물 수

			for (String gift : gifts) {
				String[] parts = gift.split(" ");
				int from = nameToIndex.get(parts[0]);  // 준 사람
				int to = nameToIndex.get(parts[1]);    // 받은 사람

				giftMatrix[from][to]++;    // 선물 횟수 증가
				giftScore[from]++;         // 준 선물 수 증가
				giftScore[to]--;           // 받은 선물 수 감소
			}

			// 2. 다음 달 받을 선물 수 계산
			int[] receiveNextMonth = new int[n];

			// 모든 친구 쌍 (i ≠ j)에 대해 다음 달 예상 선물 수 계산
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;  // 자기 자신 제외

					int send_ij = giftMatrix[i][j];  // i → j
					int send_ji = giftMatrix[j][i];  // j → i

					if (send_ij > send_ji) {
						// i가 더 많이 줬으면 → 다음 달 i가 j에게 받을 수 있음
						receiveNextMonth[i]++;
					} else if (send_ij == send_ji) {
						// 같으면 선물 지수 비교
						if (giftScore[i] > giftScore[j]) {
							receiveNextMonth[i]++;
						}
					}
					// 나머지는 못 받음
				}
			}

			// 3. 가장 많이 받을 수 있는 사람의 수 찾기
			int max = 0;
			for (int val : receiveNextMonth) {
				max = Math.max(max, val);
			}

			return max;
		}
	}
}
