package week9.강성욱.programmers;

/**
 * PackageName : week9.강성욱.programmers
 * FileName    : 덧칠하기
 * Author      : Baekgwa
 * Date        : 2025-06-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-25     Baekgwa               Initial creation
 */
public class 덧칠하기 {
	// 오 머리쓰는문제다
	// 앞에서부터 칠하면 안되나 그냥?
	// 반복문 돌면서 하나씩 확인하고 칠하면 될 것 같은데?

	class Solution {
		public int solution(int n, int m, int[] section) {
			int count = 0;
			int nowCovered = 0;
			for(int sec : section) {
				if(nowCovered >= sec) continue;

				nowCovered = sec + m - 1;
				count++;
			}

			return count;
		}
	}
}
