package week6.김누리.programmers;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 조이스틱
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 06.     김누리(NRKim)               Initial creation
 */

/*
문자열 배열 생성 {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}
name = NRKIM 인 경우

N를 만들 수 있는 케이스는 up : 13 or down : 13
R을 만들 수 있는 케이스는 up : 17 or down : 9
K을 만들 수 있는 케이스는 up : 10 or down : 16
I을 만들 수 있는 케이스는 up : 8 or down : 18
M을 만들 수 있는 케이스는 up : 12 or down : 14

고로 이 중 Math.min(up,down)의 결과값 answer로

perfect

변경내용

굳이? map을 쓸 이유 ㄴㄴ. 걍 charAt으로 char화 해서 A의 아스키 값 만큼 빼서 진행해도 됨.

그리고, 단지 up, down만 생각할게 아니라 left right 이동 까지 생각을 해야함.

*/

public class 조이스틱 {
	public int solution(String name) {
		int answer = 0;

		//  up, down 부분 고려.
		for(int i = 0; i < name.length(); i++) {
			int up = name.charAt(i) - 'A'; //  현재 문자에서, A의 아스키 값만큼 제외.
			int down = 26 - up;  // 총 26개의 영자 에서 up 만큼 제외
			answer += Math.min(up,down); //  up을 눌렀을 때 최소치인지? 아님 down을 눌렀을 때 최소치인디.
		}

		//  좌 우 커서 이동 변수
		int minMv = name.length() -1;

		for(int i = 0; i < name.length(); i++) {
			int next = i+1;

			while(next < name.length() && name.charAt(next) == 'A') {
				next++; //  A는 기본 생성자. 예를들어 N__에서 left 했을 때 NA_ 이므로 A는 커서 이동 시 자동 생성자이므로, cnt 증가
			}

			//  오른쪽 으로 쭉 가다 왼쪽으로 돌아오는 경우
			minMv = Math.min(minMv,i + i + name.length() - next);

			//  왼쪽으로 쭉 가다 오른쪽으로 돌아오는 경우
			minMv = Math.min(minMv, (name.length() - next) * 2 + i);
		}

		//  좌 우 이동 결과값도 ++
		answer += minMv;

		return answer;
	}
}
