package week5.김누리.programmers;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 피로도
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-28
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 28.     김누리(NRKim)               Initial creation
 */

/*
  단순히 반복문만 쓰면 되는줄 알았지만 그건 아님.
  재귀를 반복하며 백트래킹을 진행해 봐야하다보니, dfs를 채용해야 함
*/

public class 피로도 {
	int answer = 0;
	public int solution(int k, int[][] dungeons) {
		//  방문 여부 배열 생성
		boolean[] visited = new boolean[dungeons.length];

		//  재귀 호출
		dfs(k,dungeons,0,visited);

		return answer;
	}

	public void dfs (int k, int[][] dungeons, int cnt, boolean[] visited) {
		// answer값 최신화
		answer = Math.max(answer,cnt);

		//  던전 만큼 반복
		for(int i = 0; i < dungeons.length; i++) {
			if(!visited[i] && dungeons[i][0] <= k) {
				visited[i] = true;  //  던전 방문 가능하다? 그러면 우선 방문처리

				//  총합 피로도 깎고, 재귀 호출
				dfs(k-dungeons[i][1],dungeons,cnt+1,visited);

				//  방문 여부 초기화
				visited[i] = false;
			}
		}
	}
}
