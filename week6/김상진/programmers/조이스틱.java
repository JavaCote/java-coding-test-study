package week6.김상진.programmers;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 조이스틱
 * Author      : sangxxjin
 * Date        : 2025. 6. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 6.     sangxxjin               Initial creation
 */
public class 조이스틱 {
	class Solution {
		public int solution(String name) {
			int len = name.length();
			int answer = 0;

			// 상하 조작 계산
			for (int i = 0; i < len; i++) {
				char c = name.charAt(i);
				int move = Math.min(c - 'A', 'Z' - c + 1);
				answer += move;
			}

			// 좌우 조작 최소 계산
			int minMove = len - 1; // 좌우로 끝까지 가는 경우 기본값

			for (int i = 0; i < len; i++) {
				int next = i + 1;

				// A 연속 구간 찾기
				while (next < len && name.charAt(next) == 'A') {
					next++;
				}

				// 우로 i칸 갔다가 ← 반대로 돌아와서 끝까지 가는 경우 고려
				// i : 우로 가는 거리
				// len - next : 반대로 돌아간 후 다시 끝까지 가는 거리
				int move = i + i + (len - next);
				minMove = Math.min(minMove, move);

				// ← 갔다가 다시 → 가는 케이스도 포함
				move = (len - next) * 2 + i;
				minMove = Math.min(minMove, move);
			}

			answer += minMove;
			return answer;
		}
	}

}
