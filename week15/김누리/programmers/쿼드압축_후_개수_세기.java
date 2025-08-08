package week15.김누리.programmers;

/**
 * PackageName : week15.김누리.programmers
 * FileName    : 쿼드압축_후_개수_세기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-08
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 08.     김누리(NRKim)               Initial creation
 */

/*
dfs를통해 재귀로 한 구역을 체크

체크를 진행하며 해당 구역이 전부 1이다? 그러면 oneCnt += 1
1과 0이 혼재하는경우

if(1인 조건) oneCnt++;
else if(0인 조건) zeroCnt++;


answer[0] = zeroCnt;
answer[1] = oneCnt;
*/

public class 쿼드압축_후_개수_세기 {
	int oneCnt = 0;
	int zeroCnt = 0;

	public int[] solution(int[][] arr) {
		int[] answer = new int[2];
		int size = arr.length;

		dfs(arr,0,0,size);

		answer[0] = zeroCnt; // 0의 갯수
		answer[1] = oneCnt;  // 1의 갯수

		return answer;
	}

	//  색션 탐색
	public void dfs (int[][]arr, int x, int y, int size) {
		if(isSame(arr,x,y,size)) {
			//  한 섹터의 모든 수가 동일한 경우 1이면 1의 갯수 증가,
			//  아니면 0의 갯수 증가
			if(arr[x][y] == 1) oneCnt++;
			else zeroCnt++;
			return;
		}

		//  구역 재설정
		int newSize = size/2;

		//  좌상
		dfs(arr,x,y,newSize);

		//  우상
		dfs(arr,x,y + newSize,newSize);

		//  좌하
		dfs(arr,x + newSize,y,newSize);

		//  우하
		dfs(arr,x + newSize,y + newSize,newSize);

	}

	//  섹터 내 모든 숫자가 동일한 값인지 체크
	public boolean isSame(int[][]arr, int x, int y, int size) {
		int base = arr[x][y];

		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y+ size; j++) {
				if (arr[i][j] != base) return false;
			}
		}

		return true;
	}
}
