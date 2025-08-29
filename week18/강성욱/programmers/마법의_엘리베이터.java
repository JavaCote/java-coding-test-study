package week18.강성욱.programmers;

/**
 * PackageName : week18.강성욱.programmers
 * FileName    : 마법의_엘리베이터
 * Author      : Baekgwa
 * Date        : 2025-08-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-29     Baekgwa               Initial creation
 */
public class 마법의_엘리베이터 {
	// bfs? 는 확실하게 풀릴듯? 공간 복잡도가 좀 클꺼같긴한데...
	//----
	// 계산으로 가능?
	// 500 이면? 5번? -100,
	// 600 이면? -100 6번? +100 4번에 -1000 한번
	// 그럼 5 초과를 기점으로 하면 될듯?

	// 2554 의 경우
	// 2 => 2번
	// 5 => 5번
	// 5 => 5번
	// 4 => 4번
	// 16번

	// 7533 의 경우
	// 7 => 7->10... 3+1 = 4;
	// 5 => 5;
	// 3 => 3;
	// 3 => 3;
	// 아 이거 역순으로 해야한다.

	class Solution {
		public int solution(int storey) {
			int cnt = 0;
			String s = String.valueOf(storey);
			int[] storeyArray = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				storeyArray[i] = s.charAt(i) - '0';
			}

			boolean nextUp = false;
			for (int i = storeyArray.length - 1; i >= 0; i--) {
				int now = storeyArray[i];
				if(nextUp) now += 1;
				nextUp = false;

				if (now > 5) {
					cnt += 10 - now;
					nextUp = true;
				} else if (now < 5) {
					cnt += now;
				} else {
					int next = (i > 0) ? storeyArray[i - 1] : 0;
					if (next >= 5) {
						cnt += 5;
						nextUp = true;
					} else {
						cnt += 5;
					}
				}
			}
			if (nextUp) cnt += 1;
			return cnt;
		}
	}
}
