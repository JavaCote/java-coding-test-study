package week13.강성욱.programmers;

/**
 * PackageName : week13.강성욱.programmers
 * FileName    : 징검다리_건너기
 * Author      : Baekgwa
 * Date        : 2025-07-24
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-24     Baekgwa               Initial creation
 */
public class 징검다리_건너기 {
	// 최대 200,000 개의 돌, 200,000,000의 돌값을 가지고 있어, 완탐으로 풀면, 너무 큼

	// n번 건넜을 때, k만큼 0이 반복되는걸 확인
	// 그럼, 가장 작은 숫자가 k번 반복되는걸 찾으면 되는거 아닌가?
	// 그 k개 중, 가장 큰값이 0이 될만큼 뛰는 순간, 그다음은 뛸 수 없음.
	// 그때 답은 가장 큰 돌의 값
	// 은, [1, 100, 50, 60], k=2 에서 안됨.
	// 합이 가장 작은 셋트는 101인데, 얘는 101명까지 수용가능하나, [50, 60] 셋트를 생각하면 60명까지 가능
	// 다른방법

	// 이진탐색 활용?
	// mid 값 정해서, stones[i]-mid 값해서 0이하가 k번 반복되면 해당 값은 못건너는 인원수 mid 값

	// 테-케1번 불통과...? 뭐냐
	// right 범위는 더 크게 잡아주니 ㄱㅊ

	class Solution {
		public int solution(int[] stones, int k) {
			int result = 0;
			int right = Integer.MAX_VALUE;
			int left = 0;

			while (left < right) {
				int mid = left + (right - left) / 2;
				int cnt = 0;
				boolean fail = false; //건널 수 있는지 없는지. true = 못건너는 큰 mid 상태. (혹은 정답)

				for (int stone : stones) {
					if (stone < mid) {
						cnt++;
						if (cnt == k) {
							fail = true;
							break;
						}
					} else {
						cnt = 0;
					}
				}

				if (fail) {
					right = mid;
				} else {
					result = mid;
					left = mid + 1;
				}
			}

			return result;
		}
	}
}
