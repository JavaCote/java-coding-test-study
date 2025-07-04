package week10.강성욱.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 광물_캐기
 * Author      : Baekgwa
 * Date        : 2025-07-03
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-03     Baekgwa               Initial creation
 */
public class 광물_캐기 {
	// minerals 5덩어리씩 나누자.
	// 돌곡괭이 기준으로, 점수 매겨서 우선순위 정하기
	// 흠 이건 아이디어 + 구현이 뭔가 너무 안되서 gpt 도움을 좀 받았습니다
	// 이제는 이해 됨

	class Solution {
		public int solution(int[] picks, String[] minerals) {
			int n = (minerals.length + 4) / 5;
			List<Mine> chunks = new ArrayList<>();

			// 5개씩 덩어리 분리 및 Mine 객체 생성
			for (int i = 0; i < n; i++) {
				int d = 0, ir = 0, st = 0;
				for (int j = i * 5; j < Math.min((i + 1) * 5, minerals.length); j++) {
					if (minerals[j].equals("diamond")) d++;
					else if (minerals[j].equals("iron")) ir++;
					else st++;
				}
				chunks.add(new Mine(d, ir, st));
			}

			// 돌곡괭이 grade 기준 내림차순 정렬
			chunks.sort((a, b) -> b.grade - a.grade);

			int idx = 0;
			int fatigue = 0;
			for (int pickType = 0; pickType < 3; pickType++) {
				for (int cnt = 0; cnt < picks[pickType]; cnt++) {
					if (idx >= chunks.size()) break;
					fatigue += chunks.get(idx++).fatigue(pickType);
				}
			}

			return fatigue;
		}

		private static class Mine {
			private final int diamondCnt;
			private final int ironCnt;
			private final int stoneCnt;
			private final int grade; //돌곡괭이 기준 피로도

			public Mine(int diamondCnt, int ironCnt, int stoneCnt) {
				this.diamondCnt = diamondCnt;
				this.ironCnt = ironCnt;
				this.stoneCnt = stoneCnt;
				this.grade = diamondCnt * 25 + ironCnt * 5 + stoneCnt;
			}

			public int fatigue(int pickType) {
				if(pickType == 0) return diamondCnt + ironCnt + stoneCnt;
				else if(pickType == 1) return diamondCnt * 5 + ironCnt + stoneCnt;
				else return diamondCnt * 25 + ironCnt * 5 + stoneCnt;
			}
		}
	}
}
