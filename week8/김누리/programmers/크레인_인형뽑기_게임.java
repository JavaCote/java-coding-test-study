package week8.김누리.programmers;

import java.util.Stack;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 크레인_인형뽑기_게임
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-18
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 18.     김누리(NRKim)               Initial creation
 */

/*
초기 셋팅

board
[
    [0,0,0,0,0],
    [0,0,1,0,3],
    [0,2,5,0,1],
    [4,2,4,4,2],
    [3,5,1,3,1]
]

moves
[1,5,3,5,1,2,1,4]

int a = moves[i]-1;

임시 Stack

int b =board[j][a];

Stack<Integer>st = new Stack<>();

Stack이 empty이다? 일단 put

| |
| |
|4|
|2|
|4|
 _

board
[
    [0,0,0,0,0],
    [0,0,0,0,0],
    [0,0,5,0,0],
    [0,2,4,4,2],
    [0,5,1,3,1]
]

moves
[1,"5","3","5","1",2,1,4]

*/

public class 크레인_인형뽑기_게임 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer>stk = new Stack<>();

		// 이동 수 만큼 반복
		for(int i = 0 ; i < moves.length; i++) {
			int target = moves[i]-1; //  moves[i] = 1 ==> 가장 첫번째 즉 0번 idx임
			//
			for(int j = 0; j < board.length; j++) {

				if(board[j][target] != 0) {
					// 스택이 비어있으면 일단 push
					if(stk.isEmpty() || stk.peek() != board[j][target]) {
						stk.push(board[j][target]);
					} else {
						//  스택이 비어있지 않을 경우, 옮겨올 인형과 스택의 가장 위에 있는 인형 비교. 같은 인형이면 한 쌍의 인형(2개)이 삭제되니 +2
						if(stk.peek() == board[j][target]) {
							stk.pop();
							answer += 2;
						}
					}
					board[j][target] = 0;
					break;
				}
			}
		}

		return answer;
	}
}
