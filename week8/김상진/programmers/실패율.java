package week8.김상진.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 실패율
 * Author      : sangxxjin
 * Date        : 2025. 6. 18.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 18.     sangxxjin               Initial creation
 */
public class 실패율 {
	//정렬 부분 관련해서 단순한 정렬은 곧잘하는데 이번 정렬은 바로 못풀었음.

	import java.util.*;
	class Solution {
		public int[] solution(int N, int[] stages) {
			int[] stageCount = new int[N + 2]; // 1~N, N+1까지 포함
			//스테이지 index에 값 넣기
			for (int stage : stages) {
				stageCount[stage]++;
			}

			int totalPlayers = stages.length;
			List<StageFailure> list = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				// 해당 스테이지 실패한 개수
				int fail = stageCount[i];
				// 실패율 계산
				double failureRate = (totalPlayers == 0) ? 0 : (double) fail / totalPlayers;
				// list에 스테이지별 실패율 넣기
				list.add(new StageFailure(i, failureRate));
				// 총 인원수 차감.
				totalPlayers -= fail;
			}

			list.sort((a, b) -> {
				if (b.failureRate != a.failureRate)
					return Double.compare(b.failureRate, a.failureRate); // 실패율 내림차순
				return Integer.compare(a.stage, b.stage); // 같으면 스테이지 번호 오름차순
			});

			int[] answer = new int[N];
			for (int i = 0; i < N; i++) {
				answer[i] = list.get(i).stage;
			}

			return answer;
		}

		static class StageFailure {
			int stage;
			double failureRate;
			StageFailure(int stage, double failureRate) {
				this.stage = stage;
				this.failureRate = failureRate;
			}
		}
	}

}
