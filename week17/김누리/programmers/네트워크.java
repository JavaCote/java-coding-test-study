package week17.김누리.programmers;

/**
 * PackageName : week17.김누리.programmers
 * FileName    : 네트워크
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-19
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 19.     김누리(NRKim)               Initial creation
 */

/*
n = 3
computers = [
    [1, 1, 0], >> 1번 - 2번 연결
    [1, 1, 0], >> 1번 - 2번 연결
    [0, 0, 1]  >> 3번 - 연결 X
]

이러면 연결된 갯수는 0

computers = [
    [1, 0, 0], >> 1번 - 연결 X
    [0, 1, 0], >> 2번 - 연결 X
    [0, 0, 1]  >> 3번 - 연결 X
]

computers = [
    [1, 1, 0], >> 1번 - 2번 연결
    [1, 1, 1], >> 1번 - 2번 - 3번 연결
    [0, 1, 1]  >> 2번 - 3번 연결
]

단순 연결 여부를 보는거면 dfs로 ㄱㄱㄱ

*/

public class 네트워크 {
	boolean[] visited;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(i,computers);
				answer++;
			}
		}

		return answer;
	}

	private void dfs(int n, int[][] computers) {
		visited[n] = true;

		for(int i = 0; i < computers.length ; i ++) {
			//  해당 부분 방문 되어 있거나, 연결 되어 있다? 카운트 증가
			if(!visited[i] && computers[n][i] == 1) {
				dfs(i,computers);
			}
		}
	}
}
