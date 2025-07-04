package week3.김누리.programmers;

/**
 * PackageName : week3.김누리.programmers
 * FileName    : 이웃한_칸
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-12
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 12.     김누리(NRKim)               Initial creation
 */


/*
case 1 :

[
	["blue", "red", "orange", "red"],
	["red", "red", "blue", "orange"],
	["blue", "orange", "red", "red"],
	["orange", "orange", "red", "blue"]
]

  h : 1, w : 1 == >
  board[1][1] ==>
  참조 가능 좌표 :
   x	[0,1]     x
 [1,0] 	[1,1]	[1,2]
   x	[2,1]     x

target[1,1] ==> red
[0,1] ==> red ==> answer++
[1,0] ==> red ==> answer++
[1,2] ==> blue
[2,1] ==> orange


case 2 :
[
    ["yellow", "green", "blue"],
    ["blue", "green", "yellow"],
    ["yellow", "blue", "blue"]
]
h : 0, w : 1

board[0][1] ==> green

[0,0] [0,1] [0,2]
  x   [1,1]   x

  0,0 ==> yellow
  0,2 ==> blue
  1,1 ==> green ==> answer++
*/
public class 이웃한_칸 {
	public int solution(String[][] board, int h, int w) {
		int answer = 0;
		String color = board[h][w]; // 타겟 색상
		int a = board.length; // x축 길이
		int b = board[0].length; // y축 길이

		//  체크 가능한 좌표 [w-1][h], [w+1][h], [w][h-1], [w][h+1]
		if(h > 0 && board[h-1][w].equals(color)) answer++; // 바로 위에 있는 색상 측정
		if(h < a-1 && board[h+1][w].equals(color)) answer++; // 바로 아래에 있는 색상 측정
		if(w > 0 && board[h][w-1].equals(color)) answer++; // 바로 왼쪽에 있는 색상 측정
		if(w < b-1 && board[h][w+1].equals(color)) answer++; // 바로 오른쪽에 있는 색상 측정

		return answer;
	}
}
