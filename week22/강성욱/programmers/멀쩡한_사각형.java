package week22.강성욱.programmers;

/**
 * PackageName : week22.강성욱.programmers
 * FileName    : 멀쩡한_사각형
 * Author      : Baekgwa
 * Date        : 2025-09-26
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-26     Baekgwa               Initial creation
 */
public class 멀쩡한_사각형 {
	// 정사각형이면 쉬운데, 아닐 경우가 빡셈
	// 세로로 엄청 긴 직사각형이면?
	// 근데 모르겠고, 일딴 패턴이 있는듯?
	// 아무리 큰 직사각형이라도, 가로 세로 기준으로 최대 공약수를 구하면 미니멀한 직사각형을 구하고, 그걸 체크하면 복잡도가 확 낮아질듯?
	// 예시에서 보면, X x Y = 8 x 12
	// 최대 공약수는 4?
	// 그럼 가로는 2 X 3 임
	// 2X3 에서, 계산을 통해 구하면, 4개
	// 최대 공약수 만큼 곱해주면 16개
	// 원래 96 - 16 = 80 개?
	// 그럼, 2 X 3 에서, 지나가는 곳을 어떻게 체크하면 좋을까?
	// 가로 + 세로 - 1
	// 이게 되네? 왠지는 모름
	class Solution {
		public long solution(int W, int H) {
			long w = Long.valueOf(W);
			long h = Long.valueOf(H);
			long g = gcd(w, h);
			long totalCount = w * h;

			return totalCount - (((w / g) + (h / g) - 1) * g);
		}

		private long gcd(long a, long b) {
			while (b > 0) {
				long temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}
	}

}
