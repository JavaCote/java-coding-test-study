package week20.강성욱.baekjoon;

import java.util.Arrays;

/**
 * PackageName : week20.강성욱.baekjoon
 * FileName    : 에어컨
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */
public class 에어컨 {
	class Solution {
		//a 는 희망온도 != 실내온도 일때 소비전력
		//b 는 희망온도 == 실내온도 일때 소비전력
		public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
			final int totalTime = onboard.length;

			// 온도가 음수일 수 있어 인덱스 조정을 위한 offset 추가
			// -10도 ~ 40도 범위를 0 ~ 50 인덱스로 매핑
			final int offset = 10;
			temperature += offset;
			t1 += offset;
			t2 += offset;

			int[][] dp = new int[totalTime][100];
			for (int i = 0; i < totalTime; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}

			dp[0][temperature] = 0;

			for(int time = 0; time < totalTime-1; time++) {
				for(int temp = 0; temp < 100; temp++) {
					int nowCoast = dp[time][temp];
					// 현재 시간에 존재하지 않는 온도는 스킵
					if(nowCoast == Integer.MAX_VALUE) continue;
					// 사람이 타있는데, 적정 온도(t1 ~ t2) 가 아니면, 스킵
					if(onboard[time] == 1 && (t1 > temp || t2 < temp)) continue;

					// 여기서부터 다음 dp 계산 (다음 줄기들 계산해서 넣어주기)
					// 온도 상승 케이스, 즉 희망온도를 높게 잡은 경우
					// 만약, 외부 온도가 현재 온도보다 높다면 그냥 내버려두고, 아니면 전기 써야함.
					int upCoast = temperature > temp ? 0 : a;
					int upTemp = temp + 1;
					if(upTemp < 100) {
						dp[time+1][upTemp] = Math.min(nowCoast + upCoast, dp[time+1][upTemp]);
					}

					// 온도 유지 케이스
					// 만약, 외부 온도와 현재 온도가 같은 케이스 처리 필요.
					int stayCoast = temperature == temp ? 0 : b;
					dp[time+1][temp] = Math.min(nowCoast + stayCoast, dp[time+1][temp]);

					// 온도 하강 케이스
					// 외부 온도와 비교 후, 케이스 처리
					int downCoast = temperature < temp ? 0 : a;
					int downTemp = temp - 1;
					if(downTemp >= 0) {
						dp[time+1][downTemp] = Math.min(nowCoast + downCoast, dp[time+1][downTemp]);
					}
				}
			}

			// 마지막 dp 에서 가장 작은 값 찾아보기
			// dp[totalTime][~];
			int result = Integer.MAX_VALUE;
			for(int temp = 0; temp < 100; temp++) {
				if (onboard[totalTime - 1] == 1 && (temp < t1 || temp > t2)) {
					continue;
				}
				result = Math.min(result, dp[totalTime - 1][temp]);
			}

			return result;
		}
	}
}
