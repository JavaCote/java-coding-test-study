package week3.김상진.programmers;

/**
 * PackageName : week3.김상진.programmers
 * FileName    : 이웃한_칸
 * Author      : sangxxjin
 * Date        : 2025. 5. 14.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 14.     sangxxjin               Initial creation
 */
public class 이웃한_칸 {
	class Solution {
		public int solution(String[][] board, int h, int w) {
			// 1,2,3의 선언 과정
			int n = board.length;
			int count = 0;
			int[] dh = {0,1,-1,0};
			int[] dw = {1,0,0,-1};
			// 4번 과정
			for(int i =0; i<4; i++){
				// 4-1
				int h_check = h + dh[i];
				int w_check = w + dw[i];
				// 4-2
				if(h_check >= 0 && h_check<n && w_check >=0 && w_check<n){
					if(board[h][w].equals(board[h_check][w_check])) count++;
				}
			}
			return count;
		}
	}
}
