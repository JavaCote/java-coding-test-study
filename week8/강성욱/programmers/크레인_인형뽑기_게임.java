package week8.강성욱.programmers;

import java.util.Stack;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 크레인_인형뽑기_게임
 * Author      : Baekgwa
 * Date        : 2025-06-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-17     Baekgwa               Initial creation
 */
public class 크레인_인형뽑기_게임 {

	//주의할점. moves 배열에서 가져올때, 값들은 -1 해서 써야됨. 인덱스로 쓰려면

	class Solution {
		public int solution(int[][] board, int[] moves) {
			Stack<Integer>[] stArray = new Stack[board[0].length];
			Stack<Integer> st = new Stack<>();

			for (int i = 0; i < board[0].length; i++) {
				stArray[i] = new Stack<>();
			}

			// stArray 에 인형 쌓아두기
			// 스택이라서, y축은 역순으로 읽어야함.
			for (int x = 0; x < board[0].length; x++) {
				for (int y = board[0].length - 1; y >= 0; y--) {
					int now = board[y][x];
					if (now != 0) {
						stArray[x].push(now);
					}
				}
			}

			//움직임에 따라서 정리
			int result = 0;
			for (int move : moves) {
				int x = move - 1;
				if (!stArray[x].isEmpty()) {
					int now = stArray[x].pop();

					if (!st.isEmpty() && st.peek() == now) {
						st.pop();
						result += 2;
					} else {
						st.push(now);
					}
				}
			}

			return result;
		}
	}
}
