package week8.김상진.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 크레인_인형뽑기_게임
 * Author      : sangxxjin
 * Date        : 2025. 6. 18.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 18.     sangxxjin               Initial creation
 */
public class 크레인_인형뽑기_게임 {
	import java.util.*;

	class Solution {
		public int solution(int[][] board, int[] moves) {
			int answer = 0;
			// 이동한 공간
			Deque<Integer> moved = new ArrayDeque<>();
			for (int move : moves) {
				// 실제로 0부터 시작
				int col = move - 1;
				//행을 내려가면서 검사
				for (int row = 0; row < board.length; row++) {
					int doll = board[row][col];
					if (doll != 0) {
						board[row][col] = 0;
						if (!moved.isEmpty() && moved.peekFirst() == doll) {
							moved.pollFirst();
							answer += 2;
						} else {
							moved.offerFirst(doll);
						}

						break;
					}
				}
			}
			return answer;
		}
	}
}
