package week6.김누리.programmers;

import java.util.LinkedList;
import java.util.List;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 하노이의_탑
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 02.     김누리(NRKim)               Initial creation
 */

/*
1 에서 3으로
n = 1인 경우
1 > 3 ==> return 1;

n = 2인 경우
1 > 2
1 > 3
2 > 3

n = 3인 경우
1 > 3
1 > 2
3 > 2
1 > 3
2 > 1
2 > 3
1 > 3

*/

public class 하노이의_탑 {
	List<int[]> lst = new LinkedList<>();

	public int[][] solution(int n) {
		dfs(n,1,2,3);

		int[][] answer = new int [lst.size()][];
		int idx = 0;

		for(int[] arr : lst) {
			//
			answer[idx++] = arr;
		}
		return answer;
	}

	//  left : 1번탑, mid : 2번탑, right : 3번탑
	public void dfs (int n, int left, int mid, int right) {
		if ( n == 1 ) {
			lst.add(new int[] {left,right});
			return;
		}

		//  1번 탑에서 하나 씩 빼서 2번 3번 순으로
		dfs(n-1,left,right,mid);

		//  이동 궤적을 적재
		lst.add(new int[] {left,right});

		//  2번 탑에서 하나 씩 빼서 1번 3번 순으로
		dfs(n-1,mid,left,right);
	}
}
