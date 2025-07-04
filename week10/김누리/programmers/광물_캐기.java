package week10.김누리.programmers;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 광물_캐기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 02.     김누리(NRKim)               Initial creation
 */

/*
picks = {1,2,3}
  idx = 0 : 다이아 곡괭이 갯수
  idx = 1 : 철 곡괭이 갯수
  idx = 2 : 돌 곡괭이 갯수

minerals = ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]

idx = 0(다이아 곡괭이)로 다이아 캐면 피로도 +1/
idx = 0(다이아 곡괭이)로 철 캐면 피로도 +1/
idx = 0(다이아 곡괭이)로 돌 캐면 피로도 +1/

idx = 1(철 곡괭이)로 다이아 캐면 피로도 +5/
idx = 1(철 곡괭이)로 철 캐면 피로도 +1/
idx = 1(철 곡괭이)로 돌 캐면 피로도 +1/

idx = 2(돌 곡괭이)로 다이아 캐면 피로도 +25/
idx = 2(돌 곡괭이)로 철 캐면 피로도 +5/
idx = 2(돌 곡괭이)로 돌 캐면 피로도 +1/

dfs?? 이중 for문 ??


*/
public class 광물_캐기 {
	int min = Integer.MAX_VALUE;
	int[][] fatigue = { {1,1,1}, {5,1,1}, {25,5,1} }; // 곡괭이별 피로도 표

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		dfs(picks, minerals, 0,0);

		return min;
	}


	private void dfs (int[] picks, String[] minerals, int idx, int total) {
		//  현재 위치가 광물 길이 초과 및 각 곡괭이들의 갯수가 0인 경우 재귀 종료
		if( idx > minerals.length || picks[0] == 0 && picks[1] == 0 && picks[2] == 0 ) {
			min = Math.min(min, total);
			return;
		}

		//  각 곡괭이 모두 시도
		for(int i = 0; i < 3; i++) {
			if(picks[i] > 0) {
				picks[i]--;  // 곡괭이 소모
				int sum = 0;

				// 피로도 누적
				for (int j = idx; j < idx+5 && j < minerals.length; j++) {
					int mineralIdx = 2; // 돌
					if (minerals[j].equals("diamond")) mineralIdx = 0; //  다이아몬드의 idx
					else if (minerals[j].equals("iron")) mineralIdx = 1; //  쇠의 idx
					sum += fatigue[i][mineralIdx]; //  피로도 합산
				}

				dfs(picks, minerals, idx+5, total + sum);
				picks[i]++; // 곡괭이 복귀
			}
		}
	}
}
