package week6.강성욱.programmers;

/**
 * PackageName : week6.강성욱.programmers
 * FileName    : 조이스틱
 * Author      : Baekgwa
 * Date        : 2025-06-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-05     Baekgwa               Initial creation
 */
public class 조이스틱 {
	// 맨처음에는, 첫번째 위치에서 시작.
	// 첫번째를 맞추고, 두번째 or 마지막 으로 이동하는건, 이득인지 아닌지 해봐야 암.
	// 즉, 계산의 영역이 아님.
	// 그럼, dfs 로 해서 현재까지 몇번 움직였는지 nowCount 로 확인을 한 후.
	// 다음 좌 + 우로 이동해서 맞추도록 이동?
	// 몇번째 맞추고 있는지 확인이 필요. (종료 조건으로 활용)

	// 아 이거 dfs 쓰면 더 복잡하다.
	// 이거 그냥 단순 계산해도 되겠다.
	// 문제되는 부분이, 좌우로 어디로 움직이는게 최적화 인지 인데,
	// ABAAAAAAAAAAAB 이런 케이스의 경우
	// 좌측으로 한번가서 마지막꺼 맞추고, 다시 우측으로 두번 움직이면 끝임.
	// 즉, 이미 맞춘 곳도 들려야될 수도 있음...
	// 복잡하네;

	class Solution {

		public int solution(String name) {
			int count = 0;
			char[] nameArr = name.toCharArray();

			// 알파벳 실제 맞추는데 소모되는 횟수 계산
			for(char c : nameArr) {
				count += calAlphabet(c);
			}

			count += calculateMinCursorMoves(name);


			return count;
		}

		//앞으로 맞추기
		//EX) A -> C 면, 2번 움직이면됨. 아스키 코드표 기억안나니 대충 A = 100, B = 102 라고 치면, B-A 하면 됨.
		//뒤로 맞추기
		//EX) A -> Y 면, 2번 움직이면 됨.
		//A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
		//1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8
		//A = 1, Y = 27;
		//Z 에서, 목표값 빼고, +1 하면됨.
		private int calAlphabet(char c) {
			int forward = c - 'A';
			int backward = 'Z' - c + 1;
			return Math.min(forward, backward);
		}

		// 이거 이해 안됨. ㅠㅠㅠㅠ
		public int calculateMinCursorMoves(String name) {
			int length = name.length();
			int minMove = length - 1; // 최악의 경우: 오른쪽으로만 이동

			for (int i = 0; i < length; i++) {
				int nextIndex = i + 1;

				// 연속된 'A' 구간을 지나감
				while (nextIndex < length && name.charAt(nextIndex) == 'A') {
					nextIndex++;
				}

				// 커서를 i까지 오른쪽으로 갔다가 → 다시 돌아가서 → nextIndex 이후를 처리
				int moveToI = i;
				int moveToEnd = length - nextIndex;
				int goBack = Math.min(moveToI, moveToEnd);

				int totalMove = moveToI + moveToEnd + goBack;
				minMove = Math.min(minMove, totalMove);
			}

			return minMove;
		}
	}
}
