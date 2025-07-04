package week8.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 실패율
 * Author      : Baekgwa
 * Date        : 2025-06-16
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-16     Baekgwa               Initial creation
 */
public class 실패율 {
	// 음
	// 각 스테이지 별 몇명이 있는지, 빠르게 계산이 가능해야됨. 중복된 계산을 처음부터 하지 않도록 하는게 핵심.
	//스테이지 배열 길이가 200,000 이기때문에, 잘못하면 200,000^2 계산을 해야되서 시간초과 예정

	class Solution {
		public int[] solution(int stageCount, int[] userStages) {

			// 스테이지 별, 사용자 몇명 머물고 있는지 확인
			int[] stage = new int[stageCount + 2];
			for (int st : userStages) {
				stage[st]++;
			}

			// 각 스테이지 별, 실패율 계산
			double[] failRate = calculateFail(stageCount, stage, userStages.length);

			// 정렬
			// 정렬 조건 : 실패율 높은 순서대로 (내림차순), 같으면 스테이지 번호 오름차순
			Integer[] sortedStages = sortResult(stageCount, failRate);

			return Arrays.stream(sortedStages).mapToInt(Integer::intValue).toArray();
		}

		private double[] calculateFail(int stageCount, int[] stage, int playerCount) {
			double[] failRate = new double[stageCount];
			int remainCount = playerCount;

			for (int i = 1; i <= stageCount; i++) {
				int currentCount = stage[i];
				failRate[i - 1] = (remainCount == 0) ? 0.0 : (double) currentCount / remainCount;
				remainCount -= currentCount;
			}

			return failRate;
		}

		private Integer[] sortResult(int stageCount, double[] failRate) {
			Integer[] stages = new Integer[stageCount];
			for (int i = 0; i < stageCount; i++) {
				stages[i] = i + 1;
			}

			Arrays.sort(stages, (a, b) -> {
				double rateA = failRate[a - 1];
				double rateB = failRate[b - 1];
				if (Double.compare(rateB, rateA) != 0) {
					return Double.compare(rateB, rateA);
				}
				return Integer.compare(a, b);
			});

			return stages;
		}
	}
}
