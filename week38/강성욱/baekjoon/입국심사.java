package week38.강성욱.baekjoon;

/**
 * PackageName : week38.강성욱.baekjoon
 * FileName    : 입국심사
 * Author      : Baekgwa
 * Date        : 26. 1. 20.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 20.     Baekgwa               Initial creation
 */
public class 입국심사 {
	class Solution {
		// 그럼 심사원의 명수는 times size 만큼이네?
		// 그냥 비어있는곳에 갓다 넣어버리면 그게 더 이득인가?
		// 꼭 그렇진 않음.
		// 즉, 지금 비어있는 곳 중, 가장 빨리 입국심사 패스하는 사람한테 할당해줘야 젤 빨리 끝남.
		// ----
		// 근데 입국심사 기다리는 사람이 벌써 10억명임.
		// 즉, 하나씩 iter 돌면 거의 반드시 터짐.
		// 줄여야함.
		// ---
		// 그래서 이분탐색을 쓰면 되는거구나
		// n 초 중에서, 얼만큼 처리할 수 있는지 확인
		// 최소초는 음 그냥 0으로 두고
		// 맥스는 반드시 모두 처리할 수 있는 시간, 즉, n * 1,000,000,000분(분은 솔직히 max 찾는게 낫긴한데, 그냥 이렇게 써도 큰문제는 없지않아?), 걍 max 찾자
		public long solution(int n, int[] times) {
			long result = Long.MAX_VALUE; //모든 사람을 처리할 수 있는 시간

			long max = 0L;
			for(int time : times) {
				max = Math.max(time, max);
			}

			long left = 0L;
			long right = max * n;

			while(left <= right) {
				long mid = (left + right) / 2;

				long nowCount = calcPassCount(mid, times); //현재 mid(시간) 값으로, 몇명이나 처리 가능한지 확인하기

				// 처리 가능하면?
				if(nowCount >= n) {
					right = mid - 1L;
					result = Math.min(mid, result);
					continue;
				} else {
					left = mid + 1L;
					continue;
				}
			}

			return result;
		}

		//현재 mid(시간) 값으로, 몇명이나 처리 가능한지 확인하기
		private long calcPassCount(long mid, int[] times) {
			long count = 0L;

			for(int time : times) {
				count += mid / (long) time;
			}

			return count;
		}
	}
}
