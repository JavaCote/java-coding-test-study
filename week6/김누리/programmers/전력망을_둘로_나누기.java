package week6.김누리.programmers;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 전력망을_둘로_나누기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 01.     김누리(NRKim)               Initial creation
 */

/*
dfs를 채용.

노드간 간선을 끊었을 때, 갯수선을 끊었을 때, 송전탑의 숫자를 카운트 해야 함
예)
1-3 부분을 끊으면? 끊어진 곳 : 1 이외 : 8
( 2-3/ 4-5/ 4-6/ 7-8/ 7-9 ) 부분을 끊으면? 상동
3-4 부분을 끊으면? 끈어진 곳 : 3 이외 : 6
(4-7) 부분을 끊으면? 상동



*/

public class 전력망을_둘로_나누기 {
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;

		for( int i = 0; i < wires.length ; i++ ) {
			boolean[] visited = new boolean[n+1];
			int left = dfs(1,wires,i,visited); // 간선을 끊은 후 한쪽의 노드 갯수
			int right = n - left; // 총 노드 갯수 - left
			answer = Math.min(answer, Math.abs(left - right));
		}

		return answer;
	}

	public int dfs(int n, int[][] wires, int cutIdx, boolean[] visited) {
		visited[n] = true;
		int cnt = 1;
		//  간선 만큼 반복
		for(int i = 0; i < wires.length; i++) {
			//  절삭 대상 idx인 경우는 패스
			if( i == cutIdx ) continue;

			int a = wires[i][0]; // 시작 점
			int b = wires[i][1]; // 끝 점

			if (a == n && !visited[b]) {
				//  a 위치에서 b에 방문 안했을 때
				cnt += dfs(b,wires,cutIdx,visited);
			} else if (b == n && !visited[a]) {
				//  b 위치에서 a에 방문 안했을 때
				cnt += dfs(a,wires,cutIdx,visited);
			}
		}

		return cnt;
	}
}
