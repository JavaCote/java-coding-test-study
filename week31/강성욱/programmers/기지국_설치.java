package week31.강성욱.programmers;

/**
 * PackageName : week31.강성욱.programmers
 * FileName    : 기지국_설치
 * Author      : Baekgwa
 * Date        : 25. 12. 2.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 2.     Baekgwa               Initial creation
 */
public class 기지국_설치 {
	// 간격으로 확인?
	// 그냥 설치를 하면서, 이번에 설치한 부분이, 기존 설치된 기지국에 영향을 받는곳에 있다면 스킵?
	// 빈 구간을 확인해야함.
	// 이걸 List 로 정리해서 각 구간별로 추가로 설치해야될껄 계산하면 될듯?

	class Solution {
		public int solution(int n, int[] stations, int w) {
			// 전파 된 범위 확인
			int start = 1;
			int result = 0;
			int cover = w * 2 + 1;

			for(int station : stations) {
				int left = start;
				int right = station - w - 1;

				result += calc(left, right, cover);

				start = station + w + 1;
			}

			//만약 끝까지 가지 못하면, 빈곳 한번 더 처리해야함.
			// start ~ 끝까지
			if(start <= n) {
				result += calc(start, n, cover);
			}
			// System.out.println(emptyList.toString());

			return result;
		}

		private int calc(int left, int right, int cover) {
			int gap = right - left + 1;
			if (gap <= 0) return 0;
			return (gap + cover - 1) / cover;
		}
	}
}
