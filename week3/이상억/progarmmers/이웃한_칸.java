package week3.이상억.progarmmers;

/**
 * PackageName : week3.이상억.progarmmers;
 * FileName    : 이웃한_칸
 * Author      : sangeok
 * Date        : 2025. 5. 13.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 13.     sangeok               Initial creation
 */

// 문제 요구사항 ) 위치 [i][j] 가 주어졌을 때 [i-1][j] / [i+1][j]    =>  h  /  [i][j-1] / [i][j+1] => w 을 구함

// 접근 방식 : (1)
// 1) 주어진 h, w 인덱스에 -1/ +1 비교
// 2) 배열에 주어진 범위를 넘지 않게 조건문 추가 후 같을 시 answer ++

// 회고 : 처음에 h > 0 부분에서만 범위를 넘지 않게만 조건문을 추가했어서 런타임 에러 났었음
// 추후 h / w < row - 1 , col -1 부분도 추가해서 해결
// 문제가 어렵게 생겨서 쫄았었는데 막상 읽어보니 별거 없었음


class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        if (h > 0 && board[h - 1][w].equals(board[h][w])) answer++;
        if (h < row - 1 && board[h + 1][w].equals(board[h][w])) answer++;
        if (w > 0 && board[h][w - 1].equals(board[h][w])) answer++;
        if (w < col - 1 && board[h][w + 1].equals(board[h][w])) answer++;

        return answer;
    }
}
