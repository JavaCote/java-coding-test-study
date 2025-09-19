package week21.강성욱.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week21.강성욱.programmers
 * FileName    : 혼자_놀기의_달인
 * Author      : Baekgwa
 * Date        : 2025-09-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-19     Baekgwa               Initial creation
 */
public class 혼자_놀기의_달인 {
	// 최대 cards 가 100개임.


	// [1,2,3,4,5,6,7,8] 인덱스
	// [8,6,3,7,2,5,1,4]
	// 8, 4, 7, 1 묶음
	// 6, 2, 5 묶음
	// 아 순환 발생하면 끝이구나, 즉, 다음에 가야할 곳이 visited 면, 해당 묶음 끝
	// 묶음은 엄청 많이 나올 수 있는데, 이걸 모두 묶어보고, 가장 큰거 두개 곱하면 됨.

	class Solution {
		public int solution(int[] cards) {
			List<Integer> resultList = new ArrayList<>(); // 묶음 사이즈의 리스트
			boolean[] visited = new boolean[cards.length];

			for(int idx=0; idx<cards.length; idx++) {
				if(visited[idx]) continue; //이미 들린곳이면 안감

				resultList.add(getCycle(idx, cards, visited));
			}

			if(resultList.size() < 2) return 0;
			Collections.sort(resultList);
			//가장 큰거 두개 곱해서 return;
			return resultList.get(resultList.size()-1) * resultList.get(resultList.size()-2);
		}

		private int getCycle(int idx, int[] cards, boolean[] visited) {
			int count = 0;
			int nowIdx = idx;

			while (!visited[nowIdx]) {
				visited[nowIdx] = true;
				count++;
				nowIdx = cards[nowIdx] - 1;
			}

			return count;
		}
	}
}
