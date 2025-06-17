/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 크레인_인형뽑기_게임
 * Author      : sangeok
 * Date        : 2025. 6. 17.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 17.     sangeok               Initial creation
 */

// 크레인 인형뽑기 게임
//
//문제 요구사항 : 	board size : 5x5 <= 30x30
//			board : 0은 빈칸 1~100의 숫자는 각기 다른 인형 모양 의미
//			터트려 사라진 인형의 개수
//
//접근 방식 :	stack 사용
//
// 	0 0 0 0 0
//	0 0 1 0 3
// 	0 2 5 0 1
//	4 2 4 4 2
// 	3 5 1 3 1

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++){
            int col = moves[i]-1;

            for(int row = 0; row < board[0].length; row++){
                if(board[row][col] != 0 ){

                    int picked = board[row][col];
                    board[row][col] = 0;

                    if (!stack.isEmpty() && stack.peek() == picked) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(picked);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}